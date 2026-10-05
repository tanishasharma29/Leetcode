import java.util.*; //T.C = 0(n) S.C=0(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Counting frequency
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        //Creating buckets
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num : freq.keySet()) {
            int frequency = freq.get(num);

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        // Getting top k elements
        int[] result = new int[k];
        int index = 0;

        for (int frequency = buckets.length - 1;
             frequency >= 0 && index < k;
             frequency--) {

            if (buckets[frequency] != null) {

                for (int num : buckets[frequency]) {

                    result[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}