package net.mahtabalam;

import java.util.Arrays;

class Water {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
//		int arr[] = {3, 0, 0, 2, 0, 4};
		System.out.println("Total water that can be trapped is " + waterArea(arr));
	}

	static int waterArea(int arr[]) {
		// left[i] contains height of tallest bar to the left of i'th bar
		int left[] = new int[arr.length];

		// right[i] contains height of tallest bar to the right of ith bar
		int right[] = new int[arr.length];
		int totalWater = 0;

		// Fill left array
		left[0] = 0;
		int leftMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			leftMax = Math.max(leftMax, arr[i - 1]);
			left[i] = leftMax;
		}

		System.out.println("Left " + Arrays.toString(left));

		// Fill right array
		right[arr.length - 1] = 0;
		int rightMax = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			rightMax = Math.max(rightMax, arr[i]);
			right[i] = rightMax;
		}
		System.out.println("Right " + Arrays.toString(right));

		int minHeight = Integer.MIN_VALUE;
		int water = 0;
		for (int i = 0; i < arr.length; i++) {
			minHeight = Math.min(left[i], right[i]);
			if (minHeight > arr[i]) {
				water = minHeight - arr[i];
			} else {
				water = 0;
			}
			totalWater += water;
		}

		return totalWater;
	}

}
