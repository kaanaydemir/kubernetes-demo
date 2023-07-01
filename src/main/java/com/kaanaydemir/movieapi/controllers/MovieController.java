package com.kaanaydemir.movieapi.controllers;

import com.kaanaydemir.movieapi.dtos.MovieDto;
import com.kaanaydemir.movieapi.dtos.getmovie.GetMovieResponse;
import com.kaanaydemir.movieapi.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/movies")
    public List<MovieDto> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/api/movies/{id}")
    public ResponseEntity<GetMovieResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieWithDetail(id));
    }

    @PostMapping("/api/movies")
    public void save(MovieDto dto) {
        movieService.save(dto);
    }
}
