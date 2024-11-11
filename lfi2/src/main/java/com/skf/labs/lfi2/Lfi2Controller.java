package com.skf.labs.lfi2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.core.io.ClassPathResource;


@Controller
public class Lfi2Controller {

    private static final String BASE_DIRECTORY = "text/";
    
    @PostMapping("/home")
	public String home(@RequestParam(name="filename", required=false, defaultValue="World") String filename, Model model) {
        Path filePath = Paths.get(filename).normalize();
        if (!filePath.startsWith(BASE_DIRECTORY)) {
            model.addAttribute("read", "Access Denied: Invalid File Path");
            return "index";
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))){           
            StringBuilder content = new StringBuilder();
            String line;
            while((line = br.readLine())!= null){
                content.append(line);
            }
            model.addAttribute("read", content.toString());
        }catch(FileNotFoundException e){
            e.printStackTrace();
            model.addAttribute("read","Try harder!");
            return "index";
        }catch(IOException e){
            e.printStackTrace();
            model.addAttribute("read","Try harder!");
            return "index";
        }
		return "index";
	}
}
