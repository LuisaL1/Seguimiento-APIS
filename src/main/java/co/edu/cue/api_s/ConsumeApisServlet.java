package co.edu.cue.api_s;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

@WebServlet(name = "consumirApis", value = "/consumeApis")
public class ConsumeApisServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpClient client = HttpClient.newHttpClient();
        String trmData = "No se pudieron obtener los datos de TRM.";
        String weatherData = "No se pudieron obtener los datos del clima.";
        String rickMortyData = "No se pudieron obtener los datos de Rick and Morty.";

        try {

            String trmApiUrl = "https://trm-colombia.vercel.app/?date=2023-12-31";
            HttpRequest trmRequest = HttpRequest.newBuilder().uri(URI.create(trmApiUrl)).build();
            HttpResponse<String> trmResponse = client.send(trmRequest, HttpResponse.BodyHandlers.ofString());
            if (trmResponse.statusCode() == 200) {
                trmData = trmResponse.body();
            }

            String weatherApiUrl = "http://api.weatherstack.com/current?access_key=b05c48fa57dab1e42ff3154e8abdeada&query=Bogota";
            HttpRequest weatherRequest = HttpRequest.newBuilder().uri(URI.create(weatherApiUrl)).build();
            HttpResponse<String> weatherResponse = client.send(weatherRequest, HttpResponse.BodyHandlers.ofString());
            if (weatherResponse.statusCode() == 200) {
                weatherData = weatherResponse.body();
            }

            String rickMortyApiUrl = "https://rickandmortyapi.com/api/character";
            HttpRequest rickMortyRequest = HttpRequest.newBuilder().uri(URI.create(rickMortyApiUrl)).build();
            HttpResponse<String> rickMortyResponse = client.send(rickMortyRequest, HttpResponse.BodyHandlers.ofString());
            if (rickMortyResponse.statusCode() == 200) {
                rickMortyData = rickMortyResponse.body();
            }

            // Formateamos los datos JSON obtenidos usando Gson para darle una mejor estética y orden
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String formattedTrmData = gson.toJson(JsonParser.parseString(trmData));
            String formattedWeatherData = gson.toJson(JsonParser.parseString(weatherData));
            String formattedRickMortyData = gson.toJson(JsonParser.parseString(rickMortyData));

            req.setAttribute("trmData", formattedTrmData);
            req.setAttribute("weatherData", formattedWeatherData);
            req.setAttribute("rickMortyData", formattedRickMortyData);

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/APIs.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}



