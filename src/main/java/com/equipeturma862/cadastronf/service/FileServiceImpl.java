package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.File;
import com.equipeturma862.cadastronf.exceptions.FileNotFound;
import com.equipeturma862.cadastronf.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Override
    public File getById(Long id) {
        return fileRepository.findById(id).orElseThrow(FileNotFound::new);
    }

    @Override
    public File save(MultipartFile file) throws IOException {
        File fileDB = File.builder()
                .data(file.getBytes())
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .build();
        return fileRepository.save(fileDB);
    }

    @Override
    public List<File> listAll() {
        return IterableUtils.toList(fileRepository.findAll());
    }

}
