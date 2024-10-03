// goal is to return the step where we are geting zero // (in how many step number is going to be zero)
//leetcode 1342 

public class StepstoReduceNumtoZero1342 {

    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    private int helper(int num, int steps) {
        if (num == 0)
            return steps;
        if (num % 2 == 0) {
            return helper(num / 2, steps + 1);
        }
        return helper(num - 1, steps + 1);
    }

}
