package steps.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rest {

    public interface methodHTTP {
        String GET = "GET";
        String POST = "POST";
        String PUT = "PUT";
        String DELETE = "DELETE";
    }

    static String mainUrl = "https://www.invitro.ru";

    public static Response sendRequestGet(String endpoint) {
        String method = methodHTTP.GET;
        System.out.println("Send request: " + method + " " + mainUrl + endpoint);

        Response response = RestAssured.given()
                .baseUri(mainUrl)
                .accept("application/json")
                .when()
                .get(endpoint);

        if (response.getStatusCode() != 200) {
            System.out.println("ERROR response: " + " " + method + " " + mainUrl + endpoint + "\nCode response: " + response.getStatusCode() + "\nBody: " + response.getBody().asString());
        }

        return response;
    }

    public static Response sendRequestPost(String endpoint, String body) {
        String method = methodHTTP.POST;

        System.out.println("Send request: " + method + " " + mainUrl + endpoint);

        Response response = RestAssured.given()
                .baseUri(mainUrl)
                .accept("application/json")
                .contentType("application/x-www-form-urlencoded;charset=utf-8")
                .body(body)
                .when()
                .post(endpoint);

        if (response.getStatusCode() != 200) {
            System.out.println("ERROR response: " + " " + method + " " + mainUrl + endpoint + "\nCode response: " + response.getStatusCode() + "\nBody: " + response.getBody().asString());
        }

        return response;
    }

    public static Response sendRequestPut(String endpoint, String body) {
        String method = methodHTTP.PUT;

        System.out.println("Send request: " + method + " " + mainUrl + endpoint);

        Response response = RestAssured.given()
                .baseUri(mainUrl)
                .accept("application/json")
                .contentType("application/x-www-form-urlencoded;charset=utf-8")
                .body(body)
                .when()
                .put(endpoint);

        if (response.getStatusCode() != 200) {
            System.out.println("ERROR response: " + " " + method + " " + mainUrl + endpoint + "\nCode response: " + response.getStatusCode() + "\nBody: " + response.getBody().asString());
        }

        return response;
    }

    public static Response sendRequestDelete(String endpoint) {
        String method = methodHTTP.DELETE;

        System.out.println("Send request: " + method + " " + mainUrl + endpoint);

        Response response = RestAssured.given()
                .baseUri(mainUrl)
                .accept("application/json")
                .when()
                .delete(endpoint);

        if (response.getStatusCode() != 200) {
            System.out.println("ERROR response: " + " " + method + " " + mainUrl + endpoint + "\nCode response: " + response.getStatusCode() + "\nBody: " + response.getBody().asString());
        }

        return response;
    }

    public static String decodeUnicode(String unicode) {
        StringBuilder decodedString = new StringBuilder();
        int length = unicode.length();

        for (int i = 0; i < length; i++) {
            if (unicode.charAt(i) == '\\' && unicode.charAt(i + 1) == 'u') {
                String hexCode = unicode.substring(i + 2, i + 6);
                char decodedChar = (char) Integer.parseInt(hexCode, 16);
                decodedString.append(decodedChar);
                i += 5;
            } else {
                decodedString.append(unicode.charAt(i));
            }
        }

        return decodedString.toString();
    }
}