package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.FileNotaFiscal;
import com.equipeturma862.cadastronf.exceptions.FileNotaFiscalNotFound;
import com.equipeturma862.cadastronf.repository.FileNotaFiscalRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileNotaFiscalServiceImpl implements FileNotaFiscalService{

    private final FileNotaFiscalRepository fileNotaFiscalRepository;

    @Override
    public FileNotaFiscal getById(Long id) {
        return fileNotaFiscalRepository.findById(id).orElseThrow(FileNotaFiscalNotFound::new);
    }

    @Override
    public FileNotaFiscal save(MultipartFile fileNotaFiscal) throws IOException {
        FileNotaFiscal fileNotaFiscalDB = FileNotaFiscal.builder()
                .data(fileNotaFiscal.getBytes())
                .nome(fileNotaFiscal.getOriginalFilename())
                .type(fileNotaFiscal.getContentType())
                .build();
        return fileNotaFiscalRepository.save(fileNotaFiscalDB);
    }

    @Override
    public List<FileNotaFiscal> listAll() {
        return IterableUtils.toList(fileNotaFiscalRepository.findAll());
    }
}
