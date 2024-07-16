package cz.erms.ermsejb.service;

import cz.erms.ermsejb.ejb.entity.File;
import cz.erms.ermsejb.ejb.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(@Qualifier("fileRepository") FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public File getFileById(UUID uuid) {
        return fileRepository.findById(uuid).orElse(null);
    }

    public File createFile(File file) {
        return fileRepository.save(file);
    }

    public File updateFile(UUID uuid, File file) {
        File existingBook = fileRepository.findById(uuid).orElse(null);
        if (existingBook != null) {
            existingBook.setUserId(file.getUserId());
            existingBook.setName(file.getName());
            return fileRepository.save(file);
        } else {
            return null;
        }
    }

    public void deleteFile(UUID uuid) {
        fileRepository.deleteById(uuid);
    }
}
