package io.leetcode.tasks;

import java.util.Arrays;

public class NeetCodeBinarySearch {
    public static int searchRecursive(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        if (end <= start) {
            if (nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        }

        int middle = (end - start) / 2;
        if (nums[start + middle] > target) {
            //check left part
            return binarySearch(nums, target, start, start + middle);
        } else if (nums[start + middle] < target) {
            // check right part
            return binarySearch(nums, target, start + middle + 1, end);
        } else {
            return start + middle;
        }
    }

    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int middle = (j + i) / 2;
            if (nums[middle] > target) {
                j = middle - 1;
            } else if (nums[middle] < target) {
                i = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int firstRow = 0;
        int lastRow = matrix.length - 1;
        int chosenRow;

        while (firstRow <= lastRow) {
            chosenRow = (firstRow + lastRow) / 2;
            if (matrix[chosenRow][0] == target || matrix[chosenRow][matrix[chosenRow].length - 1] == target) {
                return true;
            } else if (target < matrix[chosenRow][0]) {
                lastRow = chosenRow - 1;
            } else if (target > matrix[chosenRow][matrix[chosenRow].length - 1]) {
                firstRow = chosenRow + 1;
            } else {
                int first = 0;
                int last = matrix[chosenRow].length - 1;

                while (first <= last) {
                    int middle = (first + last) / 2;

                    if (matrix[chosenRow][middle] < target) {
                        first = middle + 1;
                    } else if (matrix[chosenRow][middle] > target) {
                        last = middle - 1;
                    } else {
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }

    /**
     * 74. Search a 2D Matrix
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = rows * columns;

        while (low < high) {
            int mid = (low + high) / 2;

            if (matrix[mid / columns][mid % columns] == target) {
                return true;
            } else if (matrix[mid / columns][mid % columns] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return false;
    }

    /**
     * 875. Koko Eating Bananas
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     */
    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }

    /**
     * 153. Find Minimum in Rotated Sorted Array
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            if (nums[left] <= nums[right]) return nums[left];

            mid = (left + right) / 2;

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return 0;
    }

    /**
     * 33. Search in Rotated Sorted Array
     */
    public static int searchShifted(int[] nums, int target) {
        int minElement = findIndexOfMin(nums);
        int leftResult = searchInSubArray(nums, target, 0, minElement - 1);
        int rightResult = searchInSubArray(nums, target, minElement, nums.length - 1);

        if (leftResult > -1) return leftResult;

        return Math.max(rightResult, -1);

    }

    private static int searchInSubArray(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (middle < 0) break;

            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    private static int findIndexOfMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] <= nums[r]) return l;

            int mid = (l + r) / 2;

            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return -1;
    }

}

