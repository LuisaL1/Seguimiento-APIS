package co.edu.cue.api_s;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class ConsumeApisServletTest {

    @Test
    public void testTRM() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String trmApiUrl = "https://trm-colombia.vercel.app/?date=2023-12-31";
        HttpRequest trmRequest = HttpRequest.newBuilder().uri(URI.create(trmApiUrl)).build();
        String trmData = client.send(trmRequest, HttpResponse.BodyHandlers.ofString()).body();

        System.out.println(trmData);
    }

    @Test
    public void testWeather() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String weatherApiUrl = "http://api.weatherstack.com/current?access_key=b05c48fa57dab1e42ff3154e8abdeada&query=Bogota";
        HttpRequest weatherRequest = HttpRequest.newBuilder().uri(URI.create(weatherApiUrl)).build();
        String weatherData = client.send(weatherRequest, HttpResponse.BodyHandlers.ofString()).body();

        System.out.println(weatherData);
    }

    @Test
    public void testRickMorty() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String rickMortyApiUrl = "https://rickandmortyapi.com/api/character";
        HttpRequest rickMortyRequest = HttpRequest.newBuilder().uri(URI.create(rickMortyApiUrl)).build();
        String rickMortyData = client.send(rickMortyRequest, HttpResponse.BodyHandlers.ofString()).body();

        System.out.println(rickMortyData);
    }


}