class Solution {
    public int findMin(int[] nums) {
        int ans= Integer.MAX_VALUE;
        int i=0;
        int j = nums.length-1;
        
         while(i<=j){
            int mid= i+(j-i)/2;
            if (nums[i]<=nums[mid]){
                ans = Math.min(nums[i],ans);
                i=mid+1;
            }
            else {
                ans = Math.min(nums[mid],ans);
                j = mid-1;
            }
         }
        return ans;
    }
}