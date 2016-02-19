
package me.ele.logan.web.sys;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.rop.utils.DateUtils;


public class DateXmlAdapter extends XmlAdapter<String,Date> {


    public Date unmarshal(String v) throws Exception {
        return DateUtils.parseDate(v);
    }


    public String marshal(Date date) throws Exception {
        return DateUtils.format(date,DateUtils.DATETIME_FORMAT);
    }
}
