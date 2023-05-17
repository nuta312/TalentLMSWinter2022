package com.digital.utils;

public class WaitforSeconds {
    public static void IfYouNeedTowait(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
