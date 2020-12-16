package advent.day3;

import advent.utils.Utils;
import org.javatuples.Pair;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

  private final static char TREE = '#';
  private final static List<Pair<Integer, Integer>> SLOPES = List.of(
      Pair.with(1, 1),
      Pair.with(3, 1),
      Pair.with(5, 1),
      Pair.with(7, 1),
      Pair.with(1, 2)
    );


  private static String solve(Scanner in) {
    List<String> lines = new ArrayList<>();
    while (in.hasNextLine()) {lines.add(in.nextLine());}
    long multipliedTotal = 1;
    for (Pair<Integer, Integer> slope : SLOPES) {
      long total = 0;
      int currentX = 0;
      int currentYOffset = 0;
      for (String line : lines) {
        if (currentYOffset % slope.getValue1() != 0) {
          currentYOffset += 1;
          continue;
        }
        if (line.charAt(currentX) == TREE) {
          total += 1;
        }
        currentX = (currentX + slope.getValue0()) % line.length();
        currentYOffset += 1;
      }
      multipliedTotal *= total;
    }
    return String.valueOf(multipliedTotal);
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