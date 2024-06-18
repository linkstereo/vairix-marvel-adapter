package com.vairix.marveladapter;

import com.vairix.marveladapter.client.MarvelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class MarvelAdapterApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = SpringApplication.run(MarvelAdapterApplication.class, args);

        MarvelClient marvelClient = appContext.getBean(MarvelClient.class);
        var chars = marvelClient.getCharacters();
        var character = marvelClient.getCharacter("1011334");
    }

}
