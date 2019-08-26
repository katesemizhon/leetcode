package com.semizhon;

import java.util.Set;
import java.util.Stack;

public class ValidParentheses {

  static Set<Character> openParentheses = Set.of('(', '{', '[');
  static Set<Character> closeParentheses = Set.of(')', '}', ']');

  static {
  }

  private static Character getOpenPair(Character close) {
    switch (close) {
      case '}':
        return '{';
      case ')':
        return '(';
      case ']':
        return '[';
      default:
        return '/';
    }
  }

  public static boolean isValid(String s) {

    if (s.length() % 2 != 0) {
      return false;
    }
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      Character currentCharacter = s.charAt(i);

      if (openParentheses.contains(currentCharacter)) {
        stack.push(currentCharacter);
      } else if (!stack.empty()) {

        Character characterInStack = stack.pop();
        if (!characterInStack.equals(getOpenPair(currentCharacter))) {
          return false;
        }
      } else {
        return false;
      }
    }

    if (stack.empty()) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println(isValid("("));
    System.out.println(isValid("()")); // true
    System.out.println(isValid("()[]{}")); // true
    System.out.println(isValid("(]"));
    System.out.println(isValid("([)]"));
    System.out.println(isValid("{[]}")); // true
  }
}
