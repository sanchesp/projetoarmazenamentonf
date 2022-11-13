package com.equipeturma862.cadastronf.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime dataHoraRegistro;
    private String detalheDoTrajeto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionarioSolicitante;

    @OneToOne(cascade = CascadeType.PERSIST)
    private NotaFiscal notaFiscal;

}
