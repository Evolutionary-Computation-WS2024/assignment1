package evolcomp.io;

import evolcomp.tsp.Cycle;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class SolutionExporter {
    // TODO: Implement
    // Format (CSV): instance; method_name; nodes
    public static void export(List<SolutionRow> records, String path) throws IOException {
        try (FileWriter out = new FileWriter("results.csv")) {
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setDelimiter(';')
                    .build();

            CSVPrinter printer = csvFormat.print(out);
            printer.printRecords(records);
            printer.flush();
        }
    }
}
