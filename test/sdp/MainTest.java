package sdp;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MainTest {

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
    assertEquals(output, new CourseProcessor(new CourseLineParser(new Scanner(input))).reportAll());
  }

}
