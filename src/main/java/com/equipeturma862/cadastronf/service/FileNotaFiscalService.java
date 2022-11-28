package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.FileNotaFiscal;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileNotaFiscalService {

    FileNotaFiscal getById(Long id);
    FileNotaFiscal save(MultipartFile file) throws IOException;
    List<FileNotaFiscal> listAll();
}
