package org.example.listNArray;

import java.util.*;

/**
 * 스냅챗에서 출제된 문제입니다.
 *
 * 중첩될 수 있는 인터벌들을 갖는 리스트가 있습니다.
 * 중첩되는 인터벌들을 하나로 합친 새로운 리스트를 반환하세요.
 *
 * 입력 리스트는 정렬되어 있지 않습니다.
 *
 * 예를 들어, [(1, 3), (5, 8), (4, 10), (20, 25)] 가 주어지면,
 * [(1, 3), (4, 10), (20, 25)] 를 반환해야 합니다.
 * */

public class liveTest {
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(5, 8),
                new Interval(4, 10),
                new Interval(20, 25)
        );
        List<Interval> merged = mergeIntervals(intervals);

        for (Interval i : merged) {
            System.out.println(i);
        }
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals){
        if(intervals == null || intervals.size()==0) return Collections.emptyList();

        intervals.sort(Comparator.comparingInt(a->a.start));

        List<Interval> result = new ArrayList<>();
        Interval prev = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(prev.end >= curr.start){
                prev.end = Math.max(prev.end,curr.end);
            }else {
                result.add(prev);
                prev = curr;
            }
        }

        result.add(prev);

        return result;

    }

    static class Interval {
        int start, end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

}
