package net.mahtabalam.v2;

import java.util.Arrays;

class Water {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// int arr[] = {3, 0, 0, 2, 0, 4};
		System.out.println("Total water that can be trapped is " + waterArea(arr));
	}

	static int waterArea(int arr[]) {
		// left[i] contains height of tallest bar to the left of i'th bar
		if (arr.length == 0)
			return 0;
		int left[] = new int[arr.length];

		int totalWater = 0;

		// Fill left array
		left[0] = 0;
		int leftMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			left[i] = leftMax;
			leftMax = Math.max(leftMax, arr[i]);
		}

		System.out.println("Left " + Arrays.toString(left));

		int minHeight = 0;
		int water = 0;
		
		int rightMax = 0;
		for (int i = arr.length-1; i >= 0; i--) {
			minHeight = Math.min(left[i], rightMax);
			if (minHeight > arr[i]) {
				water = minHeight - arr[i];
			} else {
				water = 0;
			}
			totalWater += water;
			
			rightMax = Math.max(rightMax, arr[i]);
		}

		return totalWater;
	}

}
