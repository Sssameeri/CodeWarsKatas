package com.company;

import java.util.*;


public class Main {
    //Create phone number from int array
    public static String createPhoneNumber(int[] numbers) {

        String phoneNumber = "(xxx) xxx-xxxx";

        for (int number : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", String.valueOf(number));
        }
        return phoneNumber;
    }
    //String array like wave
    public static String[] wave(String str) {
        String upperStr = str.toUpperCase();
        String lowerStr = str.toLowerCase();
        LinkedList<String> array = new LinkedList<>();
        char[] letters = upperStr.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            char[] temp = lowerStr.toCharArray();
            temp[i] = letters[i];
            String string = new String(temp);
            if (!(string.equals(str))) {
                array.add(string);
            }
        }

        return array.toArray(new String[array.size()]);
    }
    //String toCamelCase
    static String toCamelCase(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        String string = "-_[] ";

        for (int i = 0; i < stringBuilder.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                if (stringBuilder.charAt(i) == string.charAt(j)) {
                    stringBuilder.setCharAt(i + 1, Character.toUpperCase(stringBuilder.charAt(i + 1)));
                    stringBuilder.deleteCharAt(i);
                }
            }
        }

        return stringBuilder.toString();
    }
    //Reverse polish notation
    public static double evaluate(String expr) {

        if (expr.equals(""))
            return 0;

        String[] stringsArray = expr.split(" ");
        double result = 0.0;
        Stack<String> stack = new Stack<>();

        for (String token : stringsArray) {
            if(token.equals(expr))
                return Double.parseDouble(expr);

            double firstNum, secondNum;
                switch (token) {
                    case "*":
                        result = Double.parseDouble(stack.pop()) *  Double.parseDouble(stack.pop());
                        stack.push(String.valueOf(result));
                        break;
                    case "/":
                        secondNum = Double.parseDouble(stack.pop());
                        firstNum = Double.parseDouble(stack.pop());

                        result = firstNum / secondNum;
                        stack.push(String.valueOf(result));
                        break;
                    case "+":
                        result = Double.parseDouble(stack.pop()) +  Double.parseDouble(stack.pop());
                        stack.push(String.valueOf(result));
                        break;
                    case "-":
                        secondNum = Double.parseDouble(stack.pop());
                        firstNum = Double.parseDouble(stack.pop());
                        result = firstNum - secondNum;
                        stack.push(String.valueOf(result));
                        break;
                    default: stack.push(token);
                }
            }

        return result;
    }

    public static void main(String[] args) {

    }
}



