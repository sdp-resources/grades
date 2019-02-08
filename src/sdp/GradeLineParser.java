package sdp;

import java.util.Scanner;

public class GradeLineParser {
  Scanner scanner;

  public GradeLineParser(Scanner scanner) {
    this.scanner = scanner;
  }

  boolean thereAreMoreCourses() {
    return scanner.hasNextLine();
  }

  void readCourseCode() {
    scanner.next("\\s*\\w+\\s*");
    scanner.next("\\s*\\w+\\s*");
  }

  Grade readLetterGrade() {
    String letterGrade = scanner.next("[ABCDFW][+-]?");
    return Grade.fromLetter(letterGrade);
  }

  void goToNextLine() {
    if (scanner.hasNextLine()) {
      scanner.nextLine();
    }
  }

}