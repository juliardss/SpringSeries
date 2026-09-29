package com.serie.cadastro_serie.infrastructure.repository;

import com.serie.cadastro_serie.infrastructure.entitys.Serie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Integer> {

    Optional<Serie> findByGenero(String genero);

    @Transactional
    void deleteByGenero(String genero);
}
