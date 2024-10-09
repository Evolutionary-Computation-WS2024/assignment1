package evolcomp.strategy;

import evolcomp.tsp.Cycle;
import evolcomp.tsp.TSPInstance;

public final class NNToAnyNodeStrategy extends Strategy {
    public NNToAnyNodeStrategy() {}

    // TODO: Implement
    @Override
    public Cycle apply(final TSPInstance tspInstance, final int startNode) {
        return null;
    }

    @Override
    public String toString() {
        return "Nearest Neighbor to Any Node";
    }
}
