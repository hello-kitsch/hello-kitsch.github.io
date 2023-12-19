package ch14.sec09.exam01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5); //스레드풀 생성
        //작업 생성과 처리 요청
        executorService.shutdownNow(); //스레드풀 종료
    }
}