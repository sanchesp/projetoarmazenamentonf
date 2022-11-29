package com.equipeturma862.cadastronf.service;

import com.equipeturma862.cadastronf.domain.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    File getById(Long id);
    File save(MultipartFile file) throws IOException;
    List<File> listAll();
}
