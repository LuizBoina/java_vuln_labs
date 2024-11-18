package com.skf.labs.fileupload;

import com.skf.labs.fileupload.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;
import org.apache.tika.Tika;
import java.util.List;
import java.util.UUID;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class FileUploadController {

  private final StorageService storageService;

  @Autowired
  public FileUploadController(StorageService storageService) {
    this.storageService = storageService;
  }

  @GetMapping("/")
  public String listUploadedFiles() {

    return "index";
  }

  @PostMapping("/")
  public String handleFileUpload(@RequestParam("file") MultipartFile file,
      Model model) {
    try {
      Tika tika = new Tika();
      String mimeType = tika.detect(file.getInputStream());
      List<String> allowedTypes = List.of("image/jpeg", "image/png");
      List<String> allowedExt = List.of("png", "jpeg", "jpg");
      String originalFileName = FilenameUtils.getName(file.getOriginalFilename());
      String fileExtension = FilenameUtils.getExtension(originalFileName);
      if (!allowedTypes.contains(mimeType) || !allowedExt.contains(fileExtension)) {
        model.addAttribute("uploaded", "File extension not allowed");
        return "index";
      } 
      String uniqueFileName = UUID.randomUUID().toString() + "." + fileExtension;
      
      storageService.store(file, uniqueFileName);
      model.addAttribute("uploaded", "You successfully uploaded!");
      return "index";

    } catch(IOException e) {
      System.out.println(e);
      model.addAttribute("uploaded", "Error Trying to upload file");
      return "index";
    }
  }
}
