package sdp;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CourseProcessorTest {
  @Test
  public void coursesCanBeAdded() {
    assertCoursesAddedInSomeOrder(
            List.of(new Course("CS", "234", Grade.AMINUS)));
    assertCoursesAddedInSomeOrder(
            List.of(new Course("CS", "234", Grade.AMINUS),
                    new Course("MAT", "121C", Grade.BPLUS)));
  }

  private void assertCoursesAddedInSomeOrder(List<Course> expectedCourses) {
    assertEqualAsSets(expectedCourses, new CourseProcessor(expectedCourses).getCourses());
  }

  private void assertEqualAsSets(List<Course> expected, List<Course> actual) {
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

}