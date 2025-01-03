package LC0731_MyCalendarII;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/my-calendar-ii/">My Calendar II</a>
 * 设计；线段树；数组；二分查找；有序集合；前缀和
 */
public class MyCalendarII {
    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20)); // returns true
        System.out.println(myCalendarTwo.book(50, 60)); // returns true
        System.out.println(myCalendarTwo.book(10, 40)); // returns true
        System.out.println(myCalendarTwo.book(5, 15)); // returns false
        System.out.println(myCalendarTwo.book(5, 10)); // returns true
    }
}

class MyCalendarTwo {
    List<int[]> booked;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] overlap : overlaps) {
            if (overlap[0] < endTime && overlap[1] > startTime) {
                return false;
            }
        }

        for (int[] booking : booked) {
            if (booking[0] < endTime && booking[1] > startTime) {
                overlaps.add(new int[]{Math.max(booking[0], startTime), Math.min(booking[1], endTime)});
            }
        }
        booked.add(new int[]{startTime, endTime});
        return true;
    }
}