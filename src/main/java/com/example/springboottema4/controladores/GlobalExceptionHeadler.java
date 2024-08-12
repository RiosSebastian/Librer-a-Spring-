package com.example.springboottema4.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GlobalExceptionHeadler {
    @ExceptionHandler(MultipartException.class)
    public String handleMultipart(MultipartException e, RedirectAttributes attributes){
        attributes.addFlashAttribute("menssage", e.getCause().getMessage());
        return "redirect:/status";
    }

}
