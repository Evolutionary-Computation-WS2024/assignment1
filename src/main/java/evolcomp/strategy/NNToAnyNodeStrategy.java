package evolcomp.strategy;

import evolcomp.tsp.Cycle;
import evolcomp.tsp.TSPInstance;
import evolcomp.strategy.NNToAnyUtils.Patch;    


public final class NNToAnyNodeStrategy extends Strategy {
    public NNToAnyNodeStrategy() {}
    
    // TODO: Implement
    @Override
    public Cycle apply(final TSPInstance tspInstance, final int startNode) {
        
        int no_nodes = tspInstance.getHowManyNodes();
        int half_no_nodes = (int) Math.ceil(no_nodes / 2.0);
        
        Patch patch = new Patch(startNode, tspInstance);
        
        for (int i = 2; i <= half_no_nodes; i++) {
            patch.extend();
        }
        return new Cycle(patch.toList());
    }

    @Override
    public String toString() {
        return "Nearest Neighbor to Any Node";
    }
}
