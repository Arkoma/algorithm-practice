package com.aarondburk.algorithmpractice.graphs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph graph = new Graph(4);

    @BeforeEach
    public void setup() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
    }

    @Test
    void bfs() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 0, 3, 1));
        ArrayList<Integer> result = graph.bfs(2);
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }
}