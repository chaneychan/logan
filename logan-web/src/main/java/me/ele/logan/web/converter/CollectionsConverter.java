
package me.ele.logan.web.converter;

import java.util.Collection;

import com.rop.request.RopConverter;


public class CollectionsConverter implements RopConverter<String, Collection> {


    public String unconvert(Collection target) {
        return null;
    }


    public Class<String> getSourceClass() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public Class<Collection> getTargetClass() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public Collection convert(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
