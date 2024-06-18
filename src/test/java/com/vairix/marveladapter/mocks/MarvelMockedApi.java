package com.vairix.marveladapter.mocks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.vairix.marveladapter.model.GetCharactersResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

public class MarvelMockedApi {

    public static void setupMockMarvelApiResponse(WireMockServer mockService) throws IOException {
        mockService
                .stubFor(
                        WireMock.get(WireMock.urlEqualTo("/books"))
                            .willReturn(
                                    WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                        .withBody(
                                copyToString(
                                        GetCharactersResponse.class.getClassLoader().getResourceAsStream("com/vairix/marveladapter/payload/modelexample.json"),
                                        defaultCharset()))));
    }
}
