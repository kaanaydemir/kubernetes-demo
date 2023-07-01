package com.kaanaydemir.movieapi.dtos;

import java.time.LocalDate;
import java.util.List;

public record DirectorDto(String id, String email, String name, String surname, LocalDate birthDate, DirectorAddressDto address, List<Integer> movies) {
}

