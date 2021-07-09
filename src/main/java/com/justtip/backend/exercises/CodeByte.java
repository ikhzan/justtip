package com.justtip.backend.exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeByte {


    public static void main(String[] args) {
        System.out.println("Find Intersection");
        String[] inputs = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        System.out.println(FindIntersection(inputs));

        System.out.println("Find Question Marks");
        String input2 = "aa6?9";
        System.out.println(QuestionMarks(input2));
        input2 = "acc?7??sss?3rr1??????5";
        System.out.println(QuestionMarks(input2));

        inputs = new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        for(String in: inputs){
            System.out.print(in);
        }
        
        System.out.println("Find Tree Constructor ");
        System.out.println(TreeConstructor(inputs));
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
