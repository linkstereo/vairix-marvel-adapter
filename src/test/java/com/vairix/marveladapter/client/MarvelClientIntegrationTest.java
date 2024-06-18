package com.vairix.marveladapter.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.vairix.marveladapter.config.WireMockConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.vairix.marveladapter.mocks.MarvelMockedApi.setupMockMarvelApiResponse;
import java.io.IOException;

/**
 * En este componente se hace una prueba de integración con un stub del servicio de Marvel
 * probando asi la eficiencia del cliente feign de la API de marvel.
 * Finalmente se hacen pruebas para verificar el armado de los DTOs.
 *
 */
@SpringBootTest
@ActiveProfiles("test")
@EnableFeignClients
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
class MarvelClientIntegrationTest {

    @Autowired
    private WireMockServer mockBooksService;

    @Autowired
    private WireMockServer mockBooksService2;

    @Autowired
    private MarvelClient marvelClient;

    @BeforeEach
    void setUp() throws IOException {
        setupMockMarvelApiResponse(mockBooksService);
        setupMockMarvelApiResponse(mockBooksService2);
    }

    @Test
    void getCharacters() {
        var results = marvelClient.getCharacters();

        Assertions.assertTrue(results != null);
        Assertions.assertTrue(results.getCode() == 200);
        Assertions.assertTrue(results.getData() != null);
        Assertions.assertTrue(results.getData().getResults() != null);
        Assertions.assertTrue(results.getData().getResults().size() > 0);
        Assertions.assertFalse(results.getData().getResults().get(0).getName().isBlank());
    }

    @Test
    void getCharacter() {
        var results = marvelClient.getCharacter("1011334");

        Assertions.assertTrue(results != null);
        Assertions.assertTrue(results.getCode() == 200);
        Assertions.assertTrue(results.getData() != null);
        Assertions.assertTrue(results.getData().getResults() != null);
        Assertions.assertTrue(results.getData().getResults().size() > 0);
        Assertions.assertFalse(results.getData().getResults().get(0).getName().isBlank());
    }
}