package com.example.app;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileReader;
import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/")
    public String root (Model model){
        model.addAttribute("test1", "Hello user");

        String csvFile = "/Users/kevin/development-projects/covid-tracker/app/08-16-2022-Covid-Data.csv";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            int i = 0;
            while ((line = reader.readNext()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally { // closing the reader in the finally block
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "mainTemplate";
    }
}
