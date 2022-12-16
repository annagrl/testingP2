import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

//Testes utilizando o RestAssured
// Validação de Status Code e Content Type

public class Test01 {

    @Test
    public void api_test_01() {
        Response resposta = RestAssured.get("https://postman-echo.com/ip");

        System.out.println(resposta.getStatusCode());
        System.out.println(resposta.getBody().asString());

        ValidatableResponse validation = resposta.then();
        validation.statusCode(200);
        validation.contentType(ContentType.JSON);






    }

}
