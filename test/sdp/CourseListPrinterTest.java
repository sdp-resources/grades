package sdp;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CourseListPrinterTest {
  @Test
  public void reportCourseListContainsIncludedCoursesInAlphabeticalOrder() {
    assertAddedCoursesReportedAlphabetically(List.of(), "");
    assertAddedCoursesReportedAlphabetically(
            List.of(new Course("CS", "121C", Grade.BPLUS)),
            "CS 121C B+\n");
    assertAddedCoursesReportedAlphabetically(
            List.of(new Course("MA", "111L", Grade.CMINUS),
                    new Course("CS", "121C", Grade.BPLUS)),
            "CS 121C B+\nMA 111L C-\n");
    assertAddedCoursesReportedAlphabetically(
            List.of(new Course("CS", "131L", Grade.CMINUS),
                    new Course("CS", "121C", Grade.BPLUS),
                    new Course("CS", "021C", Grade.BPLUS)),
            "CS 021C B+\nCS 121C B+\nCS 131L C-\n");
  }

  private void assertAddedCoursesReportedAlphabetically(List<Course> courses, String output) {
    CourseProcessor processor = new CourseProcessor();
    processor.addCourses(courses);
    Assert.assertEquals(output, processor.reportCourseList());
  }
}