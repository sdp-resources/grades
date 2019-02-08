package sdp;

import java.util.Scanner;

class GradeProcessor {
  private Scanner scanner;
  private double totalGradePoints = 0;
  private int courseCount = 0;
  private Grade grade;

  public GradeProcessor() {

  }

  static GradeProcessor newProcessorWithScanner(Scanner scanner) {
    GradeProcessor gradeProcessor = new GradeProcessor();
    gradeProcessor.setScanner(scanner);
    return gradeProcessor;
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
    return getScanner().hasNextLine();
  }

  private void readCourseCode() {
    getScanner().next("\\s*\\w+\\s*");
    getScanner().next("\\s*\\w+\\s*");
  }

  private void readLetterGrade() {
    String letterGrade = getScanner().next("[ABCDFW][+-]?");
    grade = Grade.fromLetter(letterGrade);
  }

  private void goToNextLine() {
    if (getScanner().hasNextLine()) {
      getScanner().nextLine();
    }
  }

  private void adjustCourseCountAndPoints() {
    totalGradePoints += grade.toPoints();
    if (grade.countsForGPA()) {
      courseCount += 1;
    }
  }

  private String prepareReport() {
    double gradePointAverage = courseCount == 0 ? 0 : totalGradePoints / courseCount;

    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, gradePointAverage);
  }

  public Scanner getScanner() {
    return scanner;
  }

  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }
}
