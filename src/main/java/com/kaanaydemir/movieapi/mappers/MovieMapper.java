package com.kaanaydemir.movieapi.mappers;

import com.kaanaydemir.movieapi.dtos.MovieDto;
import com.kaanaydemir.movieapi.entities.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie convert(MovieDto dto);
    MovieDto convert(Movie entity);

    List<MovieDto> convert(List<Movie> all);
}
