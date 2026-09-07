class Solution {
    boolean find(int[] piles, int h,int mid){
            int hours =0;
            int n = piles.length;
            for(int i=0;i<n;i++){
                hours += (piles[i] + mid-1)/mid;
                if(hours>h){
                    return false;
                }
            }
            return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int s=1, e=-1, ans=-1;

        for(int i=0; i<n;i++){
            e = Math.max(piles[i],e);
        }

        while (s<=e) {
            int mid = s+ (e-s)/2;
            boolean flag = find(piles,h,mid);
            if(flag == true){
                ans = mid;
                e = mid-1;
            }else{
                s =mid+1;
            }
        }
        return ans;
    }
}