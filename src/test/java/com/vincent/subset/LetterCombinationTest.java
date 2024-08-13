package com.vincent.subset;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class LetterCombinationTest {
    static String[] digitsArray = {"23", "73", "426", "78", "925", "2345"};
    static String[][] expected = {{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"},
        {"pd", "pe", "pf", "qd", "qe", "qf", "rd", "re", "rf", "sd", "se", "sf"},
        {"gam", "gan", "gao", "gbm", "gbn", "gbo", "gcm", "gcn", "gco", "ham", "han", "hao", "hbm", "hbn", "hbo", "hcm",
            "hcn", "hco", "iam", "ian", "iao", "ibm", "ibn", "ibo", "icm", "icn", "ico"},
        {"pt", "pu", "pv", "qt", "qu", "qv", "rt", "ru", "rv", "st", "su", "sv"},
        {"waj", "wak", "wal", "wbj", "wbk", "wbl", "wcj", "wck", "wcl", "xaj", "xak", "xal", "xbj", "xbk", "xbl", "xcj",
            "xck", "xcl", "yaj", "yak", "yal", "ybj", "ybk", "ybl", "ycj", "yck", "ycl", "zaj", "zak", "zal", "zbj",
            "zbk", "zbl", "zcj", "zck", "zcl"},
        {"adgj", "adgk", "adgl", "adhj", "adhk", "adhl", "adij", "adik", "adil", "aegj", "aegk", "aegl", "aehj", "aehk",
            "aehl", "aeij", "aeik", "aeil", "afgj", "afgk", "afgl", "afhj", "afhk", "afhl", "afij", "afik", "afil",
            "bdgj", "bdgk", "bdgl", "bdhj", "bdhk", "bdhl", "bdij", "bdik", "bdil", "begj", "begk", "begl", "behj",
            "behk", "behl", "beij", "beik", "beil", "bfgj", "bfgk", "bfgl", "bfhj", "bfhk", "bfhl", "bfij", "bfik",
            "bfil", "cdgj", "cdgk", "cdgl", "cdhj", "cdhk", "cdhl", "cdij", "cdik", "cdil", "cegj", "cegk", "cegl",
            "cehj", "cehk", "cehl", "ceij", "ceik", "ceil", "cfgj", "cfgk", "cfgl", "cfhj", "cfhk", "cfhl", "cfij",
            "cfik", "cfil"}};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            List<String> innerList = new ArrayList<>(Arrays.asList(expected[i]));
            testCases.add(Arguments.of(digitsArray[i], innerList));
        }
        return testCases.stream();
    }

    LetterCombination letterCombination = new LetterCombination();
    @ParameterizedTest(name = "Test case: {index} => digits={0}, expected={1}")
    @MethodSource("generateTestCases")
    void letterCombinationTest(String digits, List<String> expected){
        assertIterableEquals(expected, letterCombination.letterCombinations(digits));
    }

}
