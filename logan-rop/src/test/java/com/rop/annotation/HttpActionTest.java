/**
 
 * 日    期：12-6-8
 */
package com.rop.annotation;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class HttpActionTest {

    @Test
    public void testValueOf() {
        assertEquals(HttpAction.valueOf("GET"), HttpAction.GET);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void invalidValueOf() {
        assertEquals(HttpAction.valueOf("get"), HttpAction.GET);
    }
}

