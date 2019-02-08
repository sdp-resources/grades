package sdp;

import java.util.Iterator;
import java.util.Scanner;

public class GradeLineParser implements Iterable<Grade> {
  Scanner scanner;

  public GradeLineParser(Scanner scanner) {
    this.scanner = scanner;
  }

  boolean thereAreMoreCourses() {
    return scanner.hasNext();
  }

  String readCourseCode() {
    String s = readDeptPrefix();
    s += readCourseNumber();
    return s;
  }

  public String readCourseNumber() {
    return scanner.next();
  }

  public String readDeptPrefix() {
    return scanner.next();
  }

  Grade readLetterGrade() {
    String letterGrade = scanner.next("[ABCDFW][+-]?");
    return Grade.fromLetter(letterGrade);
  }

  public Iterator<Grade> iterator() {
    return new Iterator<>() {

      public boolean hasNext() {
        return thereAreMoreCourses();
      }

      public Grade next() {
        readCourseCode();
        Grade grade = readLetterGrade();

        return grade;
      }
    };
  }

}