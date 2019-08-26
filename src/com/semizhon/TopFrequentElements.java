package com.semizhon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFrequentElements {
  private class FrequencyPair {
    int number;
    int frequency;

    FrequencyPair(int number, int frequency) {
      this.number = number;
      this.frequency = frequency;
    }
  }

  private Map<Integer, Integer> getFrequency(int[] nums) {
    Map<Integer, Integer> elementsFrequency = new HashMap<Integer, Integer>();
    for (int number : nums) {
      int frequency = 1;
      if (elementsFrequency.containsKey(number)) {
        frequency = elementsFrequency.get(number) + 1;
      }

      elementsFrequency.put(number, frequency);
    }

    return elementsFrequency;
  }

  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> elementsFrequency = getFrequency(nums);

    PriorityQueue<FrequencyPair> heap =
        new PriorityQueue<FrequencyPair>(
            new Comparator<FrequencyPair>() {
              public int compare(FrequencyPair x, FrequencyPair y) {
                if (x.frequency > y.frequency) {
                  return 1;
                } else if (x.frequency == y.frequency) {
                  return 0;
                } else {
                  return -1;
                }
              }
            });

    for (Map.Entry<Integer, Integer> pair : elementsFrequency.entrySet()) {
      heap.add(new FrequencyPair(pair.getKey(), pair.getValue()));
    }

    List<Integer> result = new ArrayList<Integer>();

    for (int i = 0; i < k; i++) {
      result.add(heap.poll().number);
    }

    return result;
  }

  public static void main(String[] args) {
    // [1,1,1,2,3,3,3]
    TopFrequentElements top = new TopFrequentElements();
    top.topKFrequent(new int[] {1, 1, 1, 2, 3, 3, 3}, 2);
  }
}
