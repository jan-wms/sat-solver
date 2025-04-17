package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm {
    int variablesCount;
    int clausesCount;
    List<List<Integer>> cnfList;
    String result;

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        String input = "c\nc start with comments\nc\nc \np cnf 5 3\n1 -5 4 0\n-1 5 3 4 0\n-3 -4 0";
        algorithm.run(input);
    }

    public void run(String input) {
        variablesCount = -1;
        clausesCount = -1;
        cnfList = null;
        result = null;

        getCnfListFromDimacs(input);
        solve();
    }

    public void solve() {
        boolean[] output = solveRecursive();
        result = output == null ? "UNSAT" : Arrays.toString(output);
    }

    public boolean[] solveRecursive(List<List<Integer>> input, boolean[] configuration) {
        if (input.isEmpty()) return configuration;
        if (input.stream().anyMatch(List::isEmpty)) return null;


    }

    public void getCnfListFromDimacs(String input) {
        try {
            String[] lines = input.split("\n");
            String problemLine = Arrays.stream(lines).filter(line -> line.startsWith("p cnf")).findFirst().orElse("");
            variablesCount = Integer.parseInt(problemLine.substring(6).split(" ")[0]);
            clausesCount = Integer.parseInt(problemLine.substring(6).split(" ")[1]);

            if (clausesCount == 0 || variablesCount == 0) return;

            List<List<Integer>> list = new ArrayList<>();

            Arrays.stream(lines)
                    .filter(line -> line.endsWith(" 0"))
                    .forEach(line -> {
                        List<Integer> clause = new ArrayList<>();
                        int[] ints = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                        Arrays.stream(ints).limit(ints.length - 1).forEach(clause::add);
                        list.add(clause);
                    });

            cnfList = list;
            if (cnfList.size() != clausesCount) throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
