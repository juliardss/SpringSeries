package com.serie.cadastro_serie.controller;

import com.serie.cadastro_serie.business.SerieService;
import com.serie.cadastro_serie.infrastructure.entitys.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serie")
@RequiredArgsConstructor

public class SerieController {
    private final SerieService serieService;

    @PostMapping
    public ResponseEntity<Void> salvarSerie(@RequestBody Serie serie){
        serieService.salvarSerie(serie);
        return ResponseEntity.ok().build();

    }
}
