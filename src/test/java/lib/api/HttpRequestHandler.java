package lib.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import io.qameta.allure.Step;

public class HttpRequestHandler {

    public interface methodHTTP {
        String GET = "GET";
        String POST = "POST";
        String PUT = "PUT";
        String DELETE = "DELETE";
    }

    static String mainUrl = "https://www.invitro.ru/local";

    @Step("Send request GET '{endpoint}'")
    public static HttpResponse<String> sendRequestGet(String endpoint) {
        HttpClient client = HttpClient.newHttpClient();
        String method = methodHTTP.GET;

        System.out.println("Send request: " + method + " " + mainUrl + endpoint);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(mainUrl + endpoint))
                .GET()
                .setHeader("Accept", "application/json")
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println("ERROR response: " + " " + method + mainUrl + endpoint + "\nCode response: " + response.statusCode() + "\nBody: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Step("Send request POST '{endpoint}'")
    public static HttpResponse<String> sendRequestPost(String endpoint, String body) {
        HttpClient client = HttpClient.newHttpClient();
        String method = methodHTTP.POST;

        System.out.println("Send request: " + method + " " + mainUrl + endpoint);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(mainUrl + endpoint))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println("ERROR response: " + " " + method + mainUrl + endpoint + "\nCode response: " + response.statusCode() + "\nBody: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Step("Send request PUT '{endpoint}'")
    public static HttpResponse<String> sendRequestPut(String endpoint, String body) {
        HttpClient client = HttpClient.newHttpClient();
        String method = methodHTTP.PUT;

        System.out.println("Send request: " + method + " " + mainUrl + endpoint);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(mainUrl + endpoint))
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println("ERROR response: " + " " + method + mainUrl + endpoint + "\nCode response: " + response.statusCode() + "\nBody: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Step("Send request DELETE '{endpoint}'")
    public static HttpResponse<String> sendRequestDelete(String endpoint) {
        HttpClient client = HttpClient.newHttpClient();
        String method = methodHTTP.DELETE;

        System.out.println("Send request: " + method + " " + mainUrl + endpoint);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(mainUrl + endpoint))
                .DELETE()
                .setHeader("Accept", "application/json")
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println("ERROR response: " + " " + method + mainUrl + endpoint + "\nCode response: " + response.statusCode() + "\nBody: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }
}