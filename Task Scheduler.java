import java.util.Arrays;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCounts = new int[26]; // Count of each task

        for (char task : tasks) {
            charCounts[task - 'A']++;
        }

        Arrays.sort(charCounts); // Sort the task counts in ascending order

        int maxCount = charCounts[25]; // Get the task with the highest count

        int idleSlots = (maxCount - 1) * n;

        for (int i = 24; i >= 0 && charCounts[i] > 0; i--) {
            idleSlots -= Math.min(maxCount - 1, charCounts[i]);
        }

        idleSlots = Math.max(0, idleSlots);

        return tasks.length + idleSlots;
    }
}