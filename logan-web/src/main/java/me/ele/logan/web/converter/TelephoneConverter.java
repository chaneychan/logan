
package me.ele.logan.web.converter;

import me.ele.logan.web.request.Telephone;

import org.springframework.util.StringUtils;

import com.rop.request.RopConverter;


public class TelephoneConverter implements RopConverter<String, Telephone> {


    public Telephone convert(String source) {
        if (StringUtils.hasText(source)) {
            String zoneCode = source.substring(0, source.indexOf("-"));
            String telephoneCode = source.substring(source.indexOf("-") + 1);
            Telephone telephone = new Telephone();
            telephone.setZoneCode(zoneCode);
            telephone.setTelephoneCode(telephoneCode);
            return telephone;
        } else {
            return null;
        }
    }


    public String unconvert(Telephone target) {
        StringBuilder sb = new StringBuilder();
        sb.append(target.getZoneCode());
        sb.append("-");
        sb.append(target.getTelephoneCode());
        return sb.toString();
    }


    public Class<String> getSourceClass() {
        return String.class;
    }


    public Class<Telephone> getTargetClass() {
        return Telephone.class;
    }
}

