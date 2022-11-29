package com.equipeturma862.cadastronf.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Long funcional;
    private String email;

    @JsonIgnoreProperties
    @ManyToOne
    private Agencia Agencia;

    @OneToMany
    private List<Requisicao> requisicoes;

}