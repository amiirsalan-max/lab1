package aod.lab1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Klass för att testa tidsåtgången vid insättning av element
 * i en egen LinkedList och Java ArrayList.
 *
 * @author Abdisalan Mahad Omar
 * @date 2026-04-10
 */
public class InsertionTimeTest {

    public static void main(String[] args) {
        int[] sizes = {20000, 40000, 80000, 160000, 320000, 640000};
        int repetitions = 100;
        Random rand = new Random();

        System.out.println("=== TEST AV EGEN LINKEDLIST ===");

        for (int n : sizes) {

            LinkedList<Integer> listFirst = new LinkedList<>();
            LinkedList<Integer> listMiddle = new LinkedList<>();
            LinkedList<Integer> listLast = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                int slumpTal = rand.nextInt(100);
                listFirst.add(slumpTal);
                listMiddle.add(slumpTal);
                listLast.add(slumpTal);
            }

            long startTime = System.nanoTime();
            for (int i = 0; i < repetitions; i++) {
                listFirst.add(999, 0);
            }
            long endTime = System.nanoTime();
            long firstTime = endTime - startTime;

            startTime = System.nanoTime();
            for (int i = 0; i < repetitions; i++) {
                listMiddle.add(999, listMiddle.size() / 2);
            }
            endTime = System.nanoTime();
            long middleTime = endTime - startTime;

            startTime = System.nanoTime();
            for (int i = 0; i < repetitions; i++) {
                listLast.add(999);
            }
            endTime = System.nanoTime();
            long lastTime = endTime - startTime;

            System.out.println("n = " + n);
            System.out.println("Först:  " + firstTime + " ns");
            System.out.println("Mitten: " + middleTime + " ns");
            System.out.println("Sist:   " + lastTime + " ns");
            System.out.println();
        }

        System.out.println("=== TEST AV JAVAS ARRAYLIST ===");

        for (int n : sizes) {

            ArrayList<Integer> listFirst = new ArrayList<>();
            ArrayList<Integer> listMiddle = new ArrayList<>();
            ArrayList<Integer> listLast = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int slumpTal = rand.nextInt(100);
                listFirst.add(slumpTal);
                listMiddle.add(slumpTal);
                listLast.add(slumpTal);
            }

            long startTime = System.nanoTime();
            for (int i = 0; i < repetitions; i++) {
                listFirst.add(0, 999);
            }
            long endTime = System.nanoTime();
            long firstTime = endTime - startTime;

            startTime = System.nanoTime();
            for (int i = 0; i < repetitions; i++) {
                listMiddle.add(listMiddle.size() / 2, 999);
            }
            endTime = System.nanoTime();
            long middleTime = endTime - startTime;

            startTime = System.nanoTime();
            for (int i = 0; i < repetitions; i++) {
                listLast.add(999);
            }
            endTime = System.nanoTime();
            long lastTime = endTime - startTime;

            System.out.println("n = " + n);
            System.out.println("Först:  " + firstTime + " ns");
            System.out.println("Mitten: " + middleTime + " ns");
            System.out.println("Sist:   " + lastTime + " ns");
            System.out.println();
        }
    }
}