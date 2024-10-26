class Solution {
  public String frequencySort(String s) {
    HashMap<Character, Integer> charToFreq = new HashMap<>();
    HashMap<Integer, List<Character>> freqToChar = new HashMap<>();
    StringBuilder sb = new StringBuilder();


    // We have all of the frequencies in this map
    for (Character c : s.toCharArray()){
      charToFreq.put(c, charToFreq.getOrDefault(c, 0) + 1);
    }

    // Now we can map the frequencies to the characters that have that frequency
    for (Map.Entry<Character, Integer> entry : charToFreq.entrySet()){
      // If the freq has not been put into the freqToChar map, create a new list and add it
      freqToChar.putIfAbsent(entry.getValue(), new ArrayList<Character>());

      // Add the current char to the list at that frequency
      freqToChar.get(entry.getValue()).add(entry.getKey());

    }

    // System.out.println(charToFreq);
    // System.out.println(freqToChar);

    // Get our list of frequencies to go through
    List<Integer> frequencies = new ArrayList<>(freqToChar.keySet());
    // Sort our list in decreasing order
    Collections.sort(frequencies, (a, b) -> b - a);

    // Loop through the frequency list starting with the largest frequency
    for (int frequency : frequencies){

      // Get our list of characters from the freqToChar map
      List<Character> characters = freqToChar.get(frequency);

      // For every character, we want to print out the frequency amount of that character
      for (Character c : characters){
        int count = frequency;

        while (count > 0){
          sb.append(c);
          count--;
        }
      }
    }

    return sb.toString();
  }
}
