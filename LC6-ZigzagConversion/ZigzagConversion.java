class Solution {


  // O(n x m) solution where n is the number of rows and m is the length of the string
  public String convert(String s, int numRows) {
    if (numRows == 1){
      return s;
    }
    char[][] zig = new char[numRows][s.length()];
    StringBuilder sb = new StringBuilder();

    Set<Character> set = new HashSet<>();

    char[] str = s.toCharArray();
    for (Character c : str){
      set.add(c);
    }

    int row = 0;
    int col = 0;
    int currChar = 0;

    while (col < zig[0].length && currChar < str.length){

      // This is the down part, it creates this:
      // P
      // A
      // Y

      while (row < numRows && currChar < str.length){
        zig[row][col] = str[currChar];
        currChar++;

        // Move our row down by 1
        row++;
      }

      // Move col over, and go up one so if we have 3 rows, we will be in the middle row
      col++;
      row -= 2;


      // Diagonal part here
      while (row >= 0 && currChar < str.length){
        // Set the char at [row][col] to the current char
        zig[row][col] = str[currChar];

        // Move our row back up, and our col over one to the right
        currChar++;
        row--;
        col++;
      }


      // Reset our row and adjust the column position
      row += 2;
      col--;
    }

    // For printing out the matrix
    // for (int i = 0; i < zig.length; i++){
    //     for (int j = 0; j < zig[0].length; j++){
    //         System.out.print(zig[i][j]);
    //     }
    //     System.out.println();
    // }

    for (int i = 0; i < zig.length; i++){
      for (int j = 0; j < zig[0].length; j++){
        if (set.contains(zig[i][j])){
          sb.append(zig[i][j]);
        }
      }

    }

    return sb.toString();
  }
}
