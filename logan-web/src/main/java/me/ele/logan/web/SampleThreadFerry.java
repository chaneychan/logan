/**
 
 * 日    期：12-7-20
 */
package me.ele.logan.web;

import com.rop.ThreadFerry;


public class SampleThreadFerry implements ThreadFerry{


    public void doInSrcThread() {
        System.out.println("doInSrcThread:"+Thread.currentThread().getId());
    }


    public void doInDestThread() {
        System.out.println("doInSrcThread:"+Thread.currentThread().getId());
    }
}

