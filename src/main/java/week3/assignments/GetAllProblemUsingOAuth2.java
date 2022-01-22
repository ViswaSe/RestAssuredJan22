package week3.assignments;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllProblemUsingOAuth2 extends BaseClass {
	
	@Test
	public void getAllProblem()
	{
		response = requestSpecification
				.param("sysparm_limit", "20")
				.get()
				.then().assertThat()
				.contentType(ContentType.JSON)
				.statusCode(200).extract().response();
		
		int number = response.jsonPath().getList("result.number").size();
		System.out.println(number);
	}

}
