package com.priyakdey.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class Vertex {

    private final String name;
    private final List<Vertex> neighbours;
    private boolean visited;

    public Vertex(String name) {
        this.name = name;
        neighbours = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Vertex... vertex) {
        neighbours.addAll(Arrays.stream(vertex).toList());
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
