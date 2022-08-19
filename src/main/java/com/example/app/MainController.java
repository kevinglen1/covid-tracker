package com.example.app;

import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Controller
public class MainController {

    @Autowired
    CoronaRepository coronaRepository;

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

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                Corona corona = new Corona();
                corona.setLastUpdate(LocalDateTime.parse(line[4], formatter));
                corona.setConfirmed(Long.valueOf(line[7]));
                corona.setCombinedKey(line[11]);

                log.info(corona.toString());
                coronaRepository.save(corona);
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
