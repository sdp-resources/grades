package sdp;

import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

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
  public void emptySpaceLinesAtEndAreHandled() {
    assertTotalsOfList_Are("CS 234        A \n  ", "Courses: 1\nGPA: 4.00\n");
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

  @Test
  public void fullReportIncludesBothCourseListAndTotals() {
    assertFullReportForInput_Is(
        "" +
            "CS 234        A \n" +
            "MAT    234    A-\n" +
            "ENGR 121L      B+\n" +
            "CS 134         B",
        "" +
            "CS   134  B\n" +
            "CS   234  A\n" +
            "ENGR 121L B+\n" +
            "MAT  234  A-\n" +
            "---\n" +
            "Courses: 4\n" +
            "GPA: 3.50\n");

  }

  private void assertFullReportForInput_Is(String input, String output) {
    assertEquals(output, processorWithProcessedInput(input).reportAll());
  }

  private void assertTotalsOfList_Are(String input, String output) {
    assertEquals(output, processorWithProcessedInput(input).reportTotals());
  }

  private CourseProcessor processorWithProcessedInput(String input) {
    return new CourseProcessor(new CourseLineParser(new Scanner(input)));
  }

}
