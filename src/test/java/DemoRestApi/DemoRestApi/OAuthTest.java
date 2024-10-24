package DemoRestApi.DemoRestApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse1;

import static io.restassured.RestAssured.*;

public class OAuthTest {

	public static void main(String[] args) {
	
		
		String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials").formParam("scope", "trust")
				.when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String accesstoken = js.getString("access_token");
		
		
		GetCourse1 gc = given().queryParam("access_token", accesstoken)
		.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
		.as(GetCourse1.class);
		//System.out.println(response2);
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getcourses().getApi().get(1).getCourseTitle());

	}

}
