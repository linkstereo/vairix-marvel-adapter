package com.vairix.marveladapter.client;

import com.vairix.marveladapter.model.GetCharactersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.vairix.marveladapter.client.UrlConstants.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Componente que hace de interface de conexión client-side hacia los servicios de la API de Marvel
 */
@FeignClient(value = "marvelClient", url = MARVEL_BASE_URL)
public interface MarvelClient {

    /**
     * Obtiene los {@link Character} (Personajes) de Marvel.
     * @return {@link GetCharactersResponse}
     */
    @RequestMapping(method = GET, value = "/characters?" + AUTHORIZED_QUERY_PARAMS)
    GetCharactersResponse getCharacters();

    /**
     * Obtiene un {@link Character} (Personaje) de Marvel por characterId
     * @param characterId - Parámetro en el path que permite hacer la busqueda del personaje.
     * @return {@link GetCharactersResponse}
     */
    @RequestMapping(method = GET, value = "/characters/{characterId}?" + AUTHORIZED_QUERY_PARAMS)
    GetCharactersResponse getCharacter(@PathVariable("characterId") String characterId);

}
