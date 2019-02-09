package sdp;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(processCourses(scanner));
  }

  protected static String processCourses(Scanner scanner) {
    CourseProcessor courseProcessor = new CourseProcessor();
    courseProcessor.addCourses(new CourseLineParser(scanner));
    return courseProcessor.reportTotals();
  }
}
