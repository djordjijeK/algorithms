package _2024.september;

import java.util.LinkedList;
import java.util.List;


// https://leetcode.com/problems/my-calendar-i/description/
// Time Complexity: O(n log(n))
// Space Complexity: O(n)
public class MyCalendar {
    private final List<int[]> slots;


    public MyCalendar() {
        this.slots = new LinkedList<>();
    }


    public boolean book(int start, int end) {
        if (this.slots.isEmpty()) {
            this.slots.add(new int[]{start, end - 1});
            return true;
        }

        int insertIndex = insertIndex(start);
        int[] leftInterval = insertIndex == 0 ? null : this.slots.get(insertIndex - 1);
        int[] rightInterval = insertIndex == this.slots.size() ? null : this.slots.get(insertIndex);

        if (leftInterval != null && leftInterval[1] >= start) {
            return false;
        }

        if (rightInterval != null && rightInterval[0] <= end - 1) {
            return false;
        }

        this.slots.add(insertIndex, new int[]{start, end - 1});
        return true;
    }


    private int insertIndex(int value) {
        int left = 0;
        int right = this.slots.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (value > this.slots.get(mid)[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
