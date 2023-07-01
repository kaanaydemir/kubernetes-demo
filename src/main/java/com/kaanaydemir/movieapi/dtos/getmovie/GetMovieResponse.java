package com.kaanaydemir.movieapi.dtos.getmovie;

import com.kaanaydemir.movieapi.dtos.DirectorDto;

public record GetMovieResponse(Integer id, String title, String description, DirectorDto director){
}
