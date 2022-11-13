package com.equipeturma862.cadastronf.domain;


import lombok.*;

import javax.persistence.*;


@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoNaturezaOperacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
}
