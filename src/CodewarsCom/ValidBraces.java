package CodewarsCom;

import static org.junit.Assert.assertEquals;
import java.util.Stack;

/*
https://www.codewars.com/kata/5277c8a221e209d3f6000b56
*/

public class ValidBraces {
    public static void main(String[] args) {
        assertEquals(true, isValid("()"));
        assertEquals(true, isValid("[]"));
        assertEquals(true, isValid("{}"));
        assertEquals(true, isValid("(){}[]"));
        assertEquals(true, isValid("([{}])"));
        assertEquals(true, isValid("({})[({})]"));
        assertEquals(true, isValid("(({{[[]]}}))"));
        assertEquals(true, isValid("{}({})[]"));

        assertEquals(false, isValid("[(])"));
        assertEquals(false, isValid("(}"));
        assertEquals(false, isValid("(})"));
        assertEquals(false, isValid(")(}{]["));
        assertEquals(false, isValid("())({}}{()][]["));
        assertEquals(false, isValid("(((({{"));
        assertEquals(false, isValid("}}]]))}])"));
    }

    public static boolean isValid(String braces) {
        // Add code here
        Stack<Integer> stack = new Stack<>();
        boolean result = true;
        for (int i = 0; i < braces.length(); i++){

            if (braces.charAt(i) == '(') {
                stack.push(1);
            } else if (braces.charAt(i) == '[') {
                stack.push(2);
            } else if (braces.charAt(i) == '{') {
                stack.push(3);
            } else if (stack.empty() == false
                        && ((braces.charAt(i) == ')' && stack.peek() == 1)
                            || (braces.charAt(i) == ']' && stack.peek() == 2)
                            || (braces.charAt(i) == '}' && stack.peek() == 3))){
                stack.pop();
            } else {
                return false;
            }

        }
        if (stack.empty() == false) result = false;
        return result;
    }

    
//    public static boolean isValid(String braces) {
//        // Add code here
//        Stack<Integer> stack = new Stack<>();
//        boolean result = true;
//        for (int i = 0; i < braces.length(); i++){

//            if (braces.charAt(i) == '(') {
//                stack.push(1);
//            } else if (braces.charAt(i) == ')') {
//                if (stack.empty() == false && stack.peek() == 1) {
//                    stack.pop();
//                } else {return false;}
//            }

//            if (braces.charAt(i) == '[') {
//                stack.push(2);
//            } else if (braces.charAt(i) == ']') {
//                if (stack.empty() == false && stack.peek() == 2) {
//                    stack.pop();
//                } else {return false;}
//            }

//            if (braces.charAt(i) == '{') {
//                stack.push(3);
//            } else if (braces.charAt(i) == '}') {
//                if (stack.empty() == false && stack.peek() == 3) {
//                    stack.pop();
//                } else {return false;}
//            }

//            System.out.println(stack);
//        }
//        if (stack.empty() == false) result = false;
//        return result;
//    }


// VER - breaks on mixed like "[(])"
//    public static boolean isValid(String braces) {
//        // Add code here
//        boolean result = false;
//        int a = 0, b = 0, c = 0;
//        for (int i = 0; i < braces.length(); i++){
//           a = braces.charAt(i) == '(' ? ++a : braces.charAt(i) == ')' ? --a : a;
//           b = braces.charAt(i) == '[' ? ++b : braces.charAt(i) == ']' ? --b : b;
//           c = braces.charAt(i) == '{' ? ++c : braces.charAt(i) == '}' ? --c : c;
//           if (a < 0 || b < 0 && c < 0)
//               break;
//        }
//        if (a == 0 && b == 0 && c == 0)
//            result = true;
//        return result;
//    }

}
