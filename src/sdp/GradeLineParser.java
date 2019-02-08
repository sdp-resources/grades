package sdp;

import java.util.Iterator;
import java.util.Scanner;

public class GradeLineParser implements Iterable<Grade> {
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

  public Iterator<Grade> iterator() {
    return new Iterator<>() {

      public boolean hasNext() {
        return thereAreMoreCourses();
      }

      public Grade next() {
        readCourseCode();
        Grade processedGrade = readLetterGrade();
        goToNextLine();

        return processedGrade;
      }
    };
  }
}