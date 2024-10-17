class Solution {
  public int reverse(int x) {
    // Keep a boolean to determine whether the number is positive or negative.
    boolean isNegative = x < 0;
    

    // This is the variable we will use to store our resulting number.
    int reversedNumber = 0;
    

    // Get the value of the int as a String to be able to be reversed.
    String str = String.valueOf(Math.abs(x));
    StringBuilder sb = new StringBuilder(str).reverse();

    // Try to parse the reversed String, if we are unable to parse it,
    // that means it exceeds the bounds of a signed 32-bit integer.
    try {
      reversedNumber = Integer.parseInt(sb.toString());
    } 
    catch (NumberFormatException e) {
      return 0;
    }

    // Return negative or positive resulting number.
    return isNegative ? -reversedNumber : reversedNumber;
  }
}
