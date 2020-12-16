package advent.day1;

import advent.utils.Utils;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Part1 {

  private static String solve(Scanner in) {
    Set<Integer> possibles = new HashSet<>();
    while (in.hasNextInt()) {
      Integer i = in.nextInt();
      Integer possible = 2020 - i;
      if (possibles.contains(i)) {
        return String.valueOf(i * possible);
      } else {
        possibles.add(possible);
      }
    }
    return "";
  }

  public static void main(String[] args) {
    for (String filename:args) {
      Scanner in;
      try {
        in = Utils.filenameToScanner(filename);
      } catch (FileNotFoundException e) {
        continue;
      }
      System.out.println(solve(in));
    }
  }
}