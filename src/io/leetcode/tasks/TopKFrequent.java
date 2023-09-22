package io.leetcode.tasks;

import java.util.*;

public class TopKFrequent {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> tmp = new HashMap<>();
        List<String> resLst = new ArrayList<>();

        for (var word : words) {
            tmp.put(word, tmp.getOrDefault(word, 0) + 1);
        }

        ArrayList<String>[] res = new ArrayList[words.length];

        tmp.forEach((key, value) -> {
            if (res[value] == null) {
                ArrayList<String> lst = new ArrayList<>();
                lst.add(key);
                res[value] = lst;
            } else {
                res[value].add(key);
            }
        });

        for (int i = res.length - 1; i > 0; i--) {
            ArrayList<String> lst = res[i];

            if (lst == null) continue;

            Collections.sort(lst);
            for (var word : lst) {
                resLst.add(word);
                k--;
                if (k == 0) return resLst;
            }
        }

        return resLst;
    }

    public static List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> tmp = new HashMap<>();

        for (var word : words) {
            tmp.put(word, tmp.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    int freq1 = tmp.get(o1);
                    int freq2 = tmp.get(o2);

                    if (freq1 == freq2) return o2.compareTo(o1);
                    else return freq1 - freq2;
                }
        );

        tmp.forEach((key, value) -> {
            pq.add(key);

            if (pq.size() > k) {
                pq.poll();
            }
        });

        List<String> res = new ArrayList<>(pq);
        Collections.reverse(res);

        return res;
    }

//    public static int[] topKFrequent1(int[] nums, int k) {
//        Map<Integer, Integer> freq = new HashMap<>();
//        List<List<Integer>> freqArr = new ArrayList<>();
////        Set<Integer> set = new HashSet<>();
//
//
//        for (int num : nums) freq.merge(num, 1, Integer::sum);
//
//        for(Map.Entry<Integer, Integer> kv: freq.entrySet()) {
//            if (freqArr.isEmpty()) {
////                freqArr.add();
//            }
//
//            List<Integer> currentEl = freqArr.get(kv.getValue());
//            if(currentEl == null) {
//                currentEl = new ArrayList<>();
//            }
//            currentEl.add(kv.getKey());
//            freqArr.set(kv.getValue(), currentEl);
//        }
//
//        int[] res = new int[k];
//
//        int j = freqArr.size() - 1;
//        int count = 0;
//
//        while(j >= 0) {
//            List lst = freqArr.get(j);
//
//            if (lst != null) {
//                while(!lst.isEmpty() && count <= k) {
//                    res[count] = lst.get(j);
//                    lst.remove(j);
//                }
//            }
//
//            if (count == k) return res;
//            j--;
//        }
//
//        return res;
//    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num: nums) {
            freq.merge(num, 1, Integer::sum); //getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> freq.get(o2).compareTo(freq.get(o1))
        );

        freq.forEach((key, val) -> {
            pq.add(key);

            if (pq.size() > k)
                pq.poll();
        });

        List<Integer> res = new ArrayList<>(pq);
        Collections.reverse(res);

        return res.stream().mapToInt(i -> i).toArray();
    }
}
