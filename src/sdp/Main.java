package sdp;

import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(processGrades(scanner));
  }

  private static String processGrades(Scanner scanner) {
    double t = 0;
    int c = 0;
    while (scanner.hasNextLine()) {
      scanner.next("\\s*\\w+\\s*");
      scanner.next("\\s*\\w+\\s*");
      String l = scanner.next("[ABCDFW][+-]?");
      if (scanner.hasNextLine()) {
        scanner.nextLine();
      }
      switch (l) {
      case "A":
        t += 4.00;
        break;
      case "A-":
        t += 3.67;
        break;
      case "B+":
        t += 3.33;
        break;
      case "B":
        t += 3.00;
        break;
      case "B-":
        t += 2.67;
        break;
      case "C+":
        t += 2.33;
        break;
      case "C":
        t += 2.00;
        break;
      case "C-":
        t += 1.67;
        break;
      case "D+":
        t += 1.33;
        break;
      case "D":
        t += 1.00;
        break;
      case "F":
        t += 0.00;
        break;
      case "W":
        break;
      default:
        throw new RuntimeException();
      }
      if (!l.equals("W")) {
        c += 1;
      }
    }
    double gpa = c == 0 ? 0 : t / c;

    return String.format("Courses: %d\nGPA: %.2f\n", c, gpa);
  }

  @Test
  public void emptyGradeListReportsZeroGpaAndNoCourses() {
    assertTotalsOfList_Are("", "Courses: 0\nGPA: 0.00\n");
  }

  @Test
  public void singleCourseGradeReportsItself() {
    assertTotalsOfList_Are("CS 234        A ", "Courses: 1\nGPA: 4.00\n");
    assertTotalsOfList_Are("MAT    234    A-", "Courses: 1\nGPA: 3.67\n");
    assertTotalsOfList_Are("ENGR 121      B+", "Courses: 1\nGPA: 3.33\n");
    assertTotalsOfList_Are("CS 234         B", "Courses: 1\nGPA: 3.00\n");
    assertTotalsOfList_Are("CS 234        B-", "Courses: 1\nGPA: 2.67\n");
    assertTotalsOfList_Are("ENGR 011     C+ ", "Courses: 1\nGPA: 2.33\n");
    assertTotalsOfList_Are("ENGR 101      C ", "Courses: 1\nGPA: 2.00\n");
    assertTotalsOfList_Are("ENGR 101    C-\n", "Courses: 1\nGPA: 1.67\n");
    assertTotalsOfList_Are("ENGR 101      D+", "Courses: 1\nGPA: 1.33\n");
    assertTotalsOfList_Are("CS 122L        D", "Courses: 1\nGPA: 1.00\n");
    assertTotalsOfList_Are("CS 122L        F", "Courses: 1\nGPA: 0.00\n");
  }

  @Test
  public void multipleCoursesAreAllComputed() {
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B",
            "Courses: 2\nGPA: 3.50\n");
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B\nCS 122     B-\n",
            "Courses: 3\nGPA: 3.22\n");

  }

  @Test
  public void withdrawnCoursesDontCountTowardsCoursesTaken() {
    assertTotalsOfList_Are("CS 122L      W", "Courses: 0\nGPA: 0.00\n");
    assertTotalsOfList_Are(
            "CS 234        A \nMAT 111      B\nCS 122     W\n",
            "Courses: 2\nGPA: 3.50\n");
  }

  private void assertTotalsOfList_Are(String input, String output) {
    assertEquals(output, processGrades(new Scanner(input)));
  }
}
