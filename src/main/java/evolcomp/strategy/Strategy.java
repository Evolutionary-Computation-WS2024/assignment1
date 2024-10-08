package evolcomp.strategy;

import evolcomp.tsp.Solution;
import evolcomp.tsp.TSPInstance;

public abstract class Strategy {
    public abstract Solution apply(final TSPInstance tspInstance, final int startNode);
}
