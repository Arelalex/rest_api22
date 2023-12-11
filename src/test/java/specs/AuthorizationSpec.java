package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class AuthorizationSpec {

    public static RequestSpecification authorizationRequestSpecs = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().method()
            .contentType(JSON);

    public static ResponseSpecification authorizationResponseSpecs = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .build();
}
