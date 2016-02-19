package me.ele.logan.web.request.breakfast;

import javax.validation.constraints.NotNull;

import com.rop.AbstractRopRequest;

public class AreaRequest extends AbstractRopRequest {

	@NotNull
	private String cityId;
	
	@NotNull
	private String popBuildingInclude;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getPopBuildingInclude() {
		return popBuildingInclude;
	}

	public void setPopBuildingInclude(String popBuildingInclude) {
		this.popBuildingInclude = popBuildingInclude;
	}
}
