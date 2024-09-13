package Maps;


import java.util.Map;
import java.util.TreeMap;

// 352. Data Stream as Disjoint Intervals
public class SummaryRanges {
    TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int value) {
        if (intervals.isEmpty()) {
            intervals.put(value, value);
            return;
        }
        if (intervals.containsKey(value)) {
            return;
        }

        Map.Entry<Integer, Integer> lower = intervals.lowerEntry(value);
        Map.Entry<Integer, Integer> higher = intervals.higherEntry(value);
        Integer lowerKey = null, lowerValue = null, higherKey = null, higherValue = null;
        if (lower != null) {
            lowerKey = lower.getKey();
            lowerValue = lower.getValue();
            if (lowerValue == value - 1) {
                lowerValue = value;
            }
            intervals.put(lowerKey, lowerValue);
        }
        if (higher != null) {
            higherValue = higher.getValue();
            higherKey = higher.getKey();
            if (higherKey == value + 1) {
                intervals.remove(higherKey);
                higherKey = value;
                intervals.put(higherKey, higherValue);
            }


        }
        if (higherKey != null && lowerValue != null) {
            if(higherKey.equals(lowerValue)) {
                intervals.put(lowerKey, higherValue);
                intervals.remove(higherKey);
            }
        }
        if((lowerValue == null || value > lowerValue + 1) && (higherKey == null || value < higherKey - 1)) {
            intervals.put(value, value);
        }

    }

    public int[][] getIntervals() {
        int[][] res = new int[intervals.size()][2];
        int i = 0;
        for (Integer num: intervals.keySet()) {
            res[i][0] = num;
            res[i][1] = intervals.get(num);
            i++;
        }
        return res;
    }
}
