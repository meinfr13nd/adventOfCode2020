package advent.day2;

import advent.utils.Utils;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part1 {

  private final static int MIN = 0;
  private final static int MAX = 1;
  private final static int COUNT = 2;
  private final static int WORD = 3;

  private static String solve(Scanner in) {
    int total = 0;
    while (in.hasNextLine()) {
      String line = in.nextLine();
      List<String> parts = Arrays.stream(line.split("-|\\ |:"))
        .filter(value -> !value.isEmpty())
        .collect(Collectors.toList());
      int min = Integer.valueOf(parts.get(MIN));
      int max = Integer.valueOf(parts.get(MAX));
      int count = 0;
      char toCount = parts.get(COUNT).charAt(0);
      String word = parts.get(WORD);
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == toCount) {
          count += 1;
          if (count > max) {
            break;
          }
        }
      }
      if (count <= max && count >= min) {
        total += 1;
      }
    }
    return String.valueOf(total);
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