package ch15.sec05.exam01;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();

        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);

        for(Integer s : scores) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        System.out.println("가장 낮은 점수: " + scores.first());
        System.out.println("가장 높은 점수: " + scores.last());
        System.out.println("95점 아래 점수: " + scores.lower(95));
        System.out.println("95점 위의 점수: " + scores.higher(95));
        System.out.println("95점이거나 바로 아래 점수: " + scores.floor(95));
        System.out.println("85점이거나 바로 위의 점수: " + scores.ceiling(85) + "\n");

        NavigableSet<Integer> descendingScores = scores.descendingSet();
        for(Integer s : descendingScores) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        NavigableSet<Integer> rangeSet = scores.tailSet(80, true);
        for(Integer s : rangeSet) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        rangeSet = scores.subSet(80, true, 90, false);
        for(Integer s : rangeSet) {
            System.out.print(s + " ");
        }
    }
}