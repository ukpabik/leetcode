class Solution {
  public String minWindow(String s, String t) {

    HashMap<Character, Integer> freqT = new HashMap<>();


    // Populate our frequency map for t
    for (int i = 0; i < t.length(); i++){
      freqT.put(t.charAt(i), freqT.getOrDefault(t.charAt(i), 0) + 1);
    }


    int matchedCharacters = 0;
    int start = 0;
    int sub = 0;

    // Length of our current minimum window
    int minLength = s.length() + 1;

    for (int i = 0; i < s.length(); i++){
      char right = s.charAt(i);
      // Check if our map contains the current char
      if (freqT.containsKey(right)){
        // Update the frequency
        freqT.put(right, freqT.get(right) - 1);
        // Our matched counter for the characters in t
        if (freqT.get(right) == 0) matchedCharacters++;
      }

      // Once we have matched all of the characters, we should try to shrink our window
      while (matchedCharacters == freqT.size()){
        if (minLength > i - start + 1){
          minLength = i - start + 1;
          sub = start;
        }
        char removed = s.charAt(start);
        if (freqT.containsKey(removed)){
          // If we removed every instance of that char, we have to rematch it, by increasing our window again
          if (freqT.get(removed) == 0) matchedCharacters--;
          freqT.put(removed, freqT.get(removed) + 1);
        }

        start++;
      }
    }

    return minLength > s.length() ? "" : s.substring(sub, sub + minLength);
  }
}
