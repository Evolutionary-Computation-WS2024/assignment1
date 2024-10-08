package evolcomp.tsp;

import java.util.Iterator;
import java.util.List;

public record Solution(List<Integer> nodes) {
    public int evaluate(TSPInstance context) {
        int totalCost = 0;

        Iterator<Integer> i = nodes.iterator();
        int prev = i.next();

        while (i.hasNext()) {
            // add cost of node
            totalCost += context.getCostAt(prev);

            int next = i.next();

            // add cost of edge
            totalCost += context.getDistanceBetween(prev, next);

            prev = next;
        }

        // add cost of edge between first and last
        totalCost += context.getDistanceBetween(nodes.get(0), prev);

        // add cost of last node
        totalCost += context.getCostAt(prev);

        return totalCost;
    }
}
