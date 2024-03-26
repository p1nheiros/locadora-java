package com.example.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MoviesDTO {
    private Long movieId;

    @NotBlank(message = "O título original do filme não pode estar em branco")
    private String originalTitle;

    @NotNull(message = "A data de lançamento não pode estar em branco")
    private LocalDate releaseDate;

    @NotBlank(message = "A linguagem original do filme não pode estar em branco")
    private String originalLanguage;

    @NotBlank(message = "A descrição do filme não pode estar em branco")
    private String overview;

    @NotNull(message = "O orçamento do filme não pode estar em branco")
    @Positive(message = "O orçamento do filme deve ser um número positivo")
    private Double budget;

    @NotNull(message = "O faturamento do filme não pode estar em branco")
    @Positive(message = "O faturamento do filme deve ser um número positivo")
    private Double revenue;

    @NotNull(message = "O tempo de duração do filme não pode estar em branco")
    @Positive(message = "O tempo de duração do filme deve ser um número positivo")
    private Integer runtime;

    @NotNull(message = "A avaliação do filme não pode estar em branco")
    private BigDecimal voteAverage;

    @NotBlank(message = "A categoria do filme não pode estar em branco")
    private String category;
}
