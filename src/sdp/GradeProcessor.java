package sdp;

import java.util.Scanner;

class GradeProcessor {
  private Scanner scanner;
  private double totalGradePoints = 0;
  private int courseCount = 0;
  private Grade grade;

  public GradeProcessor(Scanner scanner) {
    this.scanner = scanner;
  }

  public String compute() {
    while (thereAreMoreCourses()) {
      readCourseCode();
      readLetterGrade();
      adjustCourseCountAndPoints();
      goToNextLine();
    }
    return prepareReport();
  }

  private boolean thereAreMoreCourses() {
    return scanner.hasNextLine();
  }

  private void readCourseCode() {
    scanner.next("\\s*\\w+\\s*");
    scanner.next("\\s*\\w+\\s*");
  }

  private void readLetterGrade() {
    String letterGrade = scanner.next("[ABCDFW][+-]?");
    grade = Grade.fromLetter(letterGrade);
  }

  private void goToNextLine() {
    if (scanner.hasNextLine()) {
      scanner.nextLine();
    }
  }

  private void adjustCourseCountAndPoints() {
    totalGradePoints += grade.toPoints();
    if (grade != Grade.W) {
      courseCount += 1;
    }
  }

  private String prepareReport() {
    double gradePointAverage = courseCount == 0 ? 0 : totalGradePoints / courseCount;

    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, gradePointAverage);
  }

}
