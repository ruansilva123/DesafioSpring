package com.challenge.springChallenge.ExternalAPI;


import com.challenge.springChallenge.Models.WeatherResponse;
import com.challenge.springChallenge.Validations.WeatherValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import java.net.InetSocketAddress;
import java.net.Proxy;


@Service
public class WeatherAPI {

    public WeatherResponse getWeather(int latitude, int longitude){

        if(!WeatherValidation.validateLongititude(longitude) || !WeatherValidation.validateLatitude(latitude)){
            String message = "Longitude must be in range of -180 to 180° and latitude must be in range of -90 to 90°.";
            return new WeatherResponse(false, message, null);
        }

        int contRetries = 1;
        int maxRetries = 5;

        while(contRetries<=maxRetries){
            try{
                String url = "https://api.open-meteo.com/v1/forecast?latitude="+latitude+"&longitude="+longitude+"&hourly=temperature";

                SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
                factory.setConnectTimeout(5000);
                factory.setReadTimeout(5000);

                // Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.br.bosch.com", 8080));
                // factory.setProxy(proxy);
                RestTemplate restTemplate = new RestTemplate(factory);

                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

                return new WeatherResponse(true, "Data found successfully!", response.getBody());

            }catch (HttpStatusCodeException error){
                System.out.println("Http Error: "+error.toString());
                return new WeatherResponse(false, "Weather API returned HTTP Error!", null);

            }catch (ResourceAccessException error){
                System.out.println("Connectivity Error: "+error.toString());
                System.out.println("Try to connect to API: "+contRetries+" of "+maxRetries);
                contRetries++;

            }catch (Exception error){
                System.out.println("Error: "+error.toString());
                return new WeatherResponse(false, "Internal server error!", null);
            }
        }
        return new WeatherResponse(false, "The 5 attempts to connect the server to the API failed!", null);
    }
}
