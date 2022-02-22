package ua.com.alevel.mediumlevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public final class BracketSequence {

    private BracketSequence() { }

    public static void checkBracketSequence() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.print("\nType some string: ");
                String s = reader.readLine();
                if (isValidString(s)) {
                    System.out.println("\nAnswer: bracket sequence is correct!");
                } else {
                    System.out.println("\nAnswer: bracket sequence is incorrect!");
                }
                System.out.print("\nRepeat (print 'yes') or another char to end -> ");
                s = reader.readLine();
                if (!s.equals("yes")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isValidString(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}