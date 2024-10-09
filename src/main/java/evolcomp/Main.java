package evolcomp;

import evolcomp.io.CostTspReader;
import evolcomp.io.SolutionExporter;
import evolcomp.io.SolutionRow;
import evolcomp.misc.Evaluator;
import evolcomp.strategy.*;
import evolcomp.tsp.TSPInstance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<TSPInstance> tspInstances = new ArrayList<>();
        tspInstances.add(CostTspReader.read("TSPA.csv"));
        tspInstances.add(CostTspReader.read("TSPB.csv"));

        List<Strategy> strategies = new ArrayList<>();
        strategies.add(new RandomStrategy());
        strategies.add(new NNToEndStrategy());
        strategies.add(new NNToAnyNodeStrategy());
        strategies.add(new GreedyCycleStrategy());

        List<SolutionRow> solutions = new ArrayList<>();
        for (TSPInstance instance : tspInstances) {
            for (Strategy strategy : strategies) {
                Evaluator evaluator = new Evaluator(instance, strategy);

                String methodName = strategy.toString();
                String instanceName = instance.toString();
                String bestSolution = evaluator.getBestCycle().toString();

                SolutionRow row = new SolutionRow(methodName, instanceName, bestSolution);
                solutions.add(row);
            }
        }

        SolutionExporter.export(solutions, "solution.csv");
    }
}