package evolcomp.tsp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class TSPInstance {
    private final HashMap<Integer, Point> points = new HashMap<>();
    private final HashMap<Integer, HashMap<Integer, Integer>> distances = new HashMap<>();
    private String name;
    private final int howManyNodes;

    public TSPInstance(List<Point> points) {
        this.howManyNodes = points.size();
        this.name = null;
        populatePoints(points);
        populateDistances();
    }

    public TSPInstance(List<Point> points, String name) {
        this.howManyNodes = points.size();
        this.name = name;
        populatePoints(points);
        populateDistances();
    }

    public int evaluate(Cycle cycle) {
        int totalCost = 0;

        Iterator<Integer> i = cycle.nodes().iterator();
        int prev = i.next();

        while (i.hasNext()) {
            // add cost of node
            totalCost += getCostAt(prev);

            int next = i.next();

            // add cost of edge
            totalCost += getDistanceBetween(prev, next);

            prev = next;
        }

        // add cost of edge between first and last
        totalCost += getDistanceBetween(cycle.nodes().get(0), prev);

        // add cost of last node
        totalCost += getCostAt(prev);

        return totalCost;
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

    //Returns number of nodes for this TSP instance
    public int getHowManyNodes() {
        return howManyNodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TSPInstance{" +
                "name='" + name + '\'' +
                '}';
    }
}
