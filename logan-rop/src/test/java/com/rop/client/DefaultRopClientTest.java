
package com.rop.client;

import org.testng.annotations.Test;


public class DefaultRopClientTest {

    private RopClient ropClient = new DefaultRopClient("http://localhost:8088/router", "00001", "abcdeabcdeabcdeabcdeabcde");

    @Test
    public void testPostWithSession() throws Exception {

    }
}

