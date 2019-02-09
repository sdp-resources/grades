package sdp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class CourseProcessorTest {
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
    assertAddedCoursesProduceGrades(
            List.of(new Course("CS", "121", Grade.B)),
            List.of(Grade.B));
    assertAddedCoursesProduceGrades(
            List.of(new Course("CS", "121", Grade.B),
                    new Course("MAT", "121C", Grade.BPLUS)),
            List.of(Grade.B, Grade.BPLUS));
  }

  private void assertAddedCoursesProduceGrades(List<Course> courses, List<Grade> grades) {
    GradeAdderSpy adder = new GradeAdderSpy();
    CourseProcessor processor = new CourseProcessor(adder);
    processor.addCourses(courses);
    assertEquals(grades, adder.recordedGrades);
  }

  private void assertCoursesAddedInSomeOrder(List<Course> expectedCourses) {
    CourseProcessor processor = processorWithCourses(expectedCourses);
    assertEqualAsSets(expectedCourses, processor.getCourses());
  }

  private CourseProcessor processorWithCourses(List<Course> expectedCourses) {
    CourseProcessor processor = new CourseProcessor();
    processor.addCourses(expectedCourses);
    return processor;
  }

  private void assertEqualAsSets(List<Course> expected, List<Course> actual) {
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  private class GradeAdderSpy extends GradeAdder {
    List<Grade> recordedGrades = new ArrayList<>();

    @Override
    void add(Grade grade) {
      super.add(grade);
      recordedGrades.add(grade);
    }
  }
}