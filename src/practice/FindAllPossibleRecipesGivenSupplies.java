package practice;

import java.util.*;

public class FindAllPossibleRecipesGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size());

            for (String ing : ingredients.get(i)) {
                adjList.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        Queue<String> queue = new LinkedList<>(available);

        while (!queue.isEmpty()) {
            String item = queue.poll();

            if (inDegree.containsKey(item)) {
                ans.add(item);
            }
            if (adjList.containsKey(item)) {
                for (String dependent : adjList.get(item)) {
                    inDegree.put(dependent, inDegree.get(dependent) - 1);

                    if (inDegree.get(dependent) == 0) {
                        queue.offer(dependent);
                    }
                }
            }
        }

        return ans;
    }
}
