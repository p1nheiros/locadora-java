package com.example.crud.controllers;

import com.example.crud.dto.MoviesDTO;
import com.example.crud.service.movies.MoviesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Validated
public class MoviesController {
    private final MoviesService movieService;

    @Autowired
    public MoviesController(MoviesService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MoviesDTO>> getAllMovies() {
        List<MoviesDTO> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoviesDTO> getMovieById(@PathVariable Long id) {
        MoviesDTO movieDTO = movieService.getMovieById(id);
        return new ResponseEntity<>(movieDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MoviesDTO> createMovie(@Valid @RequestBody MoviesDTO moviesDTO) {
        MoviesDTO createdMovie = movieService.createMovie(moviesDTO);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoviesDTO> updateMovie(@Valid @PathVariable Long id,@Valid @RequestBody MoviesDTO movieDTO) {
        MoviesDTO updatedMovie = movieService.updateMovie(id, movieDTO);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

