package sdp;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(processGrades(scanner));
  }

  protected static String processGrades(Scanner scanner) {
    GradeProcessor gradeProcessor = new GradeProcessor();
    gradeProcessor.addGrades(new GradeLineParser(scanner));
    return gradeProcessor.prepareReport();
  }
}
