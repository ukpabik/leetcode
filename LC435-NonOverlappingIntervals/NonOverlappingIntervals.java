class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    int rows = intervals.length;
    if (rows == 1){
      return 0;
    }


    // Sort by ending times to better find overlap
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
    int overlap = intervals[0][1];
    int sum = 0;

    for (int i = 1; i < rows; i++){
      // If the current start time is less than the overlapping ending time, this means that they are overlapping
      if (intervals[i][0] < overlap){
        sum++;
      }
      else{
        // If it doesn't overlap, reset our end time to the current interval's end time
        overlap = intervals[i][1];
      }
    }
    return sum;
  }
}
