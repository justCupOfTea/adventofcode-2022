package org.justcupoftea.adventofcode2022.task;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.Objects;


public class ResourceManager implements Closeable {
    private final CloseableHttpClient client;
    private final BufferedReader reader;
    private static final String sessionFileName= "session";
    private static final String sessionCookieName= "session";
    private static final String DOMAIN = ".adventofcode.com";


    public ResourceManager(){
        try {
            InputStream inputStream = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(sessionFileName), "Не найден файл с кодом сесии");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            var cookieStore = new BasicCookieStore();
            var cookie = new BasicClientCookie(sessionCookieName, reader.readLine());
            cookie.setDomain(DOMAIN);
            cookieStore.addCookie(cookie);
            client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getData(String url){
        try {
            return EntityUtils.toString(client.execute(new HttpGet(url)).getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws IOException {
        client.close();
        reader.close();
    }
}
