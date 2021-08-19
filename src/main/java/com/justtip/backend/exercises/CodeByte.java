package com.justtip.backend.exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeByte {


    public static void main(String[] args) {
        System.out.println("Repeated String");
//        System.out.println("Result " + repeatedString("aba",10));
//        System.out.println("Result " + repeatedString("a",100000000));
//        fizzBuzz(15);
        List<Integer> parent = Arrays.asList(-1,0,0,1,1,2);
        List<Integer> filezie = Arrays.asList(1,2,2,1,1,1);
        System.out.println("Parent: " + parent);
        System.out.println("File Size: " + filezie);
        System.out.println("Result: " + mostBalancePartition(parent,filezie));
    }

    public static int mostBalancePartition(List<Integer> parent, List<Integer> file_size){
        int diff = 0;
        int sum = 0;
        for (int j=0; j < file_size.size(); j++){
            sum += file_size.get(j);
        }

        return sum;
    }

    public static void fizzBuzz(int n){
        for (int i=1; i<=n; i++){
            if (((i % 3) == 0) && ((i % 5) == 0)){
                System.out.println("FizzBuzz");
            }else if((i % 3) == 0){
                System.out.println("Fizz");
            } else if((i % 5) == 0){
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }
    }

    // repeat string
    /**
     * There is a string, , of lowercase English letters that is repeated infinitely many times. Given an integer, , find and print the number of letter a's in the first
     * letters of the infinite string.
     * Example
     * The substring we consider is , the first characters of the infinite string. There are
     * occurrences of a in the substring.
     * Function Description
     * Complete the repeatedString function in the editor below.
     * repeatedString has the following parameter(s):
     *     s: a string to repeat
     *     n: the number of characters to consider
     * Returns
     *     int: the frequency of a in the substring
     */
    public static long repeatedString(String s, long n){
        // s = a, n = 1000000
        long size = s.length(); // 1
        s = s.toLowerCase();

        long repeated = n/size; // 1000000 / 1
        long left = n - (size * repeated); // 1000000 - (1*1000000) = 0
        int extra = 0;

        int count = 0;
        for (int i=0; i < size; i++){
            if (s.charAt(i) == 'a'){
                ++count; // 1
            }
        }
        for (int i=0; i < left; i++){
            if (s.charAt(i) == 'a'){
                ++extra; // 1
            }
        }

        repeated = (repeated * count) + extra; // (1000000 * 1) + 1

        return repeated; // 7
    }


    /**
     * There is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus or
     *
     * . The player must avoid the thunderheads. Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud. It is always possible to win the game.
     *
     * For each game, you will get an array of clouds numbered
     * if they are safe or
     *
     * if they must be avoided.
     *
     * Example
     * Index the array from .
     * The number on each cloud is its index in the list so the player must avoid the clouds at indices and.
     * They could follow these two paths: or . The first path takes jumps while the second takes .
     * Return .
     *
     * Function Description
     *
     * Complete the jumpingOnClouds function in the editor below.

     * jumpingOnClouds has the following parameter(s):
     *     int c[n]: an array of binary integers
     * Returns
     *     int: the minimum number of jumps required
     */
    /**
     * what does it do?
     * so the input is a list of integer
     * we loop through the list from 0 to cloud.size()-1, which means that
     * if we have [0, 0, 1, 0, 0, 1, 0] we go from index 0 which is 0 and check
     * if integer i or 0 + 2 is smaller than the size and integer at index i+2 is not 1
     *
     */
    public static int jumpingOnClouds(List<Integer> clouds){
        int jumps = 0;
        int i = 0;
        while (i < clouds.size()-1){
            if (i+2<clouds.size() && clouds.get(i+2) != 1){
                jumps++;
                i+=2;
            }else{
                jumps++;
                i++;
            }
        }

        return jumps;
    }


    public static int countingValleys(int steps, String paths){
        int valleys = 0;
        int sealevel = 0;
        paths = paths.toUpperCase(Locale.ROOT);
        char[] path = paths.toCharArray();
        for (int i=0; i < paths.length(); i++){
            if (path[i] == 'U'){
                sealevel++;
            }else{
                sealevel--;
            }
            if (sealevel == 0 && path[i] == 'U'){
                valleys++;
                steps--;
            }

        }
        System.out.println("Steps: " + steps);
        return valleys;
    }

    public static int findPairs(List<Integer> input){
        Set<Integer> colors = new HashSet<>();
        int pairs = 0;
        int n = 9;
        List<Integer> c = Arrays.asList(10,20,20,10,10,30,50,10,20,80,80,80,80);

        // to calculate pair or similar int in list
        for (Integer integer : c) {
            if (!colors.contains(integer)) {
                colors.add(integer);
            } else {
                pairs++;
                colors.remove(integer);
            }
        }
        System.out.println("Results: " +pairs);
        return pairs;
    }

    /*
        Have the function QuestionsMarks(str) take the str string parameter, which will contain single digit numbers,
        letters, and question marks, and check if there are exactly 3 question marks between every pair of two numbers
        that add up to 10. If so, then your program should return the string true, otherwise it should return the string false.
        If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.
        For example: if str is "arrb6???4xxbl5???eee5" then your program should return true because there are exactly 3
        question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.
     */
    public static String QuestionMarks(String str){
        String numMarks = str.replaceAll("[^0-9?]","");
        Pattern pattern = Pattern.compile("(\\d\\?+\\d)");
        Matcher matcher = pattern.matcher(numMarks);
        boolean matched = false;
        while (matcher.find()){
            String match = matcher.group();
            int a = Integer.parseInt(match.substring(0,1));
            int b = Integer.parseInt(match.substring(match.length()-1));
            if (a + b == 10){
                if (match.length() != 5){
                    return "false";
                }else {
                    matched = true;
                }
            }
        }
        return matched ? "true" : "false";
    }


    /*
     * Have the function FindIntersection(strArr) read the array of strings stored
     * in strArr which will contain 2 elements:
     * - the first element will represent a list of comma-separated numbers sorted in ascending order,
     * - the second element will represent a second list of comma-separated numbers (also sorted).
     * - Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order.
     * If there is no intersection, return the string false.
     */
    public static String FindIntersection(String[] strArr){
        String[] first = strArr[0].split(", ");
        String[] second = strArr[1].split(", ");
        StringBuilder sb = new StringBuilder();
        int i =0;
        int j =0;
        while (i < first.length && j < second.length){
            if (Integer.parseInt(first[i]) == Integer.parseInt(second[j]) ){
                sb.append(first[i]).append(",");
                i++;
                j++;
            }else if (Integer.parseInt(first[i]) > Integer.parseInt(second[j])){
                j++;
            }else{
                i++;
            }
            if (sb.toString().length() == 0){
                strArr[0] = "false";
            }else {
                String anw = sb.substring(0,sb.toString().length()-1);
                strArr[0] = anw;
            }

        }

        return strArr[0];
    }


    /*
     * Tree Constructor
     * Have the function TreeConstructor(strArr) take the array of strings stored in strArr,
     * which will contain pairs of integers in the following format: (i1,i2),
     * where i1 represents a child node in a tree and the second integer i2 signifies that it is the parent of i1.
     * For example: if strArr is ["(1,2)", "(2,4)", "(7,2)"], then this forms the following tree:
     * which you can see forms a proper binary tree. Your program should, in this case,
     * return the string true because a valid binary tree can be formed. If a proper binary tree cannot be formed with
     * the integer pairs, then return the string false. All of the integers within the tree will be unique,
     * which means there can only be one node in the tree with the given integer value.
     */
    public static String TreeConstructor(String[] strArr){
        Set<String> children = new HashSet<>();
        Map<String,Integer> parents = new HashMap<>();
        // Build a Set containing the child nodes, which will remove duplicates, and a Map of the parent nodes that
        // keeps track of the count of each parent.
        for (String node: strArr){
            String[] values = node.replaceAll("[^0-9,]","").split(",");
            children.add(values[0]);
            Integer count = parents.get(values[1]);
            if (count != null && count + 1 > 2){
                return "false";
            }else{
                parents.put(values[1], (count == null ? 1 : ++count));
            }
        }
        return "" + (children.size() == strArr.length);
    }

}
