package ch15.sec02.exam02;

import java.util.List;
import java.util.Vector;
import ch15.sec02.exam01.Board;

public class VectorExample {
    public static void main(String[] args) {
        List<Board> list = new Vector<>();
        Thread threadA = new Thread() {
            @Override
            public void run() {
                for(int i=1; i<=1000; i++) {
                    list.add(new Board("제목"+i, "내용"+i, "글쓴이"+i));
                }
            }
        }
    }
}
