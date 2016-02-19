package me.ele.logan.web;

import java.util.Date;

import me.ele.logan.web.converter.TelephoneConverter;
import me.ele.logan.web.request.breakfast.AreaRequest;

import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.rop.config.SystemParameterNames;
import com.rop.utils.DateUtils;

public class BreakfastServiceClient {
	// public static final String SERVER_URL = "http://192.168.80.37:9080/api";
	public static final String SERVER_URL = "http://localhost:8088/api";
	public static final String APP_KEY = "GA6t9TxZw0";
	public static final String APP_SECRET = "640561222986CD6BE9CE6D31DD5F8217";
	private DefaultRopClient ropClient = new DefaultRopClient(SERVER_URL, APP_KEY, APP_SECRET);

	{
		ropClient.addRopConvertor(new TelephoneConverter());
	}

	private RestTemplate restTemplate = new RestTemplate();

	@SuppressWarnings("rawtypes")
	@Test
	public void openCitys() {
		CompositeResponse response = ropClient.buildClientRequest().get(Object.class, "ele.breakfast.openCitys", "1.0");
		System.out.println(response);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void shopping() {
		CompositeResponse response = ropClient.buildClientRequest().get(String.class, "ele.breakfast.shopping", "1.0");
		System.out.println(response);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void area() {
		AreaRequest areaRequest = new AreaRequest();
		areaRequest.setCityId("1");
		areaRequest.setPopBuildingInclude("1");
		CompositeResponse response = ropClient.buildClientRequest().post(areaRequest, String.class, "ele.breakfast.area", "1.0");
		System.out.println(response);
	}
}
