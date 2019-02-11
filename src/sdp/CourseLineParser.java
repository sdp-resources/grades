package sdp;

import java.util.Iterator;
import java.util.Scanner;

public class CourseLineParser implements Iterable<Course> {
  private Scanner scanner;

  public CourseLineParser(Scanner scanner) {
    this.scanner = scanner;
  }

  boolean thereAreMoreCourses() {
    return scanner.hasNext();
  }

  public Course readCourse() {
    String deptPrefix = readDeptPrefix();
    String courseCode = readCourseNumber();
    double units = readUnitsIfPresent();
    Grade grade = readLetterGrade();

    return new Course(deptPrefix, courseCode, grade, units);
  }

  public String readDeptPrefix() {
    return scanner.next();
  }

  public String readCourseNumber() {
    return scanner.next();
  }

  private double readUnitsIfPresent() {
    return scanner.hasNextDouble() ? scanner.nextDouble() : 1;
  }

  Grade readLetterGrade() {
    String letterGrade = scanner.next("[ABCD][+-]?|[WF]|(IP)");
    return Grade.fromLetter(letterGrade);
  }

  public Iterator<Course> iterator() {
    return new Iterator<>() {

      public boolean hasNext() {
        return thereAreMoreCourses();
      }

      public Course next() {
        return readCourse();
      }
    };
  }
}