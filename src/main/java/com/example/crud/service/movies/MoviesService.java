package com.example.crud.service.movies;

import com.example.crud.dto.MoviesDTO;
import com.example.crud.exception.MovieNotFoundException;
import com.example.crud.model.MoviesEntity;
import com.example.crud.repository.MoviesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class MoviesService {
   private final MoviesRepository moviesRepository;

   @Autowired
    public MoviesService(MoviesRepository moviesRepository){
       this.moviesRepository = moviesRepository;
   }

   public List<MoviesDTO> getAllMovies(){
       List<MoviesEntity> movies = moviesRepository.findAll();
       return movies.stream()
               .map(this::convertToDTO)
               .collect(Collectors.toList());
   }

    public MoviesDTO getMovieById(Long id) {
        MoviesEntity movie = moviesRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));
        return convertToDTO(movie);
    }

    public MoviesDTO createMovie(@Valid MoviesDTO movieDTO) {
        MoviesEntity movie = convertToEntity(movieDTO);
        MoviesEntity savedMovie = moviesRepository.save(movie);
        return convertToDTO(savedMovie);
    }

    public MoviesDTO updateMovie(@Valid Long id, MoviesDTO movieDTO) {
        MoviesEntity existingMovie = moviesRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));
        existingMovie.setOriginalTitle(movieDTO.getOriginalTitle());
        existingMovie.setReleaseDate(movieDTO.getReleaseDate());
        existingMovie.setOriginalLanguage(movieDTO.getOriginalLanguage());
        existingMovie.setOverview(movieDTO.getOverview());
        existingMovie.setBudget(movieDTO.getBudget());
        existingMovie.setRevenue(movieDTO.getRevenue());
        existingMovie.setRuntime(movieDTO.getRuntime());
        existingMovie.setVoteAverage(movieDTO.getVoteAverage());
        existingMovie.setCategory(movieDTO.getCategory());

        MoviesEntity updatedMovie = moviesRepository.save(existingMovie);
        return convertToDTO(updatedMovie);
    }

    public void deleteMovie(Long id) {
        if (!moviesRepository.existsById(id)) {
            throw new MovieNotFoundException("Movie not found with id: " + id);
        }
        moviesRepository.deleteById(id);
    }

    private MoviesDTO convertToDTO(MoviesEntity movie) {
        MoviesDTO movieDTO = new MoviesDTO();
        movieDTO.setMovieId(movie.getMovieId());
        movieDTO.setOriginalTitle(movie.getOriginalTitle());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        movieDTO.setOriginalLanguage(movie.getOriginalLanguage());
        movieDTO.setOverview(movie.getOverview());
        movieDTO.setBudget(movie.getBudget());
        movieDTO.setRevenue(movie.getRevenue());
        movieDTO.setRuntime(movie.getRuntime());
        movieDTO.setVoteAverage(movie.getVoteAverage());
        movieDTO.setCategory(movie.getCategory());
        return movieDTO;
    }

    private MoviesEntity convertToEntity(MoviesDTO movieDTO) {
        MoviesEntity movie = new MoviesEntity();
        movie.setOriginalTitle(movieDTO.getOriginalTitle());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setOriginalLanguage(movieDTO.getOriginalLanguage());
        movie.setOverview(movieDTO.getOverview());
        movie.setBudget(movieDTO.getBudget());
        movie.setRevenue(movieDTO.getRevenue());
        movie.setRuntime(movieDTO.getRuntime());
        movie.setVoteAverage(movieDTO.getVoteAverage());
        movie.setCategory(movieDTO.getCategory());
        return movie;
    }

}
