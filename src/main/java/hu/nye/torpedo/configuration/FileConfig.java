package hu.nye.torpedo.configuration;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import hu.nye.torpedo.service.input.DataReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FileConfig {

    @Bean
    public DataReader dataReader() {
        BufferedInputStream is = new BufferedInputStream(System.in);
        return new DataReader(new BufferedReader(new InputStreamReader(is)));
    }

}
