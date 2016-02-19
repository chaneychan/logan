package me.ele.logan.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import me.ele.logan.web.request.breakfast.AreaRequest;
import me.ele.logan.web.response.breakfast.BreakfastResponse;
import me.ele.logan.web.response.breakfast.CityDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.rop.RopRequest;
import com.rop.annotation.HttpAction;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.client.RopUnmarshaller;
import com.rop.client.unmarshaller.JacksonJsonRopUnmarshaller;
import com.rop.response.BusinessServiceErrorResponse;

/**
 * @Description: 早餐接口
 * @author chaney.chan
 * @date 2015年6月17日
 */
@ServiceMethodBean(version = "1.0")
public class BreakfastService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${url.business.breakfast}")
	private String url;

	private RopUnmarshaller jsonUnmarshaller = new JacksonJsonRopUnmarshaller();

	@ServiceMethod(method = "ele.breakfast.openCitys")
	private Object openCitys(RopRequest request) {
		String content = restTemplate.getForObject(url + "city/openCitys", String.class);
		BreakfastResponse<List<CityDTO>> response = jsonUnmarshaller.unmarshaller(content, BreakfastResponse.class);
		if (!response.isSuccess()) {
			return response.getData();
		} else {
			return new BusinessServiceErrorResponse(request.getRopRequestContext(), "00000001", "上海");
		}
	}

	@ServiceMethod(method = "ele.breakfast.shopping")
	private Object shopping(RopRequest request) {
		return restTemplate.getForObject(url + "shopping/{id}", String.class, 480);
	}

	@ServiceMethod(method = "ele.breakfast.area", httpAction = HttpAction.POST)
	private Object area(AreaRequest request) {
		Map<String, String> param = new LinkedHashMap<String, String>();
		param.put("cityId", request.getCityId());
		param.put("popBuildingInclude", request.getPopBuildingInclude());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String, String>>(param, headers);
		String content = restTemplate.postForObject(url + "area", entity, String.class);
		BreakfastResponse response = jsonUnmarshaller.unmarshaller(content, BreakfastResponse.class);
		if (response.isSuccess()) {
			return response.getData();
		} else {
			return new BusinessServiceErrorResponse(request.getRopRequestContext(), "BREAKFAST_CITY_NOT_OPEN", "测试");
		}
	}
}
