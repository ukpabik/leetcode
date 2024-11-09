class Solution {
    // Prefix sum solution
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Base case of empty prefix sum
        map.put(0, 1);
        int sum = 0;
        int res = 0;

        for (int n : nums){
            // Add the current value to our sum
            sum += n;
            int diff = sum - k;

            res += map.getOrDefault(diff, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;



        // BRUTE FORCE
        // int res = 0;
        // for (int i = 0; i < nums.length; i++){
        //     int temp = 0;
        //     for (int j = i; j < nums.length; j++){
        //         temp += nums[j];
        //         if (temp == k){
        //             res++;
        //         }
        //     }
        // }

        // return res;
        
    }
}
