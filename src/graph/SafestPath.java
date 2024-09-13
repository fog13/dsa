package graph;

import java.util.*;

// 2812. Find the Safest Path in a Grid
public class SafestPath{
    final int BIG_NUM = 1000000;

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        final int row = grid.size(), col = grid.get(0).size();
        if (grid.get(0).get(0)==1 || grid.get(row-1).get(col-1)==1)
            return 0;
        int[][] distances = new int[row][col];
        List<Pair<Integer, Integer>> thieves = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid.get(i).get(j) == 1) {
                    thieves.add(new Pair<Integer, Integer>(i, j));
                }
            }
        }
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>(thieves);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            Queue<Pair<Integer, Integer>> q = new LinkedList<>();
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> curr = queue.poll();
                int i = curr.key();
                int j = curr.value();
                Pair<Integer, Integer> up = new Pair<>(i - 1, j);
                Pair<Integer, Integer> right = new Pair<>(i, j + 1);
                Pair<Integer, Integer> down = new Pair<>(i + 1, j);
                Pair<Integer, Integer> left = new Pair<>(i, j - 1);
                List<Pair<Integer, Integer>> trav = new ArrayList<>(List.of(up, right, left, down));
                for (Pair<Integer, Integer> it : trav) {
                    int currRow = it.key(), currCol = it.value();
                    if (currRow < 0 || currRow >= row || currCol < 0 || currCol >= col || grid.get(currRow).get(currCol) == 1) {
                        continue;
                    }
                    if(distances[currRow][currCol] == 0) {
                        distances[currRow][currCol] = depth;
                        q.add(new Pair<>(currRow, currCol));
                    }
                }
            }
            queue = q;
        }

        int[][] djikstra = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(djikstra[i], BIG_NUM);
        }
        Queue<Pair<Integer, Pair<Integer, Integer>>> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        djikstra[0][0] = distances[0][0];
        priorityQueue.add(getWeightedValue(distances[0][0], 0, 0));
        while (!priorityQueue.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> curr = priorityQueue.poll();
            int i = curr.value().key();
            int j = curr.value().value();
            Pair<Integer, Integer> up = new Pair<>(i - 1, j);
            Pair<Integer, Integer> right = new Pair<>(i, j + 1);
            Pair<Integer, Integer> down = new Pair<>(i + 1, j);
            Pair<Integer, Integer> left = new Pair<>(i, j - 1);
            List<Pair<Integer, Integer>> trav = new ArrayList<>(List.of(up, right, left, down));
            for (Pair<Integer, Integer> it : trav) {
                int currRow = it.key(), currCol = it.value();
                if (currRow < 0 || currRow >= row || currCol < 0 || currCol >= col) {
                    continue;
                }
                if (djikstra[currRow][currCol] == BIG_NUM) {
                    djikstra[currRow][currCol] = Math.min(djikstra[i][j], distances[currRow][currCol]);
                    priorityQueue.add(getWeightedValue(djikstra[currRow][currCol], currRow, currCol));
                }
                if (currRow == row - 1 && currCol == col - 1) {
                    return djikstra[currRow][currCol];
                }
            }
        }
        return 0;
    }


    Pair<Integer, Pair<Integer, Integer>> getWeightedValue(int weight, int row, int col) {
        return new Pair<>(weight, new Pair<>(row, col));
    }

    int getManhattanDistance(int r1, int c1, int r2, int c2) {
        int distance = Math.abs(r1 - r2) + Math.abs(c1 - c2);
        return distance;
    }
}


record Pair<K extends Number, V>(K key, V value)
        implements Comparable<Pair<K, V>> {

    @Override
    public int compareTo(Pair<K, V> other) {
        return Integer.compare(key.intValue(), other.key.intValue());
    }
}



























