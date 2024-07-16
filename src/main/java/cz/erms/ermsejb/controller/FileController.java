package cz.erms.ermsejb.controller;

import cz.erms.ermsejb.ejb.entity.File;
import cz.erms.ermsejb.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public FileController(@Qualifier("fileService") FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("")
    public List<File> getAllBooks() {
        return fileService.getAllFiles();
    }

    @GetMapping("/{uuid}")
    public File getFileById(@PathVariable String uuid) {
        return fileService.getFileById(UUID.fromString(uuid));
    }

    @PostMapping("")
    public File createBook(@RequestBody File file) {
        return fileService.createFile(file);
    }

    @PutMapping("/{uuid}")
    public File updateBook(@PathVariable String uuid, @RequestBody File file) {
        return fileService.updateFile(UUID.fromString(uuid), file);
    }

    @DeleteMapping("/{uuid}")
    public void deleteBook(@PathVariable String uuid) {
        fileService.deleteFile(UUID.fromString(uuid));
    }
}
