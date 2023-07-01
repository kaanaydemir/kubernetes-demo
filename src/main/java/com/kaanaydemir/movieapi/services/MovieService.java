package com.kaanaydemir.movieapi.services;

import com.kaanaydemir.movieapi.client.DirectorClient;
import com.kaanaydemir.movieapi.dtos.DirectorDto;
import com.kaanaydemir.movieapi.dtos.MovieDto;
import com.kaanaydemir.movieapi.dtos.getmovie.GetMovieResponse;
import com.kaanaydemir.movieapi.entities.Movie;
import com.kaanaydemir.movieapi.mappers.MovieMapper;
import com.kaanaydemir.movieapi.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    private final DirectorClient directorClient;


    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper, DirectorClient directorClient) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.directorClient = directorClient;
    }

    public void save(Movie movie){
        movieRepository.save(movie);
    }

    public List<Movie> getAllEntities() {
        return movieRepository.findAll();
    }

    public GetMovieResponse getMovieWithDetail(Integer id) {
        Movie movie = getById(id);
        DirectorDto director = directorClient.getById(movie.getDirector());
        return new GetMovieResponse(id, movie.getTitle(), movie.getDescription(), director);
    }

    public Movie getById(Integer id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public List<MovieDto> getAll() {
        return movieMapper.convert(getAllEntities());
    }

    public void save(MovieDto dto) {
        save(movieMapper.convert(dto));
    }
}
