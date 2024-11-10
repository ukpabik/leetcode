class Solution {
    // O(N) Greedy solution
    public List<String> fullJustify(String[] words, int maxWidth) {

        // fully justify each line

        // words[]
        // maxWidth -> width of each line -> each line must have maxWidth amount of characters


        // pack words in a greedily approach, pad extra spaces when necessary

        /**
        
            Take each word:

            Example: ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16

            This = length 4 + space between = length 5
            is = length 2 + space between = length 3
            an = length 2 + space between = length 3

            11 total so far
            check next word
            example = length 7 + space between = length 8 -> 11 + 8 > 16 so this doesnt work

            so first line is:
                "This is an" and distribute the rest of the spaces

            example = length 7 + 1 = 8
            of = length 2 + 1 = 3
            text = length 4 + 1 = 5

            16 total -> can fit



            next line:

                "Example of text" and distribute rest
            

            last line: 

                we only have one word left so its 
                "justification" -> length 13 + 1 = 14 add rest of the spaces


            remember: in the line, if there are n words, there are n - 1 slots to put spaces, so divide the spaces up that way
         */



        // WORKING SOLUTION

        List<String> res = new ArrayList<>();
        int idx = 0;

        while (idx < words.length) {
            // Greedily pack all possible words onto each line
            int length = words[idx].length();
            int last = idx + 1;
            while (last < words.length && length + words[last].length() + (last - idx) <= maxWidth) {
                length += words[last].length();
                last++;
            }

            // Build our line and distribute spaces
            StringBuilder sb = new StringBuilder();
            int spaces = maxWidth - length;
            int count = last - idx;

            // Check edgecase for if it is the last line or only one word in the line
            if (last == words.length || count == 1) {
                for (int i = idx; i < last; i++) {
                    // Left justify it
                    sb.append(words[i]);
                    if (i != last - 1) {
                        sb.append(" ");
                    }
                }
                

                // Pad remaining spaces to the end of the word
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } 
            else {
                // Distribute spaces evenly across all words
                int spacesPerSlot = spaces / (count - 1);
                int extraSpaces = spaces % (count - 1);
                for (int i = idx; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) {
                        for (int j = 0; j < spacesPerSlot; j++) {
                            sb.append(" ");
                        }
                        if (extraSpaces > 0) {
                            sb.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            res.add(sb.toString());
            idx = last; 
        }

        return res;



        



        // FIRST ATTEMPT
        // int idx = 0;
        // List<String> res = new ArrayList<>();
        // List<String> list = new ArrayList<>(List.of(words));

        // while (list.size() > 0){
        //     int length = 0;
        //     int spaces = -1;
        //     List<String> tempList = new ArrayList<>();
        //     StringBuilder sb = new StringBuilder();

        //     // Gets all words that can be on this line.
        //     for (int i = idx; i < words.length; i++){
        //         // If current length + next word <= maxWidth - min # of spaces needed, we can use this word
        //         if (length + (words[i].length()) <= maxWidth - spaces){
        //             tempList.add(words[i]);
        //             list.remove(words[i]);
        //             length += words[i].length();
        //             spaces++;
        //         }
        //         else{
        //             break;
        //         }
        //     }

        //     // Once we have all of our words, we can distribute spaces and add to result

        //     int size = tempList.size();
        //     System.out.println(tempList);
        //     System.out.println(size);
        //     System.out.println(length);

        //     int spacesPer = (maxWidth - length) / Math.max(1, size - 1);

        //     // Add each word to our temp stringbuilder, and make sure to add the correct amount of spaces
        //     for (int i = 0; i < size; i++){
        //         sb.append(tempList.get(i));
        //         if (i != size - 1){
        //             int count = spacesPer;
        //             while (count > 0){
        //                 sb.append(" ");
        //                 count--;
        //             }
        //         }
        //     }
        //     System.out.println(spacesPer);
        //     System.out.println(sb.toString());
        //     res.add(sb.toString());

        //     idx += size;
        // }
        

        // return res;
    }
}
