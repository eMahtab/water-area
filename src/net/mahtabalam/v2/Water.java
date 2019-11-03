package net.mahtabalam.v2;

class Water {

	public static void main(String[] args) {
		int arr[] = { 0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3 };
		System.out.println("Total water that can be trapped is " + waterArea(arr));
	}

	public static int waterArea(int arr[]) {
		// left[i] contains height of tallest bar to the left of i'th bar
		if (arr.length == 0)
			return 0;
		int left[] = new int[arr.length];

		// Fill left array
		left[0] = 0;
		int leftMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			left[i] = leftMax;
			leftMax = Math.max(leftMax, arr[i]);
		}

		int minHeight = 0;
		int water = 0;
		int totalWater = 0;

		int rightMax = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
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
