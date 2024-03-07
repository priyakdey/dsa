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

        Deque<Vertex> stack = new ArrayDeque<>();
        stack.push(root);
        root.setVisited(true);

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();

            sb.append(vertex);
            sb.append("->");

            for (Vertex neighbour : vertex.getNeighbours()) {
                if (!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    stack.push(neighbour);
                }
            }
        }

        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }


}
