class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile: piles){
            right = Math.max(pile, right);
        }
        while(left < right){
            int mid = left + (right - left)/2;
            if(canHandle(piles, h, mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;

    }

    private boolean canHandle(int[] piles, int h, int k){
        int sum = 0;
        for(int pile: piles){
            sum += (pile + k - 1) / k;
        }
        return sum <= h;
    }


}
