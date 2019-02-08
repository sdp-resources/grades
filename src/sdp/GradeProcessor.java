package sdp;

import java.util.Scanner;

class GradeProcessor {
  private Scanner scanner;
  private double totalGradePoints = 0;
  private int courseCount = 0;

  public GradeProcessor(Scanner scanner) {
    this.scanner = scanner;
  }

  public String compute() {
    while (thereAreMoreCourses()) {
      readCourseCode();
      String letterGrade = readLetterGrade();
      goToNextLine();
      adjustCourseCountAndPoints(letterGrade);
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

  private String readLetterGrade() {
    return scanner.next("[ABCDFW][+-]?");
  }

  private void goToNextLine() {
    if (scanner.hasNextLine()) {
      scanner.nextLine();
    }
  }

  private void adjustCourseCountAndPoints(String letterGrade) {
    totalGradePoints += getGradePointsForLetter(letterGrade);
    if (!letterGrade.equals("W")) {
      courseCount += 1;
    }
  }

  private String prepareReport() {
    double gradePointAverage = courseCount == 0 ? 0 : totalGradePoints / courseCount;

    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, gradePointAverage);
  }

  private double getGradePointsForLetter(String letterGrade) {
    double gradePointsForLetter;
    switch (letterGrade) {
    case "A":
      gradePointsForLetter = 4.00;
      break;
    case "A-":
      gradePointsForLetter = 3.67;
      break;
    case "B+":
      gradePointsForLetter = 3.33;
      break;
    case "B":
      gradePointsForLetter = 3.00;
      break;
    case "B-":
      gradePointsForLetter = 2.67;
      break;
    case "C+":
      gradePointsForLetter = 2.33;
      break;
    case "C":
      gradePointsForLetter = 2.00;
      break;
    case "C-":
      gradePointsForLetter = 1.67;
      break;
    case "D+":
      gradePointsForLetter = 1.33;
      break;
    case "D":
      gradePointsForLetter = 1.00;
      break;
    case "F":
      gradePointsForLetter = 0.00;
      break;
    case "W":
      gradePointsForLetter = 0.00;
      break;
    default:
      throw new RuntimeException();
    }
    return gradePointsForLetter;
  }
}
