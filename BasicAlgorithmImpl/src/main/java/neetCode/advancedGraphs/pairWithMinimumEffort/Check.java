package neetCode.advancedGraphs.pairWithMinimumEffort;

public class Check {
    enum Result{
        TRUE("true"),
        FALSE("false");

        Result(String s) {

        }
    }
    public static void main(String[] args) {
        Boolean[][] dp = new Boolean[2][2];
        //Result[][] results = new Result[1][1];
        Result results[][] = new Result[1][1];
        System.out.println(results[0][0]);
        System.out.println(Result.valueOf("TRUE"));
        System.out.println(Result.values());
    }
}
