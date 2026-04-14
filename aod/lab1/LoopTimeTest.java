package aod.lab1;

/**
 * Klass för att jämföra tidsåtgången mellan vanlig for-loop
 * och for-each-loop på en Java LinkedList.
 *
 * @author Abdisalan Mahad Omar
 * @date 2026-04-10
 */
public class LoopTimeTest {

    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};
        int repetitions = 10;


        for (int n : sizes) {
            java.util.LinkedList<Integer> list = createJavaLinkedList(n);

            long forLoopTime = measureForLoop(list, repetitions);
            long forEachTime = measureForEachLoop(list, repetitions);

            System.out.println("n = " + n);
            System.out.println("Vanlig for-loop: " + forLoopTime + " ns");
            System.out.println("For-each-loop:   " + forEachTime + " ns");
            System.out.println();
        }
    }
 // Skapar en Java LinkedList med n element
    private static java.util.LinkedList<Integer> createJavaLinkedList(int n) {
        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        return list;
    }
 
    // Mäter tiden för vanlig for-loop
    private static long measureForLoop(java.util.LinkedList<Integer> list, int repetitions) {
        long startTime = System.nanoTime();
        int sum = 0;

        for (int r = 0; r < repetitions; r++) {
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
        }

        long endTime = System.nanoTime();

        if (sum == -1) {
            System.out.println("Detta skrivs aldrig ut.");
        }

        return endTime - startTime;
    }
 // Mäter tiden för for-each-loop
    private static long measureForEachLoop(java.util.LinkedList<Integer> list, int repetitions) {
        long startTime = System.nanoTime();
        int sum = 0;

        for (int r = 0; r < repetitions; r++) {
            for (Integer element : list) {
                sum += element;
            }
        }

        long endTime = System.nanoTime();

        if (sum == -1) {
            System.out.println("Detta skrivs aldrig ut.");
        }

        return endTime - startTime;
    }
}