package sdp;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CourseReporterTest {
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

  @Test
  public void resultAddsSpacesToPropertyVerticallyAlignColumns() {
    assertAddedCoursesReportedAlphabetically(
            List.of(new Course("CS", "121C", Grade.BPLUS),
                    new Course("MAT", "121C", Grade.B)),
            "CS  121C B+\n" +
                    "MAT 121C B\n");
    assertAddedCoursesReportedAlphabetically(
            List.of(new Course("CS", "121L1", Grade.BPLUS),
                    new Course("MAT", "121C", Grade.B),
    new Course("HF", "101", Grade.AMINUS)),
            "CS  121L1 B+\n" +
                    "HF  101   A-\n" +
                    "MAT 121C  B\n");

  }

  private void assertAddedCoursesReportedAlphabetically(List<Course> courses, String output) {
    CourseProcessor processor = new CourseProcessor();
    processor.addCourses(courses);
    Assert.assertEquals(output, processor.reportCourseList());
  }
}