
package com.rop.marshaller;

import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @date: 14-4-21
 */
public interface IFoo {

    @XmlTransient
    Integer getI1();
}
