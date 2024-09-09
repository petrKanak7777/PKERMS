package cz.erms.backend.controller;

import cz.erms.backend.model.request.FileRequest;
import cz.erms.backend.model.response.FileResponse;
import cz.erms.backend.service.FileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("")
    public ResponseEntity<List<FileResponse>> getAllFiles() {
        List<FileResponse> files = fileService.getAllFiles();
        return new ResponseEntity<>(files, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<FileResponse> getFileById(@PathVariable String uuid) {
        FileResponse file = fileService.getFileById(UUID.fromString(uuid));
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<FileResponse> createFile(@RequestBody @Valid FileRequest fileRequest) {
        FileResponse file = fileService.createFile(fileRequest);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<FileResponse> updateFile(@PathVariable String uuid, @RequestBody @Valid FileRequest fileRequest) {
        FileResponse file = fileService.updateFile(UUID.fromString(uuid), fileRequest);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteFile(@PathVariable String uuid) {
        fileService.deleteFile(UUID.fromString(uuid));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
