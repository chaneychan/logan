/**
 
 * 日    期：12-2-29
 */
package me.ele.logan.web.response;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import me.ele.logan.web.sys.DateXmlAdapter;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "createUserResponse")
public class CreateUserResponse{

    @XmlAttribute
    private String userId;

    @XmlAttribute
    private String createTime;

    @XmlElement
    private Foo foo = new Foo("0","0");

    @XmlElement
    private String feedback;

    @XmlAttribute
    private Boolean status = true;

    @XmlAttribute
    private Integer age = 10;

    @XmlAttribute
    private Float height = 170.01f;

    @XmlElement
    private List<Foo> fooList;

    @XmlElement
    private LinkedHashMap<String,String> maps = new LinkedHashMap<String,String>();
    {
        maps.put("a","a");
        maps.put("b","b");
        maps.put("c","c");
    }

    @XmlElement
    @XmlJavaTypeAdapter(DateXmlAdapter.class)
    private Date date;

    private boolean ok = true;

    public List<Foo> getFooList() {
        return fooList;
    }

    public void setFooList(List<Foo> fooList) {
        this.fooList = fooList;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFeedback() {
        return feedback;
    }

    public LinkedHashMap<String, String> getMaps() {
        return maps;
    }

    public void setMaps(LinkedHashMap<String, String> maps) {
        this.maps = maps;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

