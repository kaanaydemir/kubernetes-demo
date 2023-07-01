package com.kaanaydemir.movieapi.client;


import com.kaanaydemir.movieapi.dtos.DirectorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "director-api-clusterip-service", url = "${DIRECTOR-API_SERVICE_HOST}")

public interface DirectorClient {

    @GetMapping("/api/directors/{id}")
    DirectorDto getById(@PathVariable String id);
}
