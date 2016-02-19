
package com.rop.client.unmarshaller;

import com.rop.RopException;
import com.rop.client.RopUnmarshaller;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class JaxbXmlRopUnmarshaller implements RopUnmarshaller {

    private static Map<Class, JAXBContext> jaxbContextHashMap = new ConcurrentHashMap<Class, JAXBContext>();


    public <T> T unmarshaller(String content, Class<T> objectType) {
        try {
            Unmarshaller unmarshaller = buildUnmarshaller(objectType);
            StringReader reader = new StringReader(content);
            new InputSource(reader);
            return (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new RopException(e);
        }

    }

    private Unmarshaller buildUnmarshaller(Class<?> objectType) throws JAXBException {
        if (!jaxbContextHashMap.containsKey(objectType)) {
            JAXBContext context = JAXBContext.newInstance(objectType);
            jaxbContextHashMap.put(objectType, context);
        }
        JAXBContext context = jaxbContextHashMap.get(objectType);
        Unmarshaller unmarshaller = context.createUnmarshaller();
//        unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        unmarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        return unmarshaller;
    }
}

