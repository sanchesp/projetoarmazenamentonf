package com.equipeturma862.cadastronf.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Long numeroDeIdentificacao;
    private String email;

    @OneToMany
    private List<Funcionario> funcionarios;


}
