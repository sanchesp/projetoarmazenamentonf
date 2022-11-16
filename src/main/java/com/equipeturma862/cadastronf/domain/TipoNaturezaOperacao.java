package com.equipeturma862.cadastronf.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoNaturezaOperacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
}
