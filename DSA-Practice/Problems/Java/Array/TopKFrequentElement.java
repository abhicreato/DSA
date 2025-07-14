import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElement {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            // Using Bucket sort algo
            Map<Integer, Integer> freqMap = new HashMap<>();
            int[] ans = new int[k];
            ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

            // Count frequencies in map
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            for (Map.Entry e : freqMap.entrySet()) {
                int key = (int) e.getKey();
                int value = (int) e.getValue();
                if (bucket[value] != null) {
                    bucket[value].add(key);
                } else {
                    ArrayList<Integer> t = new ArrayList();
                    t.add(key);
                    bucket[value] = t;
                }

            }

            int f = 0;

            for (int i = bucket.length - 1; i > 0 && f < k; i--) {
                if (bucket[i] != null) {
                    for (int n : bucket[i]) {
                        ans[f] = n;
                        f++;
                    }

                }
            }

            return ans;

        }

        public int[] topKFrequent2(int[] nums, int k) {

            Map<Integer, Integer> freqMap = new HashMap<>();
            int[] ans = new int[k];
            // Count frequencies in map
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            return freqMap.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // sort by frequency desc
                    .limit(k)
                    .map(Map.Entry::getKey)
                    .mapToInt(Integer::intValue)
                    .toArray();

        }

        public int[] topKFrequent3(int[] nums, int k) {
            Map<Integer, Integer> freqMap = new HashMap<>();

            // Step 1: Count frequencies
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // Step 2: Bucket sort based on frequency
            List<Integer>[] buckets = new List[nums.length + 1];
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                int freq = entry.getValue();
                if (buckets[freq] == null) {
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add(entry.getKey());
            }

            // Step 3: Collect top k frequent elements
            int[] result = new int[k];
            int index = 0;

            for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
                if (buckets[i] != null) {
                    for (int num : buckets[i]) {
                        result[index++] = num;
                        if (index == k)
                            break;
                    }
                }
            }

            return result;
        }

    }

}
