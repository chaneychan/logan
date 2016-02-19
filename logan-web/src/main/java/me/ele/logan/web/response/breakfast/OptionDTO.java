package me.ele.logan.web.response.breakfast;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created by tank on 15/4/23.
 */
public class OptionDTO {
    private long id;

    private String name;

    private String desc;

    private String restaurantName;

    private String img;

    private BigDecimal price;

    private BigDecimal discounted;

    private boolean noStock;

    private int recommend;



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
 	public String getDesc() {
        return desc;
    }

   @JsonProperty
 	public void setDesc(String desc) {
        this.desc = desc;
    }

   @JsonProperty
 	public String getImg() {
        return img;
    }

   @JsonProperty
 	public void setImg(String img) {
        this.img = img;
    }

   @JsonProperty
 	public BigDecimal getPrice() {
        return price;
    }

   @JsonProperty
 	public void setPrice(BigDecimal price) {
        this.price = price;
    }

   @JsonProperty
 	public BigDecimal getDiscounted() {
        return discounted;
    }

   @JsonProperty
 	public void setDiscounted(BigDecimal discounted) {
        this.discounted = discounted;
    }

   @JsonProperty
 	public boolean isNoStock() {
        return noStock;
    }

   @JsonProperty
 	public void setNoStock(boolean noStock) {
        this.noStock = noStock;
    }

   @JsonProperty
 	public int getRecommend() {
        return recommend;
    }

   @JsonProperty
 	public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    @JsonProperty
    public String getRestaurantName() {
        return restaurantName;
    }

    @JsonProperty
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
