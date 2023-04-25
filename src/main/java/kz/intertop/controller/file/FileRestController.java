package kz.intertop.controller.file;
import kz.intertop.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/file")
public class FileRestController {
    private final FileService fileService;
    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/upload")
    public String upload(@RequestParam(name = "file") MultipartFile file){
        return fileService.uploadFile(file);
    }

    @GetMapping(value = "/view/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] view(@PathVariable(name = "fileName") String fileName) throws IOException {
        return fileService.getFile(fileName);
    }
}
