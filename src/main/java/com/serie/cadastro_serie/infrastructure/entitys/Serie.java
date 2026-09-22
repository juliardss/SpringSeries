package com.serie.cadastro_serie.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "serie")
@Entity

public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "genero")
    private String genero;

    @Column(name = "plataforma")
    private String plataforma;

    @Column(name = "ano lancamento")
    private Integer anoLancamento;
}
