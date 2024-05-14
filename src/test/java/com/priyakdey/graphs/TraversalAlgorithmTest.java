package com.priyakdey.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TraversalAlgorithm")
class TraversalAlgorithmTest {

    private Vertex root;

    @BeforeEach
    public void setup() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");

        a.addNeighbour(b, c);
        b.addNeighbour(d);

        root = a;
    }

    @Test
    @DisplayName("bfs")
    void bfs() {
        String actual = TraversalAlgorithm.bfs(root);
        String expected = "a->b->c->d";
        assertEquals(actual, expected,
            () -> String.format("expected %s, but got %s%n", expected, actual));
    }

    @Test
    @DisplayName("dfs")
    void dfs() {
        String actual = TraversalAlgorithm.dfs(root);
        String expected1 = "a->c->b->d";
        String expected2 = "a->b->d->c";

        assertTrue(Objects.equals(expected1, actual) || Objects.equals(expected2, actual),
            () -> String.format("expected %s or %s, but got %s%n", expected1, expected2, actual));
    }
}