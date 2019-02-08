package sdp;

import java.util.Scanner;

public class GradeLineParser {
  Scanner scanner;

  public GradeLineParser() {
  }

  boolean thereAreMoreCourses() {
    return getScanner().hasNextLine();
  }

  void readCourseCode() {
    getScanner().next("\\s*\\w+\\s*");
    getScanner().next("\\s*\\w+\\s*");
  }

  Grade readLetterGrade() {
    String letterGrade = getScanner().next("[ABCDFW][+-]?");
    return Grade.fromLetter(letterGrade);
  }

  void goToNextLine() {
    if (getScanner().hasNextLine()) {
      getScanner().nextLine();
    }
  }

  public Scanner getScanner() {
    return scanner;
  }

  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }
}