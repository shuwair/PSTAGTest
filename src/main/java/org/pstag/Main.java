package org.pstag;

import org.pstag.filter.CarFilter;
import org.pstag.filter.FilterCriteria;
import org.pstag.model.Car;
import org.pstag.output.CarOutputPrinter;
import org.pstag.output.OutputPrinterFactory;
import org.pstag.parser.CarDataParser;
import org.pstag.sort.CarSortStrategy;
import org.pstag.sort.SortField;
import org.pstag.util.CLIArgsReader;
import org.pstag.util.UserOptions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CLIArgsReader cli = new CLIArgsReader();
        List<Car> cars = null;

        // Step 1: Get valid input files
        while (true) {
            try {
                cli.readFilesFromUserInput();
                cars = new CarDataParser().parse(cli.getXmlFile(), cli.getCsvFile());
                break;
            } catch (Exception e) {
                System.out.println("Failed to parse files: " + e.getMessage());
                System.out.println("Please try entering file paths again.\n");
            }
        }

        // Step 2: Repeatedly accept filter + sort options
        while (true) {
            UserOptions opts = cli.readUserOptions();

            List<Car> filtered = CarFilter.applyFilters(
                    cars, new FilterCriteria(opts.getBrand(), opts.getMaxPrice(), opts.getReleaseAfter())
            );

            if (opts.getSortField() != null) {
                if (opts.getSortField() == SortField.CUSTOM &&
                        opts.getCustomType() != null && opts.getCustomCurrency() != null) {
                    CarSortStrategy.sortByCustomTypeAndCurrency(filtered, opts.getCustomType(), opts.getCustomCurrency());
                } else {
                    filtered.sort(opts.getSortField().getStrategy());
                }
            }

            CarOutputPrinter printer = OutputPrinterFactory.getPrinter(opts.getOutputFormat());
            printer.print(filtered);

            System.out.print("\nWould you like to search again? (y/n): ");
            String again = new java.util.Scanner(System.in).nextLine().trim();
            if (!again.equalsIgnoreCase("y")) {
                System.out.println("Exiting. Goodbye!");
                break;
            }
        }
    }
}
