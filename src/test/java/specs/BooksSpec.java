package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class BooksSpec {

    public static final RequestSpecification bookRequestSpecs = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().uri()
            .log().method();

    public static final ResponseSpecification bookResponseSpecs = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .build();
}


