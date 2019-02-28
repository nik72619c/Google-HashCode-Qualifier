import java.io.*;

import java.util.ArrayList;

public class CutterLogic{
    private static String[] datasets = new String[]{"input_example", "input_small", "input_medium", "input_big"};
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < datasets.length; i++) {
            process(datasets[i]);
        }
        private static void process(String filename) throws IOException {
        Pizza pizza = parseInput(filename);
        ArrayList<Slice> slices = solve(pizza);
        }
    }
    private static Pizza parseInput(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename + ".in"));
        String metadata = bufferedReader.readLine();
        String[] metaDataArr = metadata.split(" ");
        Pizza pizza = new Pizza();
        pizza.Row = Integer.parseInt(metaDataArr[0]);
        pizza.Col = Integer.parseInt(metaDataArr[1]);
        pizza.L = Integer.parseInt(metaDataArr[2]);
        pizza.H = Integer.parseInt(metaDataArr[3]);
        for (int i = 0; i < pizza.Row; i++) {
            ArrayList<Character> row = new ArrayList<>();
            String line = bufferedReader.readLine();
            char[] chars = line.toCharArray();
            for (char c : chars) {
                row.add(c);
            }
            pizza.matrix.add(row);
        }
        return pizza;
    }

    private static ArrayList<Slice> solve(Pizza pizza) {

        ArrayList<Slice> slices = new ArrayList<>();
        for (int row = 0; row < pizza.Row; row++) {
            int num_of_tomatoes = 0;
            int num_of_mushrooms = 0;
            Cell start = new Cell(row, 0);
            int column_length = pizza.H > pizza.Col ? pizza.Col : pizza.H;
            int present_column = 0;
            int end_column = columnLength;
            int num_Of_iterations = 0;
            while (num_of_iterations < pizzaTemplate.Col) {
                for (int column = present_column; column < end_column; column++) {
                    if (pizza.matrix.get(row).get(column) == 'T') {
                        num_of_tomatoes++;
                    }
                    if (pizza.matrix.get(row).get(column) == 'M') {
                        num_of_mushrooms++;
                    }
                }
                if (num_of_mushrooms >= pizza.L && num_of_tomatoes >= pizza.L) {
                    slices.add(new Slice(start, new Cell(row, end_column - 1)));
                }
                num_of_mushrooms = 0;
                num_of_tomatoes = 0;
                present_column = end_column;
                start = new Cell(row, present_column);
                end_column = (pizza.H > (pizza.Row - end_column)) ? (pizza.Row - end_column) + present_column : pizza.H + present_column;
                num_of_iterations += end_column;
            }
        }
        return slices;
    }
}