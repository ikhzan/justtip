package com.justtip.backend.exercises;

public class SolvingQuestions {

    public static void main(String[] args) {
        // stairs n = 4
        // climbing stairs
        num_ways_bottom_up(4);

        // 2 steps, 1 step
    }

    private static int num_ways(int n){
        if (n == 0 || n == 1)
            return 1;
        else
            return num_ways(n-1) + num_ways(n-2);
    }

    private static int num_ways_bottom_up(int n){
        if (n == 0 || n == 1)
            return 1;
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
            System.out.print(nums[i] + " ");
        }
        return nums[n];
    }
}
