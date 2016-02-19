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


public class InterceptorsBeanDefinitionParser implements BeanDefinitionParser {


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        CompositeComponentDefinition compDefinition = new CompositeComponentDefinition(element.getTagName(), parserContext.extractSource(element));
        parserContext.pushContainingComponent(compDefinition);
        List<Element> interceptors = DomUtils.getChildElementsByTagName(element, new String[]{"bean", "ref"});

        for (Element interceptor : interceptors) {
            RootBeanDefinition interceptorHolderDef = new RootBeanDefinition(InterceptorHolder.class);
            interceptorHolderDef.setSource(parserContext.extractSource(interceptor));
            interceptorHolderDef.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);

            Object interceptorBean = parserContext.getDelegate().parsePropertySubElement(interceptor, null);
            interceptorHolderDef.getConstructorArgumentValues().addIndexedArgumentValue(0, interceptorBean);


            String beanName = parserContext.getReaderContext().registerWithGeneratedName(interceptorHolderDef);
            parserContext.registerComponent(new BeanComponentDefinition(interceptorHolderDef, beanName));
        }

        parserContext.popAndRegisterContainingComponent();
        return null;
    }
}

