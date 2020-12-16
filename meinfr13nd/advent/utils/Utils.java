package advent.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {
  public static Scanner filenameToScanner(String filename) throws FileNotFoundException {
    File f = new File(filename);
    return new Scanner(f);
  }
}
