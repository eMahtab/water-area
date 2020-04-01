# Trapping Rain Water
## https://leetcode.com/problems/trapping-rain-water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

![Trapped Rain Water](rainwatertrap.png?raw=true "Title")

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) is being trapped. 


# Implementation 1 : Time : O(n), Space : O(n)
```java
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        leftMax[0] = 0;
        int left = height[0];
        for(int i = 1; i < height.length; i++) {
            leftMax[i] = left;
            left = Math.max(left, height[i]);    
        }
        
        rightMax[height.length -1] = 0;
        int right = height[height.length - 1];
        for(int i = height.length-2; i >= 0; i--) {
            rightMax[i] = right;
            right = Math.max(right, height[i]);
        }
        
        int totalWater = 0;
        for(int i = 0; i < height.length; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if(height[i] < minHeight) {
                totalWater += (minHeight - height[i]);
            }
        }
        return totalWater;
    }
}
```

# Implementation 2 : Optimized  Time : O(n), Space : O(n)
```java
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        
        int[] rightMax = new int[height.length];
         
        rightMax[height.length -1] = 0;
        int right = height[height.length - 1];
        for(int i = height.length-2; i >= 0; i--) {
            rightMax[i] = right;
            right = Math.max(right, height[i]);
        }
        
        int totalWater = 0;
        int leftMax = 0; 
        for(int i = 0; i < height.length; i++) {
            int minHeight = Math.min(leftMax, rightMax[i]);
            if(height[i] < minHeight) {
                totalWater += (minHeight - height[i]);
            }
            leftMax = Math.max(leftMax, height[i]);
        }
        return totalWater;
    }
}
```
