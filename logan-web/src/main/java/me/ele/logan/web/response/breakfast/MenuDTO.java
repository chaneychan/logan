package me.ele.logan.web.response.breakfast;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by tank on 15/4/23.
 */
public class MenuDTO {
    private String date;

    private String day;

    private boolean holiday;

    private String holidayDesc;

    private String holdayPic;

    private boolean timeout;

    private boolean hasSelected;

    private List<OptionDTO> options;

    @JsonProperty
    public boolean getHasSelected() {
        return hasSelected;
    }

    @JsonProperty
    public void setHasSelected(boolean hasSelected) {
        this.hasSelected = hasSelected;
    }

   @JsonProperty
 	public String getDate() {
        return date;
    }

   @JsonProperty
 	public void setDate(String date) {
        this.date = date;
    }

   @JsonProperty
 	public String getDay() {
        return day;
    }

   @JsonProperty
 	public void setDay(String day) {
        this.day = day;
    }

   @JsonProperty
 	public boolean isHoliday() {
        return holiday;
    }

   @JsonProperty
 	public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

   @JsonProperty
 	public boolean isTimeout() {
        return timeout;
    }

   @JsonProperty
 	public void setTimeout(boolean timeout) {
        this.timeout = timeout;
    }

   @JsonProperty
 	public List<OptionDTO> getOptions() {
        return options;
    }

   @JsonProperty
 	public void setOptions(List<OptionDTO> options) {
        this.options = options;
    }

    @JsonProperty
    public String getHolidayDesc() {
        return holidayDesc;
    }

    @JsonProperty
    public void setHolidayDesc(String holidayDesc) {
        this.holidayDesc = holidayDesc;
    }

    @JsonProperty
    public String getHoldayPic() {
        return holdayPic;
    }

    @JsonProperty
    public void setHoldayPic(String holdayPic) {
        this.holdayPic = holdayPic;
    }
}
