package com.semizhon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

  private Set<String> dictionarySet = new HashSet<String>();

  public boolean wordBreak(String s, List<String> wordDict) {

    dictionarySet.addAll(wordDict);

    return isInDisctionary(s);
  }

  private boolean isInDisctionary(String s) {

    boolean result = false;
    if (dictionarySet.contains(s)) {
      return true;
    }

    for (int i = s.length(); i > 0 && !result; i--) {
      if (dictionarySet.contains(s.substring(0, i))) {
        if (dictionarySet.contains(s.substring(i, s.length()))) {

          result = true;
        } else {
          result = isInDisctionary(s.substring(i, s.length()));
        }
      }
    }

    return result;
  }

  public boolean wordBreak2(String s, List<String> dict) {
    Set<String> dictionarySet = new HashSet<String>();
    dictionarySet.addAll(dict);

    boolean[] f = new boolean[s.length() + 1];
    f[0] = true;

    for (int i = 0; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {

        if (f[j] && dictionarySet.contains(s.substring(j, i))) {

          f[i] = true;
          break;
        }
      }
    }

    return f[s.length()];
  }
}
