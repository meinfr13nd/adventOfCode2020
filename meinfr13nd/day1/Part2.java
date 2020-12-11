package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part2 {

  private static String solve(Scanner in) {
    List<Integer> expenses = new ArrayList<>();
    while (in.hasNextInt()) {
      expenses.add(in.nextInt());
    }
    // n^3, not ideal
    for (int i = 0; i < expenses.size(); i++) {
      for (int j = 0; j < expenses.size(); j++) {
        for (int k = 0; k < expenses.size(); k++) {
          if (i != j && i != k && j != k) {
            if (expenses.get(i) + expenses.get(j) + expenses.get(k) == 2020) {
              return String.valueOf(expenses.get(i) * expenses.get(j) * expenses.get(k));
            }
          }
        }
      }
    }
    return "";
  }

  public static void main(String[] args) {
    for (String filename : args) {
      File f = new File(filename);
      Scanner in;
      try {
        in = new Scanner(f);
      } catch (FileNotFoundException e) {
        continue;
      }
      System.out.println(solve(in));
    }
  }
}