import io.leetcode.tasks.NeetCodeBinarySearch;
import io.leetcode.tasks.NeetCodeSlidingWindow;
import io.leetcode.tasks.TimeMap;
import io.leetcode.tasks.TopKFrequent;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        System.out.println(NeetCodeBinarySearch.search(new int[]{2,4,6,8,10}, 10));
        // [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
//        System.out.println(NeetCodeBinarySearch.searchMatrix2(
//                new int[][]{
//                    {1,3,5,7},
//                    {10,11,16,20},
//                    {23,30,34,50}}, 5));
//        System.out.println(NeetCodeBinarySearch.searchShifted(new int[]{3,1}, 1));

//        System.out.println(NeetCodeSlidingWindow.checkInclusion("ab", "eidbaooo"));

//        System.out.println(Atlassian.numberOfPaths(new int[][]{
//                {1,1,1,1}, {1,1,1,1}, {1,1,1,1}
//        }, 3, 4));

//        System.out.println(
//                TopKFrequent.topKFrequent(
//                        new String[]{
//                                "glarko", "zlfiwwb", "nsfspyox", "pwqvwmlgri", "qggx", "qrkgmliewc",
//                                "zskaqzwo", "zskaqzwo", "ijy", "htpvnmozay", "jqrlad", "ccjel", "qrkgmliewc",
//                                "qkjzgws", "fqizrrnmif", "jqrlad", "nbuorw", "qrkgmliewc", "htpvnmozay", "nftk",
//                                "glarko", "hdemkfr", "axyak", "hdemkfr", "nsfspyox", "nsfspyox", "qrkgmliewc",
//                                "nftk", "nftk", "ccjel", "qrkgmliewc", "ocgjsu", "ijy", "glarko", "nbuorw", "nsfspyox",
//                                "qkjzgws", "qkjzgws", "fqizrrnmif", "pwqvwmlgri", "nftk", "qrkgmliewc", "jqrlad",
//                                "nftk", "zskaqzwo", "glarko", "nsfspyox", "zlfiwwb", "hwlvqgkdbo", "htpvnmozay",
//                                "nsfspyox", "zskaqzwo", "htpvnmozay", "zskaqzwo", "nbuorw", "qkjzgws", "zlfiwwb",
//                                "pwqvwmlgri", "zskaqzwo", "qengse", "glarko", "qkjzgws", "pwqvwmlgri", "fqizrrnmif",
//                                "nbuorw", "nftk", "ijy", "hdemkfr", "nftk", "qkjzgws", "jqrlad", "nftk", "ccjel", "qggx",
//                                "ijy", "qengse", "nftk", "htpvnmozay", "qengse", "eonrg", "qengse", "fqizrrnmif",
//                                "hwlvqgkdbo", "qengse", "qengse", "qggx", "qkjzgws", "qggx", "pwqvwmlgri", "htpvnmozay",
//                                "qrkgmliewc", "qengse", "fqizrrnmif", "qkjzgws", "qengse", "nftk", "htpvnmozay", "qggx",
//                                "zlfiwwb", "bwp", "ocgjsu", "qrkgmliewc", "ccjel", "hdemkfr", "nsfspyox", "hdemkfr", "qggx",
//                                "zlfiwwb", "nsfspyox", "ijy", "qkjzgws", "fqizrrnmif", "qkjzgws", "qrkgmliewc", "glarko",
//                                "hdemkfr", "pwqvwmlgri"}, 14));

//                Arrays.stream(TopKFrequent.topKFrequent(
//                        new int[]{1, 1, 1, 2, 2, 3}, 2)).forEach(System.out::println);
        var timeMap = new TimeMap();

        timeMap.set("love","high",10);
        timeMap.set("love","low",20);

        System.out.printf(timeMap.get("love",5));
        System.out.printf(timeMap.get("love",10));
        System.out.printf(timeMap.get("love",15));
        System.out.printf(timeMap.get("love",20));
        System.out.printf(timeMap.get("love",25));

    }
}