class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxVal = 0;
        while(left < right){
            maxVal = Math.max(maxVal, (right - left) * Math.min(height[left], height[right]));
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxVal;
    }
}