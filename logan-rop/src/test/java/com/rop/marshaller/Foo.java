
package com.rop.marshaller;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
* 
* @date: 14-4-21
*/
@XmlRootElement
public class Foo implements IFoo{
    private Boolean b1;

    private boolean b2;

    private Integer i1;

    private int i2;

    private String ok;

    public Boolean getB1() {
        return b1;
    }

    public void setB1(Boolean b1) {
        this.b1 = b1;
    }

    public boolean isB2() {
        return b2;
    }

    public void setB2(boolean b2) {
        this.b2 = b2;
    }

    public Integer getI1() {
        return i1;
    }


    public void setI1(Integer i1) {
        this.i1 = i1;
    }

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
