/**

 * 日    期：12-6-21
 */
package com.rop.session;

import com.rop.CommonConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public  abstract class AbstractSession implements Session {

    private Map<String, Object> attributes = new HashMap<String, Object>();


    public void setAttribute(String name, Object obj) {
        markChanged();
        attributes.put(name, obj);
    }


    public Object getAttribute(String name) {
        markChanged();
        return attributes.get(name);
    }


    public Map<String, Object> getAllAttributes() {
        Map<String, Object> tempAttributes = new HashMap<String, Object>(attributes.size());
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            if (!CommonConstant.SESSION_CHANGED.equals(entry.getKey())) {
                tempAttributes.put(entry.getKey(),entry.getValue());
            }
        }
        return tempAttributes;
    }


    public void removeAttribute(String name) {
        markChanged();
        attributes.remove(name);
    }


    public boolean isChanged() {
        return attributes.containsKey(CommonConstant.SESSION_CHANGED);
    }

    private void markChanged(){
        attributes.put(CommonConstant.SESSION_CHANGED,Boolean.TRUE);
    }
}

