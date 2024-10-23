

// Time Complexity: O(number of queries * edges)
// Space Complexity: O(V + E)
class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    HashMap<String, List<Pair<String, Double>>> map = new HashMap<>();


    // Build our adjacency list with pairs of either (denominator, value) mapped to a numerator,
    // or (numerator, 1 / value) mapped to a denominator
    for (int i = 0; i < equations.size(); i++){
      String numerator = equations.get(i).get(0);
      String denominator = equations.get(i).get(1);
      double value = values[i];

      map.putIfAbsent(numerator, new ArrayList<>());
      map.putIfAbsent(denominator, new ArrayList<>());

      map.get(numerator).add(new Pair<>(denominator, value));
      map.get(denominator).add(new Pair<>(numerator, 1 / value));
    }


    double[] res = new double[queries.size()];


    // Run bfs on every single query to find the target value, if the source is not in the adjacency list,
    // we can set the value = -1.0
    for (int i = 0; i < queries.size(); i++){
      String source = queries.get(i).get(0);
      String target = queries.get(i).get(1);

      if (!map.containsKey(source)) res[i] = -1.0;
      else if (source.equals(target)) res[i] = 1.0;
      else res[i] = bfs(source, target, map);
    }


    return res;
  }

  // BFS helper function to run bfs on different sources
  public double bfs(String src, String target, HashMap<String, List<Pair<String, Double>>> map){
    if (!map.containsKey(src)) return -1;
    Queue<Pair<String, Double>> que = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();

    // Add our initial source paired with the value 1.0 as a starter ratio
    que.add(new Pair<>(src, 1.0));
    visited.add(src);

    while (!que.isEmpty()){
      // Get our current pair of variable and equation value
      Pair<String, Double> pair = que.poll();
      String variable = pair.getKey();
      double value = pair.getValue();

      // If we are at the target, we can return our value
      if (variable.equals(target)) return value;

      visited.add(variable);

      // Check the adjacent neighbors and add them to the queue if they are not visited
      for (Pair<String, Double> list: map.get(variable)){
        if (!visited.contains(list.getKey())){
          visited.add(variable);
          // Multiply the ratios together to find the accumulated division value
          que.add(new Pair<>(list.getKey(), value * list.getValue()));
        }
      }

    }

    return -1.0;
  }
} 
