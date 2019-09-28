package com.lsolier.udacity.springbootfileupload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

  private Map<String, Object> result = new HashMap<>();

  @RequestMapping("/uploadFile")
  public Map<String, Object> upload(@RequestParam("attach")MultipartFile file) throws IOException {
    //file info
    System.out.println("File name = " + file.getOriginalFilename());
    System.out.println("File type = " + file.getContentType());

    //save to disk
    String filePath = "/home/debluisoli/Documentos/";
    file.transferTo(new File(filePath + file.getOriginalFilename()));
    result.put("Succes", true);
    return result;
  }
}
