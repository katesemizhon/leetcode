package com.semizhon;

import java.util.HashMap;
import java.util.Map;

public class ReverseInteger {

  private static Map<Character, Integer> romanToInteger = new HashMap<Character, Integer>();

  static {
    romanToInteger.put('I', 1);
    romanToInteger.put('V', 5);
    romanToInteger.put('X', 10);
    romanToInteger.put('L', 50);
    romanToInteger.put('C', 100);
    romanToInteger.put('D', 500);
    romanToInteger.put('M', 1000);
  }

  public static void main(String[] args) {

    System.out.println(romanToInt("I"));
    System.out.println(romanToInt("II"));
    System.out.println(romanToInt("III"));
    System.out.println(romanToInt("IV"));
    System.out.println(romanToInt("VI"));
    System.out.println(romanToInt("VIII"));
    System.out.println(romanToInt("XIX"));
    // 44= XLIV
    System.out.println(romanToInt("XLIV"));
  }

  public static int reverse(int x) {
    int mult = 1;
    if (x < 0) {
      x = x * (-1);
      mult = -1;
    }
    String xString = String.valueOf(x);
    StringBuilder yString = new StringBuilder("");
    xString = trimZeros(xString);
    int y = 0;
    for (int i = xString.length() - 1; i >= 0; i--) {
      yString.append(xString.charAt(i));
    }

    try {
      y = Integer.valueOf(yString.toString());
    } catch (NumberFormatException e) {
      y = 0;
    }

    return y * mult;
  }

  public static String trimZeros(String x) {
    int endIndex = x.length() - 1;
    while ("0".equals(x.charAt(endIndex))) {
      endIndex--;
    }
    x = x.substring(0, endIndex + 1);
    return x;
  }

  public static int romanToInt(String s) {

    int decimalResult = 0;
    int subSum = 0;

    for (Character c : s.toCharArray()) {
      int currentSymbolValue = romanToInteger.get(c);
      if (subSum == 0 && decimalResult == 0) {
        subSum = currentSymbolValue;
      } else {
        if (currentSymbolValue > subSum && subSum > 0) {
          decimalResult = decimalResult + currentSymbolValue - subSum;
          subSum = 0;
        } else if (currentSymbolValue > subSum && subSum == 0) {
          subSum = currentSymbolValue;
        } else if (currentSymbolValue == subSum) {
          subSum = subSum + currentSymbolValue;
        } else if (currentSymbolValue < subSum) {
          decimalResult = decimalResult + subSum;
          subSum = currentSymbolValue;
        }
      }
    }
    decimalResult = decimalResult + subSum;

    return decimalResult;
  }
}
