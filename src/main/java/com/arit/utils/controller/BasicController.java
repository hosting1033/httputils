package com.arit.utils.controller;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	public static String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36";

	private CloseableHttpClient httpClient = HttpClients.custom().setUserAgent(userAgent).build();

	@RequestMapping("/test")
	public String index() {
		String result = "error proxy";
		try {

			HttpGet httpget = new HttpGet(new URI("http://www.myipaddress.com/show-my-ip-address/"));

			CloseableHttpResponse response = httpClient.execute(httpget);
			try {

				HttpEntity entity = response.getEntity();
				if (entity != null) {

					result = EntityUtils.toString(entity);
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			return (e.getMessage());
		}
		return result;

	}

}
