package sdp;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(processCourses(scanner));
  }

  protected static String processCourses(Scanner scanner) {
    GradeProcessor gradeProcessor = new GradeProcessor();
    gradeProcessor.addCourses(new GradeLineParser(scanner));
    return gradeProcessor.reportTotals();
  }
}
