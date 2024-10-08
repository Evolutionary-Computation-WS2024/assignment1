package evolcomp.tsp;

import java.util.HashMap;
import java.util.List;

public final class TSPInstance {
    private final HashMap<Integer, Point> points;
    private final HashMap<Integer, HashMap<Integer, Integer>> distances;
    private final int howManyNodes;

    public TSPInstance(List<Point> points) {
        this.points = new HashMap<>();
        this.distances = new HashMap<>();
        this.howManyNodes = points.size();
        populatePoints(points);
        populateDistances();
    }

    public int getDistanceBetween(final int x, final int y) {
        assert x < howManyNodes;
        assert y < howManyNodes;
        return distances.get(x).get(y);
    }

    public int getCostAt(final int x) {
        assert x < howManyNodes;
        return points.get(x).cost();
    }

    private void populatePoints(final List<Point> pointsToInclude) {
        int i = 0;
        for (Point p : pointsToInclude) {
            this.points.put(i++, p);
        }
    }

    private void populateDistances() {
        for (int i = 0; i < howManyNodes; i++) {
            distances.put(i, new HashMap<>());
            distances.get(i).put(i, 0);
        }

        for (int i = 0; i < howManyNodes; i++) {
            Point a = points.get(i);

            for (int j = 1; j < howManyNodes; j++) {
                Point b = points.get(j);

                // Euclidean distance
                int distance = (int) Math.round(Math.sqrt(Math.pow(a.x() - b.x(), 2) + Math.pow(a.y() - b.y(), 2)));

                distances.get(i).put(j, distance);
                distances.get(j).put(i, distance);
            }
        }
    }

    public int getHowManyNodes() {
        return howManyNodes;
    }
}
