class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int mid = left + ((right - left) / 2);

        int rightValue = nums[right];
        int leftValue = nums[left];

        if (rightValue == target) {
            return right;
        }

        if (leftValue == target) {
            return left;
        }

        while (left < right) {
            int midValue = nums[mid];
            rightValue = nums[right];
            leftValue = nums[left];

            if (midValue == target) {
                return mid;
            }

            if (midValue > rightValue) {
                if (midValue < target) {
                    if (rightValue < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }

                } else {
                    // if midValue > target
                    if (leftValue > target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            } else {
                // if midValue <= rightValue
                if (midValue < target) {
                    if (rightValue < target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    //if midValue > target 
                    if(rightValue > target){
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            mid = left + ((right - left) / 2);
        }

        if (rightValue == target) {
            return right;
        }

        if (leftValue == target) {
            return left;
        }

        return -1;
    }
}
