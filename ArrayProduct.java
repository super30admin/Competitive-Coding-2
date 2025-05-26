class ArrayProduct {
    /**
     * Brute force is to nested iterations and in inner iteration skip current index of outer look.
     * Instead we can have running product in both directions and result at current index can be achieved by
     * multiplying previous index forwardProduct with next index backwardProduct.
     * Time O(n) space O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int forwardProduct = 1;
        int[] backwardProduct = new int[len + 1];
        backwardProduct[len] = 1;

        //prepare backwardProduct separately
        for (int i = len - 1; i >= 0; i--) {
            backwardProduct[i] = backwardProduct[i + 1] * nums[i];

            //skip remaining calculations as it will be always be 0 which is int[] default value
            if (backwardProduct[i] == 0){
                break;
            }
        }

        //calculate forwardProduct and result -> overwrite it in input array itself
        for (int i = 0; i < len - 1; i++) {
            int temp = nums[i];
            nums[i] = forwardProduct * backwardProduct[i + 1];
            forwardProduct *= temp;
        }
        nums[len - 1] = forwardProduct;

        return nums;
    }
}