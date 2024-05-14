package com.priyakdey.graphs;

/**
 * Implement an algorithm that can find the way out of a maze.
 * <pre>
 *  maze = [
 *      [1,1,1,1,1],
 *      [1,2,0,1,1],
 *      [1,1,0,1,1],
 *      [1,1,0,0,0],
 *      [1,1,1,1,3],
 *  ]
 * </pre>
 * <ol>
 *     <li>integer <strong>1</strong> represents walls</li>
 *     <li>integer <strong>2</strong> is the starting point</li>
 *     <li>integer <strong>3</strong> is the destination (so this is what we are looking for)</li>
 *     <li>integer <strong>0</strong> represents the states we can consider (so the solution contains one or more 0 states)</li>
 * </ol>
 * <p>
 * So the solution should be something like this (S represents the states in the solution set):
 * <pre>
 *     S = [
 *      [-,-,-,-,-],
 *      [-,2,S,-,-],
 *      [-,-,S,-,-],
 *      [-,-,S,S,S],
 *      [-,-,-,-,3],
 *  ]
 * </pre>
 *
 * @author Priyak Dey
 */
public class MazeEscape {

    public void escapePath(int[][] maze, int startRow, int startCol, int destRow, int destCol) {
        // TODO
    }

}
