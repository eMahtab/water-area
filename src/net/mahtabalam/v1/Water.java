package net.mahtabalam.v1;

class Water {

	public static void main(String[] args) {
		int arr[] = { 3, 0, 0, 2, 0, 4 };
		System.out.println("Total water that can be trapped is " + waterArea(arr));
	}

	public static int waterArea(int arr[]) {

		if (arr.length == 0)
			return 0;

		// left[i] stores the height of tallest bar to the left of i'th bar
		int left[] = new int[arr.length];

		// right[i] stores the height of tallest bar to the right of i'th bar
		int right[] = new int[arr.length];

		// Fill left array
		left[0] = 0;
		int leftMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			left[i] = leftMax;
			leftMax = Math.max(leftMax, arr[i]);
		}

		// Fill right array
		right[arr.length - 1] = 0;
		int rightMax = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			right[i] = rightMax;
			rightMax = Math.max(rightMax, arr[i]);

		}

		int minHeight = 0;
		int water = 0;
		int totalWater = 0;

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
