package me.ele.logan.web.response.breakfast;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by tank on 15/4/23.
 */
public class BuildingDTO {

    private Long id;

    private String name;

    private List<MenuDTO> menus;


    private List<CompanyDTO> locations;

   @JsonProperty
 	public long getId() {
        return id;
    }

   @JsonProperty
 	public void setId(long id) {
        this.id = id;
    }

   @JsonProperty
 	public String getName() {
        return name;
    }

   @JsonProperty
 	public void setName(String name) {
        this.name = name;
    }

   @JsonProperty
 	public List<MenuDTO> getMenus() {
        return menus;
    }

   @JsonProperty
 	public void setMenus(List<MenuDTO> menus) {
        this.menus = menus;
    }

    @JsonProperty
    public List<CompanyDTO> getLocations() {
        return locations;
    }

    @JsonProperty
    public void setLocations(List<CompanyDTO> locations) {
        this.locations = locations;
    }
}
