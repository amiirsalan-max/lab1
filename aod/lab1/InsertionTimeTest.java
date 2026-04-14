package aod.lab1;

import java.util.ArrayList;

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

        for (int n : sizes) {
            long firstTime = measureLinkedListInsertFirst(n, repetitions);
            long middleTime = measureLinkedListInsertMiddle(n, repetitions);
            long lastTime = measureLinkedListInsertLast(n, repetitions);

            System.out.println("n = " + n);
            System.out.println("Först:  " + firstTime + " ns");
            System.out.println("Mitten: " + middleTime + " ns");
            System.out.println("Sist:   " + lastTime + " ns");
            System.out.println();
        }

        for (int n : sizes) {
            long firstTime = measureArrayListInsertFirst(n, repetitions);
            long middleTime = measureArrayListInsertMiddle(n, repetitions);
            long lastTime = measureArrayListInsertLast(n, repetitions);

            System.out.println("n = " + n);
            System.out.println("Först:  " + firstTime + " ns");
            System.out.println("Mitten: " + middleTime + " ns");
            System.out.println("Sist:   " + lastTime + " ns");
            System.out.println();
        }
    }

    private static LinkedList<Integer> createLinkedListWithElements(int n) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        return list;
    }

    private static ArrayList<Integer> createArrayListWithElements(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        return list;
    }

    private static long measureLinkedListInsertFirst(int n, int repetitions) {
        LinkedList<Integer> list = createLinkedListWithElements(n);
        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            list.add(999, 0);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long measureLinkedListInsertMiddle(int n, int repetitions) {
        LinkedList<Integer> list = createLinkedListWithElements(n);
        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            list.add(999, list.size() / 2);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long measureLinkedListInsertLast(int n, int repetitions) {
        LinkedList<Integer> list = createLinkedListWithElements(n);
        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            list.add(999);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long measureArrayListInsertFirst(int n, int repetitions) {
        ArrayList<Integer> list = createArrayListWithElements(n);
        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            list.add(0, 999);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long measureArrayListInsertMiddle(int n, int repetitions) {
        ArrayList<Integer> list = createArrayListWithElements(n);
        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            list.add(list.size() / 2, 999);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long measureArrayListInsertLast(int n, int repetitions) {
        ArrayList<Integer> list = createArrayListWithElements(n);
        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            list.add(999);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}