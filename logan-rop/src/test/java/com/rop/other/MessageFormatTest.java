
package com.rop.other;

import org.testng.annotations.Test;

import java.text.MessageFormat;

/**
 * 
 * @date: 2014/7/4
 */
public class MessageFormatTest {

    @Test
    public void testFormat(){
        String str = MessageFormat.format("aaa{0}bbb{1}", "X");
        System.out.println(str);
        str = MessageFormat.format("aaa bbb", "X","Y");
        System.out.println(str);
}
}
