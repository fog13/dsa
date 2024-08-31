package top150;


// 169. Majority Element
class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = -1;
        for (int el: nums) {
            if(count == 0) {
                res = el;
                count++;
                continue;
            }
            if (res == el) {
                count++;
            }
            else {
                count --;
            }
        }
        return res;
    }
}