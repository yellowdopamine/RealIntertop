package kz.RealIntertop.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class FileService {
    private final UserService userService;
    @Value("${file.upload.url}")
    private String fileUploadUrl;

    @Value("${file.view.url}")
    private String fileViewUrl;

    @Value("${file.key}")
    private String fileKey;

    public String uploadFile(MultipartFile file){
        String contentType = file.getContentType();
        assert contentType != null;
        String extension = switch (contentType) {
            case "image/jpeg" -> ".jpg";
            case "image/png" -> ".png";
            case "application/pdf" -> ".pdf";
            default -> "";
        };

        String fileName = DigestUtils.sha1Hex(fileKey + System.currentTimeMillis()) + "_" + new Random().nextInt(1000);
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(fileUploadUrl + fileName + extension);
            Files.write(path, bytes);
        } catch (Exception e ){
            e.printStackTrace();
            return null;
        }
        return fileName + extension;
    }

    public byte[] getFile(String fileName) throws IOException{
        InputStream in;
        ClassPathResource resource;
        String file = fileViewUrl + fileName;
        try{
            resource = new ClassPathResource(file);
        } catch (Exception e ){
            e.printStackTrace();
            resource = new ClassPathResource(file + "fileNotFound.jpg");
        }
        in = resource.getInputStream();
        return IOUtils.toByteArray(in);
    }
}

