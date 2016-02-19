/**
 
 * 日    期：12-8-2
 */
package com.rop.other;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class FunctionTest {

    @Test
    public void testStringSplit(){
        String str = "A,B";
        String[] items = str.split(",");
        System.out.println("size:"+items.length);
        for (String item : items) {
            System.out.println("item:"+item);
        }
    }

    @Test
        public void testArrayToList(){
            String str = "A,B";
            String[] items = str.split(",");
            List<String> list = Arrays.asList(items);
            System.out.println("size:"+list.size());
            for (String s : list) {
                System.out.println("item:"+s);
            }
        }
}

