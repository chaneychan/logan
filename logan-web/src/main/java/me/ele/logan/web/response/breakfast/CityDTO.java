package me.ele.logan.web.response.breakfast;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by fanwenbin on 15/4/22.
 */
public class CityDTO {
    private Integer cityId;

    private String cityName;

    private Integer isOpen;

    private List<AreaDTO> areas;

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<AreaDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaDTO> areas) {
        this.areas = areas;
    }
}
