package com.vincent.graph.topologicalsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AlienDictionaryTest {
    static String[][] words = {
            {"alpha", "bravo", "charlie", "delta"},
            {"apple", "app"},
            {"martian"},
            {"jupyter", "ascending"},
            {"passengers", "to", "the", "unknown"}
    };
    static String[] order = {
            "abcdefghijklmnopqrstuvwxyz",
            "abcdefghijklmnopqrstuvwxyz",
            "mabcdefghijklnopqrstuvwxyz",
            "jabcdefghiklmnopqrstuvwxyz",
            "ptuhabcdefghijklmnoqrsvwxyz"
    };

    static boolean[] expected = {
            true, false, true, true, false
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            testCases.add(Arguments.of(words[i], order[i], expected[i]));
        }
        return testCases.stream();
    }

    AlienDictionary dictionary = new AlienDictionary();

    @ParameterizedTest(name = "Test case: {index} => words={0} order={1} expected={2}")
    @MethodSource("generateTestCases")
    void verifyAlienDictionaryTest(String[] words, String order, boolean expected) {
        assertEquals(expected, dictionary.isAlienSorted(words, order));
    }

    static String[][] input = {
            {"mzosr", "mqov", "xxsvq", "xazv", "xazau", "xaqu", "suvzu", "suvxq", "suam", "suax", "rom", "rwx", "rwv"},
            {"vanilla", "alpine", "algor", "port", "norm", "nylon", "ophellia", "hidden"},
            {"passengers", "to", "the", "unknown"},
            {"alpha", "bravo", "charlie", "delta"},
            {"jupyter", "ascending"},
            {"z", "x"},
            {"aabc"},
            {"z", "x", "z"},
            {"abc", "ab"},
            {"ab", "ab"},
            {"z", "ab", "ab"},
            {"z", "ab", "abc"},
            {"ab", "abc"},
            {"z", "ab", "ab", "cd", "cdef"},
            {"w", "z", "x", "z"},
            {"z", "abc", "ab"},
            {"zy", "zx"}
    };

    static Map<String[], Map<Character, Set<Character>>> expectedGraphResults = new HashMap<>() {{
        put(input[0], buildGraph(input[0]));  // Valid sorting graph for testing
        put(input[1], buildGraph(input[1]));
        put(input[2], buildGraph(input[2]));
        put(input[3], buildGraph(input[3]));
        put(input[4], buildGraph(input[4]));
        put(input[5], buildGraph(input[5]));
        put(input[6], buildGraph(input[6]));  // Invalid: no ordering possible
        put(input[7], Collections.emptyMap());  // Invalid: cycle exists
        put(input[8], Collections.emptyMap());  // Invalid: "abc" is a prefix of "ab"
        put(input[9], buildGraph(input[9]));  // Same words, any order valid
        put(input[10], buildGraph(input[10]));
        put(input[11], buildGraph(input[11]));
        put(input[12], buildGraph(input[12]));
        put(input[13], buildGraph(input[13]));
        put(input[14], Collections.emptyMap());  // Invalid: cycle exists
        put(input[15], Collections.emptyMap());  // Invalid: prefix issue
        put(input[16], buildGraph(input[16]));  // "zy", "zx" implies "y" before "x"
    }};

    static Stream<Arguments> generateTestCasesOrder() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            Map<Character, Set<Character>> graph = buildGraph(input[i]);
            testCases.add(Arguments.of(input[i], expectedGraphResults.get(input[i])));
        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => input={0}, expectedGraph={1} ")
    @MethodSource("generateTestCasesOrder")
    void alienOrderTest(String[] input,  Map<Character, Set<Character>> expectedGraph) {
        String actual = dictionary.alienOrder(input);
        if (expectedGraph.isEmpty()) {
            // 如果无法生成有效的排序，期望结果应为空
            assertTrue(actual.isEmpty(), "Expected an empty result, but got: " + actual);
        } else {
            // 否则，验证实际结果中字符顺序是否正确
            assertTrue(isValidTopologicalSort(actual, expectedGraph), "Invalid topological order: " + actual);
        }
    }

    // 根据字典构建图
    private static Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    graph.get(first.charAt(j)).add(second.charAt(j));
                    break;
                }
            }
        }
        return graph;
    }

    // 检查拓扑排序是否有效
    private boolean isValidTopologicalSort(String order, Map<Character, Set<Character>> graph) {
        Map<Character, Integer> position = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            position.put(order.charAt(i), i);
        }

        for (char u : graph.keySet()) {
            for (char v : graph.get(u)) {
                if (position.get(u) >= position.get(v)) {
                    return false;  // 找到不符合拓扑排序顺序的边
                }
            }
        }
        return true;
    }

}
