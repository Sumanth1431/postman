package DemoRestApi.DemoRestApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.io.File;

public class BugApi {
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
	
			RestAssured.baseURI = "https://sumanthmb15.atlassian.net/";		
			String createIssueResponse 	= given()		.header("Content-Type","application/json")		.header("Authorization","Basic c3VtYW50aG1iMTVAZ21haWwuY29tOkFUQVRUM3hGZkdGMDkxblJHS1U2MklWRmRWbW9kQzBCa0trM1dxdFJqcUlHeWpmM2RGSHpFb2ttNmdXZlJlMmRWcEVfR196MFpabUk5QjJseG4yLXg4c3JZZDFoMEdOeUpzVVFNTS1LOE5hdHF2cEJaZUlEeGNFVlZycTdjdFJvcUhyRXgtRWw4Tno0T09fQUhNTFhYbWJIcS13dzVlczl1aHBwZmRPSk1EbGFZSU12cTUxOVB2Yz1EOEJBQjg2RA==")		.body("{\n"				+ "    \"fields\": {\n"				+ "       \"project\":\n"				+ "       {\n"				+ "          \"key\": \"SCRUM\"\n"				+ "       },\n"				+ "       \"summary\": \" Not working- automation Rest Assured\",\n"				+ "       \"issuetype\": {\n"				+ "          \"name\": \"Bug\"\n"				+ "       }\n"				+ "   }\n"				+ "}")		.log().all()		.post("rest/api/3/issue").then().log().all().assertThat().statusCode(201).contentType("application/json")		.extract().response().asString();		 	
			JsonPath js = new JsonPath(createIssueResponse);		
			String issueId = js.getString("id");		
			System.out.println(issueId);		 	
			given()			.pathParam("key", issueId)			.header("X-Atlassian-Token","no-check")			.header("Authorization","Basic c3VtYW50aG1iMTVAZ21haWwuY29tOkFUQVRUM3hGZkdGMDkxblJHS1U2MklWRmRWbW9kQzBCa0trM1dxdFJqcUlHeWpmM2RGSHpFb2ttNmdXZlJlMmRWcEVfR196MFpabUk5QjJseG4yLXg4c3JZZDFoMEdOeUpzVVFNTS1LOE5hdHF2cEJaZUlEeGNFVlZycTdjdFJvcUhyRXgtRWw4Tno0T09fQUhNTFhYbWJIcS13dzVlczl1aHBwZmRPSk1EbGFZSU12cTUxOVB2Yz1EOEJBQjg2RA== ")			.multiPart("file",new File("C:/Users/jshar/OneDrive/Pictures/lord shiva.jpg")).log().all()			.post("rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);			
					 		 //Add attachment		 		 		 		 		 							}
}}