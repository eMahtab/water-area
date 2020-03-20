# Trapping Rain Water
## https://leetcode.com/problems/trapping-rain-water


# Implementation 1 :
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

# Implementation 2 : Optimized
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
