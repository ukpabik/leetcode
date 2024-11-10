import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Solution {

    // O(N) solution!!!!
    public List<Integer> findSubstring(String s, String[] words) {

        // FINAL SOLUTION

        List<Integer> res = new ArrayList<>();

        // Save the frequencies of each word in the words array
        Map<String, Integer> count = new HashMap<>();
        for (String word: words){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int windowSize = wordLength * totalWords;

        // Iterating over the starting position of each word
        for (int i = 0; i < wordLength; i++){
            int left = i;
            int right = i;
            int freq = 0;
            // Store our window in a hashmap to keep track of our frequencies in the current window
            Map<String, Integer> window = new HashMap<>();
            while (right + wordLength <= s.length()){
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // If the word is valid, we add it to our window
                if (count.containsKey(word)){
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    freq++;

                    // Make sure that the count for the words in window is equal to our original count of words
                    while (window.get(word) > count.get(word)){
                        String leftWord = s.substring(left, left + wordLength);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLength;
                        freq--;
                    }

                    if (freq == totalWords){
                        res.add(left);
                    }
                }
                else{
                    // Reset our window if the word isn't in the original array
                    window.clear();
                    freq = 0;
                    left = right;
                }

                
            }
            

        }


        return res;


        // FIRST ATTEMPT, SHOULD'VE USED A MAP INSTEAD
        // // Initialize our set to hold all values in our window
        // Set<String> window = new HashSet<>();
        // List<Integer> res = new ArrayList<>();

        // // Our window needs to be a static size:
        // // The length of one word * the number of words we have / length of words array
        // int wordLength = words[0].length();
        // int windowSize = words.length * wordLength;
        // int left = 0;
        
        // for (int i = 0; i < windowSize; i += wordLength){
        //     window.add(s.substring(i, i + wordLength));
        // }

        // System.out.println(window);


        // // Each iteration, we are going forward one whole word
        // for (int i = windowSize; i <= s.length(); i += wordLength){
        
        //     // if our set contains all of the words, we can add the start to our result
        //     if (window.size() == words.length){
        //         System.out.println(window);
        //         res.add(left);
        //     }

        //     // Add our word and subtract the left word
        //     String leftWord = s.substring(left, left + wordLength);
        //     System.out.println("REMOVED: " + leftWord);
        //     window.remove(leftWord);

        //     // Move the left pointer forward after removing the left word
        //     left += wordLength;
            

        //     // If we can add a new word (if we arent exceeding bounds)
        //     if (i + wordLength <= s.length()) {
        //         String newWord = s.substring(i, i + wordLength);
        //         System.out.println("ADDED: " + newWord);
        //         window.add(newWord);
        //     }
        // }

        // return res;
    }
}
