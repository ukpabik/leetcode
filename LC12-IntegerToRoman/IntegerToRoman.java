class Solution {
    // O(N) Solution
    public String intToRoman(int num) {

        // this is the list of values needed to solve this problem
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // Our index to keep track of nums place we are currently at
        // i.e. if our num = 3000, and i = 0, we will stay at i = 0 -> n[0] = 1000
        // Subtract 1000 from 3000 until we reach a point where num < 1000
        // Then we increment i to go to the next value
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (num > 0){
            // If our number is greater than the current nums place we are on, append it and subtract it from the number
            if (num >= n[i]){
                sb.append(s[i]);
                num -= n[i];
            }
            else{
                // Move along to find the next nums spot we are going to use
                i++;
            }
        }

        return sb.toString();

    }
}
