package com.vincent.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheTest {
    static String[] operation = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
    static int[][] input = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
    static Object[] lruExpected = {null, null, null, 1, null, -1, null, -1, 3, 4};

    static String[] lfuOperation = {"LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"};
    static int[][] lfuInput = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {3}, {4, 4}, {1}, {3}, {4}};
    static Object[] lfuExpected = {null, null, null, 1, null, -1, 3, null, -1, 3, 4};

    @Test
    void LRUTest() {
        LRUCache cache = null;
        for (int i = 0; i < operation.length; i++) {
            if ("LRUCache".equals(operation[i])) {
                cache = new LRUCache(input[i][0]);
            } else if ("put".equals(operation[i])) {
                // test put
                cache.put(input[i][0], input[i][1]);
            } else {
                // test get
                assertEquals(lruExpected[i], cache.get(input[i][0]));
            }
        }
    }

    @Test
    void LFUTest() {
        LFUCache cache = null;
        for (int i = 0; i < lfuOperation.length; i++) {
            if ("LFUCache".equals(lfuOperation[i])) {
                cache = new LFUCache(lfuInput[i][0]);
            } else if ("put".equals(lfuOperation[i])) {
                // test put
                cache.put(lfuInput[i][0], lfuInput[i][1]);
            } else {
                // test get
                assertEquals(lfuExpected[i], cache.get(lfuInput[i][0]));
            }
        }
    }
}
