package com.example.springboottema4.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class IncreaseControler {
   @GetMapping("/")
   public String home() {
      return "upload";
   }
   @PostMapping("/upload")
   public String subirArchivo(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {

      if (file == null || file.isEmpty()) {
         attributes.addFlashAttribute("mensaje","por favor selecione el archivo");
         return "redirect:status";
      }
      StringBuilder builder = new StringBuilder();
      builder.append(System.getProperty("user.home"));
      builder.append(File.separator);
      builder.append("sping_upload_example");
      builder.append(File.separator);
      builder.append(file.getOriginalFilename());

      byte[] findByte = file.getBytes();
      Path path = Paths.get(builder.toString());
      Files.write(path, findByte);

      attributes.addFlashAttribute("message","Archivo Cargado Correctamente["+builder.toString()+"]");

      return "redirect:/status";

   }
   @GetMapping("/status")
   public String status(){
      return "status";
   }
}

