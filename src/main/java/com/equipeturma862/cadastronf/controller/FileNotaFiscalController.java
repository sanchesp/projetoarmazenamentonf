package com.equipeturma862.cadastronf.controller;

import com.equipeturma862.cadastronf.domain.FileNotaFiscal;
import com.equipeturma862.cadastronf.dto.FileNotaFiscalDTO;
import com.equipeturma862.cadastronf.service.FileNotaFiscalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin("http://localhost:8080")
@RequestMapping("filesnotafiscal")
@RequiredArgsConstructor
public class FileNotaFiscalController {

    private FileNotaFiscalService fileNotaFiscalService;

    @PostMapping("/upload")
    @ResponseBody
    public FileNotaFiscalDTO uploadFile(@RequestParam("filesnotafiscal") MultipartFile filesNotaFiscal) throws IOException {
        FileNotaFiscal newFileNotaFiscal = fileNotaFiscalService.save(filesNotaFiscal);
        return FileNotaFiscalDTO.builder()
                .nome(newFileNotaFiscal.getNome())
                .type(newFileNotaFiscal.getType())
                .size(newFileNotaFiscal.getData().length)
                .url("/filesnotafiscal/" + newFileNotaFiscal.getId())
                .build();
    }
    @GetMapping("{id}/download")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        FileNotaFiscal fileNotaFiscal = fileNotaFiscalService.getById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileNotaFiscal.getNome() + "\"")
                .body(fileNotaFiscal.getData());
    }
    @GetMapping
    @ResponseBody
    public List<FileNotaFiscalDTO> listAll() {
        return fileNotaFiscalService.listAll().stream().map(file -> FileNotaFiscalDTO.builder()
                .nome(file.getNome())
                .type(file.getType())
                .size(file.getData().length)
                .url("/filesnotafiscal/" + file.getId())
                .build()).toList();
    }
}
