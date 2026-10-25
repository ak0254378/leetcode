import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            seen.add(num);
        }

        int longest = 0;

        for (int num : seen) {
            if (!seen.contains(num - 1)) {
                int current = num;
                int streak = 1;

                while (current != Integer.MAX_VALUE &&
                       seen.contains(current + 1)) {
                    current++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }
}
