package com.desa.miprestamito.servicio.impl;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import com.desa.miprestamito.servicio.FileServiceAPI;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileServiceImpl implements FileServiceAPI {

    private final Path rootFolder = Paths.get("uploads");

    @Override
    public void save(MultipartFile file, String correlativo) throws Exception {
        String nombreFila =file.getOriginalFilename().replace(" ", "_");
        System.out.println(nombreFila);
        Files.copy(file.getInputStream(), this.rootFolder.resolve(correlativo));
    }

    @Override
    public Resource load(String name) throws Exception {
        Path file = rootFolder.resolve(name);
        Resource resource = new UrlResource(file.toUri());
        return resource;
    }

    @Override
    public void save(List<MultipartFile> files, String correlativo) throws Exception {
        for (MultipartFile file : files) {
            this.save(file, correlativo);
        }
    }

    @Override
    public Stream<Path> loadAll() throws Exception {
        return Files.walk(rootFolder, 1).filter(path -> !path.equals(rootFolder)).map(rootFolder::relativize);
    }


    String setNombreFila(String nombreFila){
        return null;
    }
}