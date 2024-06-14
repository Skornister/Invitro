package lib.api.endpoint;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import lib.api.HttpRequestHandler;

import java.net.http.HttpResponse;

public class CurrentCity {

    private static String responseCurrentCity;
    private static int responseStatusCurrentCity;

    @Step("Get response current-city")
    private static void getResponseCurrentCity(String city) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Get response current-city");

        String endpoint = "/ajax/current-city.php?CODE=" + city;

        HttpResponse<String> response = HttpRequestHandler.sendRequestGet(endpoint);
        responseCurrentCity = response.body();
        responseStatusCurrentCity = response.statusCode();
    }

    @Step("Return response current-city")
    public static String returnResponseCurrentCity(String city) {
        if (responseCurrentCity == null) {
            getResponseCurrentCity(city);
        }
        return responseCurrentCity;
    }

    public static void main(String[] args) {
        if (responseCurrentCity == null) {
            getResponseCurrentCity("bajmak");
        }

        Gson gson = new Gson();
        ResponseModel responseModel = gson.fromJson(responseCurrentCity, ResponseModel.class);

        System.out.println("status: " + responseStatusCurrentCity);
        System.out.println("city: " + responseModel.getCity());
        System.out.println("code: " + responseModel.getCode());
        System.out.println("guid: " + responseModel.getGuid());
    }


    private static class ResponseModel {
        private String city;
        private String code;
        private String guid;

        public String getCity() {
            return city;
        }

        public String getCode() {
            return code;
        }

        public String getGuid() {
            return guid;
        }
    }
}
