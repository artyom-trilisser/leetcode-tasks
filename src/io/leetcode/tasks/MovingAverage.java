package io.leetcode.tasks;

import java.util.LinkedList;
import java.util.List;

public class MovingAverage {
    private final int windowSize;
    private final List<Integer> window;

    private int sum = 0;

    public MovingAverage(int windowSize) {
        this.window = new LinkedList<>();
        this.windowSize = windowSize;
    }

    public float next(int nextEl) {
        if (window.size() < windowSize) {
            window.add(nextEl);
        } else {
            Integer firstEl = window.remove(0);
            window.add(nextEl);

            sum -= firstEl;
        }

        sum += nextEl;

        return ((float) sum / window.size());
    }
}
