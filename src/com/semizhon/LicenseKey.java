package com.semizhon;

public class LicenseKey {

  static class Solution {
    public String licenseKeyFormatting(String S, int K) {
      String s =
          getFormatterLicense(new StringBuilder(S.toUpperCase()).reverse(), K).reverse().toString();
      s = s.startsWith("-") ? s.substring(1, s.length()) : s;
      s = s.endsWith("-") ? s.substring(0, s.length() - 1) : s;
      return s;
    }

    private StringBuilder getFormatterLicense(StringBuilder str, int k) {
      StringBuilder formattedGroup = new StringBuilder();
      StringBuilder formattedSring = new StringBuilder();

      while (k < str.length()) {
        StringBuilder notFormattedGroup = getNextKGroup(str, k);

        formattedGroup = deleteDashes(notFormattedGroup);
        formattedSring.append("-").append(formattedGroup);
        str = new StringBuilder(str.substring(notFormattedGroup.length()));
      }
      if (k >= str.length()) {

        formattedGroup = deleteDashes(str);
        formattedSring.append("-").append(formattedGroup);
      }

      return formattedSring;
    }

    private StringBuilder deleteDashes(StringBuilder str) {
      StringBuilder skipDashesString = new StringBuilder();
      for (int i = 0; i < str.length(); i++) {
        if ('-' != str.charAt(i)) {
          skipDashesString.append(str.charAt(i));
        }
      }
      return skipDashesString;
    }

    private StringBuilder getNextKGroup(StringBuilder str, int k) {

      int countNotDashes = 0;
      int i = 0;

      for (i = 0; i < str.length() && countNotDashes != k; i++) {
        if ('-' != str.charAt(i)) {
          countNotDashes++;
        }
      }
      return new StringBuilder(str.substring(0, i));
    }

    public String licenseKeyFormatting2(String S, int K) {
      String noDashesStr = deleteDashes(S.toUpperCase());
      String result = group(noDashesStr, K);

      return result;
    }

    private String deleteDashes(String str) {
      StringBuilder noDashes = new StringBuilder();
      for (String s : str.split("-")) {
        noDashes.append(s);
      }
      return noDashes.toString();
    }

    private String group(String str, int k) {
      StringBuilder resultString = new StringBuilder();
      str = new StringBuilder(str).reverse().toString();

      System.out.println("str.length = " + str.length());

      int i = 0;
      while (i + k < str.length()) {
        resultString.append(str.substring(i, i + k)).append("-");
        i = i + k;
      }

      if (i < str.length()) {
        resultString.append(str.substring(i, str.length()));
      } else if (i > 0) {
        resultString.deleteCharAt(str.length() - 1);
      }

      return resultString.reverse().toString();
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().licenseKeyFormatting2("5F3Z-2e-9-w", 4));
    System.out.println(new Solution().licenseKeyFormatting2("2-5g-3-J", 2));
    System.out.println(new Solution().licenseKeyFormatting2("5F3Z-2e-9-w", 1));
    System.out.println(new Solution().licenseKeyFormatting2("5F3Z-2e-9-w", 8));
    System.out.println(new Solution().licenseKeyFormatting2("---", 8));
  }
}
