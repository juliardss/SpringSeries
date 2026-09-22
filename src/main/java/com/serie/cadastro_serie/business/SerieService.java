package com.serie.cadastro_serie.business;


import com.serie.cadastro_serie.infrastructure.entitys.Serie;
import com.serie.cadastro_serie.infrastructure.repository.SerieRepository;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

    private final SerieRepository repository;

    public SerieService(SerieRepository repository) {
        this.repository = repository;
    }

    public void salvarSerie(Serie serie){
        repository.saveAndFlush(serie);
    }

    public Serie buscarSeriePorGenero(String genero){

        return repository.findByGenero(genero).orElseThrow(
                () -> new RuntimeException("Genero não encontrado")
        );
    }


}
