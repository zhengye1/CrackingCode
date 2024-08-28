package com.vincent.graph.topologicalsort;

import java.util.*;

/**
 * LeetCode 2115 - Medium
 */
public class PossibleRecipes {
    Set<String> yes = new HashSet<>();
    Set<String> no = new HashSet<>();
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Using the map to record the ingredients
        Map<String, List<String>> recipesIngredientsMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++){
            recipesIngredientsMap.put(recipes[i], ingredients.get(i));
        }
        for (String supply : supplies) {
            yes.add(supply);
            recipesIngredientsMap.put(supply, new ArrayList<>());
        }
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (String recipe : recipes) {
            if (canMake(recipe, recipesIngredientsMap, visited)) result.add(recipe);
        }
        return result;

    }

    private boolean canMake(String recipe, Map<String, List<String>> recipesIngredientsMap, Set<String> visited){
        if (yes.contains(recipe)) return true;
        if (no.contains(recipe)) return false;
        if (visited.contains(recipe)) {
            no.add(recipe);
            return false;
        }
        if (!recipesIngredientsMap.containsKey(recipe)) {
            no.add(recipe);
            return false;
        }
        visited.add(recipe);
        boolean result = true;
        // check all ingredient
        for (String ingredient : recipesIngredientsMap.get(recipe)) {
            if (!canMake(ingredient, recipesIngredientsMap, visited)) {
                result = false;
                no.add(recipe);
                break;
            }
        }
        if (result) yes.add(recipe);
        visited.remove(recipe);
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> ingredients = new ArrayList<>();
        List<String> breadIngredients = new ArrayList<>();
        breadIngredients.add("yeast");
        breadIngredients.add("flour");
        ingredients.add(breadIngredients);
        new PossibleRecipes().findAllRecipes(new String[]{"bread"}, ingredients, new String[]{"yeast","flour","corn"});
    }
}
