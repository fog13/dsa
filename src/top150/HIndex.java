package top150;

import java.util.Arrays;




// 275. H-Index II
// Not recommended :)
class HIndex2 {
    public int hIndex(int[] citations) {
        if (citations.length == 1) {
            return citations[0] > 0 ? 1 : 0;
        }
        Arrays.sort(citations);
        int res = 0;
        int low = 0, high = citations.length - 1;
        while (high > low) {
            int mid = (low + high + 1) / 2;
            if (citations.length - mid >= citations[mid]) {
                res = citations[mid];
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        if (citations[high] == 0 && high == 0) {
            return Math.min(citations.length, citations[0]);
        }
        res = Math.max(res, citations.length - high-1);
        if(citations[high] > res) {
            res++;
        }
        return res;
    }
}

// 274. H-Index
class HIndex {
    public int hIndex(int[] citations) {
        int[] mark = new int[citations.length+1];
        for (int i=0; i < citations.length; i++) {
            mark[Math.min(citations[i], citations.length)]++;
        }
        int res = 0, count = citations.length;
        for(int i=0; i<mark.length; i++) {
            if(count < i) {
                break;
            }
            res = i;
            count-=mark[i];
        }
        return res;
    }
}
