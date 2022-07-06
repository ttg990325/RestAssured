package test;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class POSTMethod {
    public static void main(String[] args) {
        String baseUri = "https://jsonplaceholder.typicode.com";

        RequestSpecification request = given();
        request.baseUri(baseUri);

        // Content-type -> Header
        request.header(new Header("Content-type", "application/json; charset=UTF-8"));

        //Form up request body
        String postBody = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"The req's' title\",\n" +
                "  \"body\": \"The req's body\"\n" +
                "}";
        // Send POST request
        Response response = request.body(postBody).post("/posts");
        response.prettyPrint();

        System.out.println(response.statusCode());
    }

}
