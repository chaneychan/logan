
package com.rop.marshaller;

/**
 * 
 * @date: 14-4-21
 */
public class Bar {

    private String fld1 = "a";

    private String fld2 = "b";

    private Foo foo;

    public String getFld1() {
        return fld1;
    }

    public void setFld1(String fld1) {
        this.fld1 = fld1;
    }

    public String getFld2() {
        return fld2;
    }

    public void setFld2(String fld2) {
        this.fld2 = fld2;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}
