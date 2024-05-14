package com.priyakdey.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class TraversalAlgorithm {

    public static String bfs(Vertex root) {
        if (root == null) return "";

        Deque<Vertex> queue = new ArrayDeque<>();
        queue.offer(root);
        root.setVisited(true);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();

            sb.append(vertex);
            sb.append("->");

            for (Vertex neighbour : vertex.getNeighbours()) {
                if (!neighbour.isVisited()) {
                    queue.offer(neighbour);
                    neighbour.setVisited(true);
                }
            }
        }

        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static String dfs(Vertex root) {
        if (root == null) return "";
        StringBuilder buffer = new StringBuilder();

        // dfsIterative(root, buffer);

        dfsRecursive(root, buffer);
        buffer.delete(buffer.length() - 2, buffer.length());

        return buffer.toString();
    }

    private static void dfsRecursive(Vertex vertex, StringBuilder buffer) {
        buffer.append(vertex);
        buffer.append("->");
        vertex.setVisited(true);

        for (Vertex neighbour : vertex.getNeighbours()) {
            if (!neighbour.isVisited()) {
                dfsRecursive(neighbour, buffer);
            }
        }
    }

    private static void dfsIterative(Vertex root, StringBuilder buffer) {
        Deque<Vertex> stack = new ArrayDeque<>();
        stack.push(root);
        root.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            buffer.append(vertex);

            for (Vertex neighbour : vertex.getNeighbours()) {
                if (!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    stack.push(neighbour);
                }
            }

            if (!stack.isEmpty()) {
                buffer.append("->");
            }
        }
    }


}
