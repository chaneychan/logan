package me.ele.logan.web.response.breakfast;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tank on 15/4/23.
 */
public class CompanyDTO {

    private int id;

    private String name;

    private String location;

    private String takeawayTime;

   @JsonProperty 	
	public int getId() {
        return id;
    }

   @JsonProperty 	
	public void setId(int id) {
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

    public String getLocation() {
        return location;
    }

    @JsonProperty
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty
    public String getTakeawayTime() {
        return takeawayTime;
    }

    public void setTakeawayTime(String takeawayTime) {
        this.takeawayTime = takeawayTime;
    }
}
