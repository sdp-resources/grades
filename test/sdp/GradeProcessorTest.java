package sdp;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class GradeProcessorTest {
  @Test
  public void coursesCanBeAdded() {
    assertCoursesAddedInSomeOrder(
            List.of(new Course("CS", "234", Grade.AMINUS)));
    assertCoursesAddedInSomeOrder(
            List.of(new Course("CS", "234", Grade.AMINUS),
                    new Course("MAT", "121C", Grade.BPLUS)));
  }

  @Test
  public void addedCoursesContributeToTotals() {
    GradeProcessor processor = processorWithCourses(
            List.of(new Course("CS", "121", Grade.B)));
  }

  private void assertCoursesAddedInSomeOrder(List<Course> expectedCourses) {
    GradeProcessor processor = processorWithCourses(expectedCourses);
    assertEqualAsSets(expectedCourses, processor.getCourses());
  }

  private GradeProcessor processorWithCourses(List<Course> expectedCourses) {
    GradeProcessor processor = new GradeProcessor();
    for (Course course : expectedCourses)
      processor.addCourse(course);
    return processor;
  }

  private void assertEqualAsSets(List<Course> expected, List<Course> actual) {
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }
}