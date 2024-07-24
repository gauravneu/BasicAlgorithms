package neetCode.advancedGraphs.pairWithMinimumEffort;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PairWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        Pair p = new Pair(0,0,0);
        Set<Pair> set = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(p);
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            if(set.contains(p1)){
                continue;
            }
            set.add(p1);
            if(p1.x == rows - 1 && p1.y == cols - 1){
                return p1.diff;
            }
            for(int i = 0; i < 4; i++) {
                int newR = p1.x + directions[i][0];
                int newC = p1.y + directions[i][1];
                Pair p2 = new Pair(0, newR, newC);
                if (newR < 0 || newC < 0 || newR == rows || newC == cols || set.contains(p2)) {
                    continue;
                }
                int newDiff = Math.max(p1.diff, Math.abs(heights[p1.x][p1.y] - heights[p2.x][p2.y]));
                p2.diff = newDiff;
                pq.add(p2);
            }
        }
        return -1;
    }


    class Pair implements Comparable<Pair> {
        private int diff;
        private int x;
        private int y;

        public Pair(int diff, int x, int y){
            this.diff = diff;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.diff, o.diff);
        }

        @Override
        public boolean equals(Object o){
            Pair p = (Pair)o;
            return p.x == this.x && p.y == this.y;
        }
    }
}
