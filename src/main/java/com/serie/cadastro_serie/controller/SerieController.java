package com.serie.cadastro_serie.controller;

import com.serie.cadastro_serie.business.SerieService;
import com.serie.cadastro_serie.infrastructure.entitys.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public ResponseEntity<Serie> buscarSeriePorGenero(@RequestParam String genero){
        return ResponseEntity.ok(serieService.buscarSeriePorGenero(genero));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSeriePorGenero(@RequestParam String genero){
        serieService.deletarSeriePorGenero((genero));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarSeriePorId(@RequestBody Serie serie,
                                                    @RequestParam Integer id){
        serieService.atualizarSeriePorId(id, serie);
        return ResponseEntity.ok().build();
    }


}
