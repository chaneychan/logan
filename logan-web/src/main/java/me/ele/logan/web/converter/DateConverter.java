
package me.ele.logan.web.converter;

import java.util.Date;

import com.rop.request.RopConverter;
import com.rop.utils.DateUtils;


public class DateConverter implements RopConverter<String,Date> {


    public Date convert(String s) {
        return DateUtils.parseDate(s);
    }


    public String unconvert(Date date) {
        return DateUtils.format(date,DateUtils.DATETIME_FORMAT);
    }


    public Class<String> getSourceClass() {
        return String.class;
    }


    public Class<Date> getTargetClass() {
        return Date.class;
    }
}
