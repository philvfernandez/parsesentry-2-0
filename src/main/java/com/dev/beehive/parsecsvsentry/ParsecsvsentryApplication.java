package com.dev.beehive.parsecsvsentry;

import com.dev.beehive.parsecsvsentry.domain.SentryConfig;
import com.dev.beehive.parsecsvsentry.utils.LineFilter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class ParsecsvsentryApplication {

    public static void main(String[] args) {

        SpringApplication.run(ParsecsvsentryApplication.class, args);

        System.out.println("Running Our CSV Parser....");

        //parse CSV File to create a list of sentry configuration objects
        try {
            //FileInputStream fileInputStream = new FileInputStream("test.csv");
            //BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

            // initializing FileInputStream
            FileInputStream fileInputStream = new FileInputStream("test.csv");

            // Initializing InputStreamReader object
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            Reader reader1 = new BufferedReader(reader);

            /* String line;
            while((line = reader.read()) != null) {
                System.out.println(line);
            } */

            HeaderColumnNameMappingStrategy<SentryConfig> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(SentryConfig.class);
            CsvToBeanFilter filter = new LineFilter(strategy);

            CsvToBean<SentryConfig> csvToBean= new CsvToBeanBuilder(reader1)
                    .withType(SentryConfig.class)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withFilter(filter)
                    .build();


            List<SentryConfig> configList = csvToBean.parse();
            System.out.println("File Finished Parsing..." + configList);

        }catch (Exception e) {
            e.printStackTrace();

        }
    }

}
