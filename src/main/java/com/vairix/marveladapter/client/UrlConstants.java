package com.vairix.marveladapter.client;

/**
 * Contiene valores que son constantes y bien son necesarios para la capa cliente.
 */
public interface UrlConstants {

    /**
     * valor long para calculo de hash
     */
    public static final String TS = "1";
    /**
     * API KEY proveida por Marvel.
     */
    public static final String API_KEY = "729739280a0d72cda29377e064edabd9";
    /**
     * HASH - Es un cifrado de (ts+PUBLIC_KEY+PRIVATE_KEY) en md5.
     */
    public static final String HASH = "e5721fc4f5848adfa30ebc0f2b50eb9e";
    /**
     * Conjugacion de TS, API KEY y HASH
     */
    public static final String AUTHORIZED_QUERY_PARAMS = "ts=" + TS +"&apikey=" + API_KEY + "&hash=" + HASH;
    /**
     * La url base de la API de Marvel
     */
    public static final String MARVEL_BASE_URL = "https://gateway.marvel.com:443/v1/public";
}
