class Solution {
    public int maxProduct(int[] nums) {
        int max=0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++){
            for(int j=0; j<nums.length-1;j++){
                max = (nums[i]-1)*(nums[j]-1);
            }
        }

     return max;   
    }
}