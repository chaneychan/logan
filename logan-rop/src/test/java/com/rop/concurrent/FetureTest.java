/**
 
 * 日    期：12-6-5
 */
package com.rop.concurrent;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.*;


public class FetureTest {

    @Test
    public void testFetureInterrupt() {
        final ExecutorService exec = Executors.newFixedThreadPool(5);
        Callable<String> call = new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(500);
                return "Feture";
            }
        };
        Future<String> task = exec.submit(call);
        String result = null;
        try {
            while (!task.isDone()) {
                result = task.get(200, TimeUnit.MILLISECONDS);
            }
        } catch (InterruptedException e) {
            result = "InterruptedException";
        } catch (ExecutionException e) {
            result = "ExecutionException";
        } catch (TimeoutException e) {
            result = "TimeoutException";
        }

        Assert.assertEquals(result, "TimeoutException");

        //关闭线程池
        exec.shutdown();
    }
}

