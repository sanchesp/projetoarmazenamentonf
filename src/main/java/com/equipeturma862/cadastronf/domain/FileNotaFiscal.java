package com.equipeturma862.cadastronf.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FileNotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String type;

    @Lob
    private byte[] data;
}
