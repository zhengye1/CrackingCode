package com.vincent.graph.topologicalsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PossibleRecipesTest {
    static String[][] inputRecipes = {
            {"bread", "sandwich", "burger"},
            {"bread", "sandwich"},
            {"bread"},
            {"pasta", "egg", "chicken"},
            {"custard", "trifle"}
    };
    static List<List<List<String>>> inputIngredients = List.of(
            List.of(List.of("yeast", "flour"), List.of("bread", "meat"), List.of("sandwich", "meat", "bread")),
            List.of(List.of("yeast", "flour"), List.of("bread", "meat")),
            List.of(List.of("yeast", "flour")),
            List.of(List.of("yeast", "flour"), List.of("pasta", "meat"), List.of("egg", "meat", "pasta")),
            List.of(List.of("yeast", "flour", "trifle", "bananas", "eggs", "milk"), List.of("eggs", "milk", "custard"))
    );

    static String[][] inputSupplies = {
            {"yeast", "flour", "meat"},
            {"yeast", "flour", "meat"},
            {"yeast", "flour", "corn"},
            {"yeast", "flour", "meat"},
            {"eggs", "milk", "yeast", "flour", "corn", "bananas"}
    };

    static List<List<String>> expected = List.of(
            List.of("bread", "sandwich", "burger"),
            List.of("bread", "sandwich"),
            List.of("bread"),
            List.of("pasta", "egg", "chicken"),
            List.of()
    );

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < inputRecipes.length; i++) {
            testCases.add(Arguments.of(inputRecipes[i], inputIngredients.get(i), inputSupplies[i], expected.get(i)));
        }
        return testCases.stream();
    }

    PossibleRecipes possibleRecipes = new PossibleRecipes();

    @ParameterizedTest(name = "Test case: {index} => recipe={0} ingredient={1} supplies={2} expected={3}")
    @MethodSource("generateTestCases")
    void possibleRecipesTest(String[] recipe, List<List<String>> ingredients, String[] supplies, List<String> expected) {
        List<String> actual = possibleRecipes.findAllRecipes(recipe, ingredients, supplies);
        assertEquals(expected.size(), actual.size());
        boolean bothWayCheck = true;
        for (String expect : expected) {
            if (!actual.contains(expect)) { bothWayCheck = false; break;}
        }
        for (String acutalRecipe : actual) {
            if (!expected.contains(acutalRecipe)) { bothWayCheck = false; break;}
        }
        assertTrue(bothWayCheck, "Expect and Actual contains different value");
    }

}
