import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.IntStream;

public class TheJoyOfTheFirstOne {

    public int[] letsGoParty(int[] bigArray, int resultSize) {
        PriorityQueue<Integer> theSmallest = new PriorityQueue<>(resultSize + 1, Comparator.reverseOrder());

        for (int i = 0; i <= resultSize; i++) {
            theSmallest.offer(bigArray[i]);
        }
        int theLargest = theSmallest.poll(); // Borramos el elemento con prioridad más alta

        for (int i = resultSize - 1; i < bigArray.length; i++) {
            if (bigArray[i] > theLargest)
                continue;
            theSmallest.offer(bigArray[i]); // Agregamos el nuevo elemento.
            theLargest = theSmallest.poll(); // Borramos el elemento con prioridad más alta.
        }

        int[] result = new int[resultSize];
        for (int i = 0; i < resultSize; i++) {
            result[i] = theSmallest.poll();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        TheJoyOfTheFirstOne joy = new TheJoyOfTheFirstOne();

        Random random = new Random(42);
        final IntStream ints = random.ints(200_000_000, 0, Integer.MAX_VALUE);
        int[] array = ints.toArray();

        long init = System.currentTimeMillis();
        final int[] solution = joy.letsGoParty(array, 50);
        System.out.println("Time: " + (System.currentTimeMillis() - init) + "ms");
        System.out.println("Fin");

        // for (int i = 0; i < solution.length; i++) {
        // System.out.println(solution[i]);
        // }
        // System.out.println("Array original");
        // for (int i = 0; i < array.length; i++) {
        // System.out.println(array[i]);
        // }
    }
}