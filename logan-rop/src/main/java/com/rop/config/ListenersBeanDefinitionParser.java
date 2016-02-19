/**

 * 日    期：12-6-4
 */
package com.rop.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.parsing.CompositeComponentDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import java.util.List;


public class ListenersBeanDefinitionParser implements BeanDefinitionParser {

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        CompositeComponentDefinition compDefinition =
                new CompositeComponentDefinition(element.getTagName(), parserContext.extractSource(element));
        parserContext.pushContainingComponent(compDefinition);

        List<Element> listeners = DomUtils.getChildElementsByTagName(element, new String[]{"bean", "ref"});

        for (Element interceptor : listeners) {
            RootBeanDefinition listenerHolderDef = new RootBeanDefinition(RopEventListenerHodler.class);
            listenerHolderDef.setSource(parserContext.extractSource(interceptor));
            listenerHolderDef.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);

            Object listenerBean = parserContext.getDelegate().parsePropertySubElement(interceptor, null);
            listenerHolderDef.getConstructorArgumentValues().addIndexedArgumentValue(0, listenerBean);

            String beanName = parserContext.getReaderContext().registerWithGeneratedName(listenerHolderDef);
            parserContext.registerComponent(new BeanComponentDefinition(listenerHolderDef, beanName));
        }

        parserContext.popAndRegisterContainingComponent();
        return null;
    }
}

