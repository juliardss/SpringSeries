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

    public void deletarSeriePorGenero(String genero){
        repository.deleteByGenero(genero);
    }

    public void atualizarSeriePorId(Integer id,Serie serie){
        Serie serieEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Serie nao encontrada"));
        Serie serieAtualizado = Serie.builder()
                .nome(serie.getNome()!=null ? serie.getNome() : serieEntity.getNome())
                .genero(serie.getGenero()!=null ? serie.getGenero() : serieEntity.getGenero())
                .plataforma(serie.getPlataforma()!=null ? serie.getPlataforma() : serieEntity.getPlataforma())
                .anoLancamento(serie.getAnoLancamento()!=null ? serie.getAnoLancamento() : serieEntity.getAnoLancamento())
                .id(serieEntity.getId())
                .build();

        repository.saveAndFlush(serieAtualizado);
    }



}
