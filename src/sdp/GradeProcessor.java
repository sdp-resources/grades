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
    while (scanner.hasNextLine()) {
      scanner.next("\\s*\\w+\\s*");
      scanner.next("\\s*\\w+\\s*");
      String letterGrade = scanner.next("[ABCDFW][+-]?");
      if (scanner.hasNextLine()) {
        scanner.nextLine();
      }
      switch (letterGrade) {
      case "A":
        totalGradePoints += 4.00;
        break;
      case "A-":
        totalGradePoints += 3.67;
        break;
      case "B+":
        totalGradePoints += 3.33;
        break;
      case "B":
        totalGradePoints += 3.00;
        break;
      case "B-":
        totalGradePoints += 2.67;
        break;
      case "C+":
        totalGradePoints += 2.33;
        break;
      case "C":
        totalGradePoints += 2.00;
        break;
      case "C-":
        totalGradePoints += 1.67;
        break;
      case "D+":
        totalGradePoints += 1.33;
        break;
      case "D":
        totalGradePoints += 1.00;
        break;
      case "F":
        totalGradePoints += 0.00;
        break;
      case "W":
        break;
      default:
        throw new RuntimeException();
      }
      if (!letterGrade.equals("W")) {
        courseCount += 1;
      }
    }
    double gradePointAverage = courseCount == 0 ? 0 : totalGradePoints / courseCount;

    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, gradePointAverage);
  }
}
