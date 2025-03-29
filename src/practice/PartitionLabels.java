package practice;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitionSizes = new ArrayList<>();
        int[] lastOccurrence = new int[26];
        int[] firstOccurrence = new int[26];
        Arrays.fill(firstOccurrence, -1);

        int partitionStart = 0, partitionEnd = 0;

        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {

            if (firstOccurrence[s.charAt(i) - 'a'] == -1) {
                firstOccurrence[s.charAt(i) - 'a'] = i;
            }

            if (partitionEnd < firstOccurrence[s.charAt(i) - 'a']) {
                partitionSizes.add(partitionEnd - partitionStart + 1);
                partitionStart = i;
                partitionEnd = i;
            }

            partitionEnd = Math.max(
                    partitionEnd,
                    lastOccurrence[s.charAt(i) - 'a']
            );
        }

        if (partitionEnd - partitionStart + 1 > 0) {
            partitionSizes.add(partitionEnd - partitionStart + 1);
        }

        return partitionSizes;
    }
}
