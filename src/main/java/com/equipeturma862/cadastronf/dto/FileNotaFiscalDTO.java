package com.equipeturma862.cadastronf.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FileNotaFiscalDTO {
    private String nome;
    private String url;
    private String type;
    private long size;
}
