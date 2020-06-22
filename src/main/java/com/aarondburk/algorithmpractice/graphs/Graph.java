package com.aarondburk.algorithmpractice.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int numberOfVertices;
    private LinkedList<Integer> adjacencyLists[];

    Graph(int _numberOfVertices) {
        numberOfVertices = _numberOfVertices;
        adjacencyLists = new LinkedList[_numberOfVertices];
        for (int i = 0; i < _numberOfVertices; i++) {
            adjacencyLists[i] = new LinkedList<>();
        }
    }

    void addEdge(int start, int end) {
        adjacencyLists[start].add(end);
    }

    ArrayList<Integer> bfs(int departureVertex) {
        boolean[] visited = new boolean[numberOfVertices];
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> vertexQueue = new LinkedList<>();

        visited[departureVertex] = true;
        vertexQueue.add(departureVertex);

        while (vertexQueue.size() != 0) {
            departureVertex = vertexQueue.poll();
            result.add(departureVertex);
            Iterator<Integer> graphIterator = adjacencyLists[departureVertex].iterator();
            while (graphIterator.hasNext()) {
                int currentVertex = graphIterator.next();
                if (!visited[currentVertex]) {
                    visited[currentVertex] = true;
                    vertexQueue.add(currentVertex);
                }

            }
        }
        return result;
    }
}
