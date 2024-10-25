class Solution {
  

  // O(N log N) Time complexity
  // O(N) space complexity
  public int carFleet(int target, int[] position, int[] speed) {

    // Base case
    if (position.length == 1){
      return 1;
    }

    // Our stack with pairs of (position, speed)
    Stack<Pair<Integer, Integer>> stack = new Stack<>();

    // Create our list of cars used
    List<Pair<Integer, Integer>> res = new ArrayList<>();
    for (int i = 0; i < position.length; i++){
      res.add(new Pair<>(position[i], speed[i]));
    }

    // Make sure to sort the cars by position
    res.sort((a, b) -> a.getKey() - b.getKey());

    // Put the first car on the stack to symbolize a single fleet
    stack.push(res.get(res.size() - 1));

    // Going through each iteration, we are checking the previous car and the current car's times
    for (int i = res.size() - 2; i >= 0; i--){
      Pair<Integer, Integer> prevCar = stack.peek();
      Pair<Integer, Integer> currCar = res.get(i);

      // Compare the two times to see which one is faster and reaches the target quicker
      double prevTime = ((double)(target - prevCar.getKey()) / prevCar.getValue());
      double currTime = ((double)(target - currCar.getKey()) / currCar.getValue());

      // If the current car reaches the target slower than the previous, we push it onto the stack to symbolize a new fleet
      if (currTime > prevTime){
        stack.push(currCar);
      }
    }

    // Return the amount of cars on the stack, symbolizing how many fleets there are
    return stack.size();

  }

}
