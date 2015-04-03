package com.soft.apitest;

import java.net.URLEncoder;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

public class GetAccessTokenCall {
	@Test
	public void getAccessTokenFromTwitter() {

		String consumerKey = "V5FRctUxTc0inw4kZ1juDv4Yl";
		String consumerSecret = "e7GndvCp7cOwvBw2d2LzFomFVRRASkXOGoqUhiQC0TelOXoR5w";

		byte[] identifier = Base64.encode(URLEncoder.encode(consumerKey) + ":"
				+ URLEncoder.encode(consumerSecret));

		Client client = Client.create();
		WebResource webResource = client
				.resource("https://api.twitter.com/oauth2/token");

		String test = "grant_type=client_credentials";

		JSONObject response = webResource
				.header("Authorization", "Basic " + new String(identifier))
				.header("Content-Type",
						"application/x-www-form-urlencoded;charset=UTF-8")
						.post(JSONObject.class, test);

		// Decode JSON Object to get Access Token
		try {
			Assert.assertTrue((response.getString("access_token") != null)
					&& (response.getString("access_token").length() > 0));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
