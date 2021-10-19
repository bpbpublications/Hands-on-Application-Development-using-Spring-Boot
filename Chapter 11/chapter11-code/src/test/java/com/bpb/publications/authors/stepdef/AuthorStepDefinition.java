package com.bpb.publications.authors.stepdef;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "dev")
@AutoConfigureMockMvc
public class AuthorStepDefinition {
	@Autowired
	private MockMvc mvc;

	ResultActions action;

	@When("^the client calls /author/add with name \"([^\"]*)\" , url \"([^\"]*)\" and bio \"([^\"]*)\"$")
	public void addAuthor(String name, String url, String bio) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("url", url);
		jsonObject.put("bio", bio);
		action = mvc.perform(MockMvcRequestBuilders.post("/author/add").content(jsonObject.toString())
				.contentType(MediaType.APPLICATION_JSON));
	}

	@Then("^the client receives status code of (-?\\d+)$")
	public void verifyResponseCode(Integer status) throws Exception {
		action.andExpect(status().is(status));
	}

	@When("^the client calls /author with name \"([^\"]*)\" and url \"([^\"]*)\"$")
	public void getAuthorNyNameAndUrl(String name, String url) throws Exception {
		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
		queryParams.add("name", name);
		queryParams.add("url", url);
		action = mvc.perform(MockMvcRequestBuilders.get("/author").queryParams(queryParams));
	}
}
