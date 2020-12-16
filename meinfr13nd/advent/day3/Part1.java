package advent.day3;

import advent.utils.Utils;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Part1 {

  private final static char TREE = '#';
  private final static int RSLOPE = 3;

  private static String solve(Scanner in) {
    int total = 0;
    int currentX = 0;
    while (in.hasNextLine()) {
      String line = in.nextLine();
      if (line.charAt(currentX) == TREE) {
        total += 1;
      }
      currentX = (currentX + RSLOPE) % line.length();
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