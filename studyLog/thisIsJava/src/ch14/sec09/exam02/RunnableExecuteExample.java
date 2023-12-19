package ch14.sec09.exam02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecuteExample {
    public static void main(String[] args) {
        String[][] mails = new String[1000][3];
        for(int i=0; i<mails.length; i++) {
            mails[i][0] = "admin@my.com";
            
        }
    }    
}
