package steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CurrentCity {

    private static Response response;

    @Given("Получить ответ запроса API current-city {string}")
    public static void getResponseCurrentCity(String city) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Получить ответ запроса API current-city " + city);

        String endpoint = "/local/ajax/current-city.php?CODE=" + city;

        response = RestAssured.given()
                .baseUri("https://www.invitro.ru")
                .accept("application/json")
                .when()
                .get(endpoint);

        String responseBody = response.getBody().asString();
        System.out.println("response: " + Rest.decodeUnicode(responseBody));
    }

    @Then("Сравнить 'city' в ответе API current-city с {string}")
    public static void assertCity(String city) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Сравнить 'city' в ответе API current-city с " + city);
        String responseCity = response.jsonPath().getString("city");
        System.out.println("city in response: " + responseCity);
        Assertions.assertEquals(city, responseCity, "city in response not equals: " + responseCity);
    }

    @And("Сравнить 'code' в ответе API current-city с {string}")
    public static void assertCode(String code) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Сравнить 'code' в ответе API current-city с " + code);
        String responseCode = response.jsonPath().getString("code");
        System.out.println("code in response: " + responseCode);
        Assertions.assertEquals(code, responseCode, "code in response not equals: " + responseCode);
    }

    @And("Проверка кода ответа {int}")
    public static void assertCodeResponse(int code) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ": Проверка кода ответа " + code);
        int responseStatusCode = response.getStatusCode();
        Assertions.assertEquals(code, responseStatusCode, "status: " + responseStatusCode + " != " + code);
        System.out.println("status: " + responseStatusCode);
    }

    public static void main(String[] args) {
        getResponseCurrentCity("bajmak");
        String responseBody = Rest.decodeUnicode(response.getBody().asString());
        System.out.println("Response body: " + responseBody);

        System.out.println("status: " + response.getStatusCode());
        System.out.println("city: " + response.jsonPath().getString("city"));
        System.out.println("code: " + response.jsonPath().getString("code"));
        System.out.println("guid: " + response.jsonPath().getString("guid"));
    }
}
