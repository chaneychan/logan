package me.ele.logan.web.response.breakfast;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by tank on 15/4/23.
 */
public class AreaDTO {

    private int areaId;

    private String name;

    private List<BuildingDTO> buildings;

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public int getAreaId() {
        return areaId;
    }

    @JsonProperty
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @JsonProperty
    public List<BuildingDTO> getBuildings() {
        return buildings;
    }

    @JsonProperty
    public void setBuildings(List<BuildingDTO> buildings) {
        this.buildings = buildings;
    }
}
