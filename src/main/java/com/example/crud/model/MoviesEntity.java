package com.example.crud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Movies")
public class MoviesEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "movie_id")
        private Long movieId;

        @Column(name = "original_title")
        private String originalTitle;

        @Column(name = "release_date")
        private LocalDate releaseDate;

        @Column(name = "original_language")
        private String originalLanguage;

        @Column(name = "overview")
        private String overview;

        @Column(name = "budget")
        private Double budget;

        @Column(name = "revenue")
        private Double revenue;

        @Column(name = "runtime")
        private Integer runtime;

        @Column(name = "vote_average")
        private BigDecimal voteAverage;

        @Column(name = "category")
        private String category;
}
