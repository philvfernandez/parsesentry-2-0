package com.dev.beehive.parsecsvsentry;

import com.dev.beehive.parsecsvsentry.domain.InputMc;
import com.dev.beehive.parsecsvsentry.domain.PgmMap;
import com.dev.beehive.parsecsvsentry.utils.InputMcLineFilter;
import com.dev.beehive.parsecsvsentry.utils.PgmMapLineFilter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class ParsecsvsentryApplication {

    public static void main(String[] args) {

        SpringApplication.run(ParsecsvsentryApplication.class, args);

        System.out.println("Running Our CSV Parser....");

        //parse CSV File to create a list of sentry configuration objects
        try {
            // initializing FileInputStream
            //FileInputStream fileInputStream = new FileInputStream("test.csv");
            FileInputStream fileInputStream = new FileInputStream("10_35_34_212.csv");

            // Initializing InputStreamReader object
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            Reader reader1 = new BufferedReader(reader);

            HeaderColumnNameMappingStrategy<InputMc> inputMcStrategy
                    = new HeaderColumnNameMappingStrategy<>();
            inputMcStrategy.setType(InputMc.class);
            CsvToBeanFilter inputMcLineFilter = new InputMcLineFilter((inputMcStrategy));

            HeaderColumnNameMappingStrategy<PgmMap> pgmMapStrategy
                    = new HeaderColumnNameMappingStrategy<>();
            pgmMapStrategy.setType(PgmMap.class);
            CsvToBeanFilter pgmMapFilter = new PgmMapLineFilter((pgmMapStrategy));


            CsvToBean<InputMc> csvToInputMcBean= new CsvToBeanBuilder(reader1)
                    .withType(InputMc.class)
                    .withMappingStrategy(inputMcStrategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withFilter(inputMcLineFilter)
                    .build();

            CsvToBean<PgmMap> csvToPgmMapBean = new CsvToBeanBuilder(reader1)
                    .withType(PgmMap.class)
                    .withMappingStrategy(pgmMapStrategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withFilter(pgmMapFilter)
                    .build();

            //List<SentryConfig> configList = csvToBean.parse();
            List<InputMc> inputMcConfigList = csvToInputMcBean.parse();
            System.out.println("Parsing InputMc Records Complete.  Total Records Parsed: " + inputMcConfigList.size());

            List<PgmMap> pgmMapConfigList = csvToPgmMapBean.parse();
            System.out.println("Parsing PgmMap Records Complete.  Total Records Parsed: " + pgmMapConfigList.size());

        }catch (Exception e) {
            e.printStackTrace();

        }
    }

}
