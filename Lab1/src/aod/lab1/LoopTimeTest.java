package aod.lab1;

import java.util.LinkedList;
import java.util.Random;

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
        Random rand = new Random();

        System.out.println("=== TEST AV FOR-LOOP OCH FOR-EACH ===");

        for (int n : sizes) {

            // Skapa lista
            LinkedList<Integer> list = new LinkedList<>();

            // Fyll listan med slumpmässiga tal
            for (int i = 0; i < n; i++) {
                int slumpTal = rand.nextInt(100);
                list.add(slumpTal);
            }

            // ===== VANLIG FOR-LOOP =====
            long startTime = System.nanoTime();
            int sum1 = 0;

            for (int r = 0; r < repetitions; r++) {
                for (int i = 0; i < list.size(); i++) {
                    sum1 += list.get(i);
                }
            }

            long endTime = System.nanoTime();
            long forLoopTime = endTime - startTime;

            // ===== FOR-EACH LOOP =====
            startTime = System.nanoTime();
            int sum2 = 0;

            for (int r = 0; r < repetitions; r++) {
                for (Integer element : list) {
                    sum2 += element;
                }
            }

            endTime = System.nanoTime();
            long forEachTime = endTime - startTime;

            // För att Java inte ska optimera bort koden
            if (sum1 == -1 || sum2 == -1) {
                System.out.println("Detta skrivs aldrig ut.");
            }

            // Utskrift
            System.out.println("n = " + n);
            System.out.println("Vanlig for-loop: " + forLoopTime + " ns");
            System.out.println("For-each-loop:   " + forEachTime + " ns");
            System.out.println();
        }
    }
}