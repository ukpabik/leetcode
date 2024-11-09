class Solution {

    // O(n log n) solution
    public int hIndex(int[] citations) {
        int books = citations.length;
        int max = 0;
        
        // First, sort the array to calculate the h index greedily
        Arrays.sort(citations);
        
        for (int i = 0; i < books; i++){
            // Calculate current h index and check if it is valid
            int h = books - i;
            // H index is valid if at least h books and at least h citations
            // For example [0, 1, 3, 5, 6] has 3 books with at least 3 citations
            if (citations[i] >= h){
                max = h;
                break;
            }
        }

        return max;
    }
}
