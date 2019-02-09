package sdp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GradeAdderTest {
  @Test
  public void noCoursesResultInZeroGPA_AndZeroCount() {
    GradeAdder adder = new GradeAdder();
    assertEquals(0, adder.getCourseCount());
    assertEquals(0.00, adder.computeGradePointAverage(), 0.00001);
  }

  @Test
  public void oneNormalCourseAddedResultsInThatGradeAsGPA_AndOneCourseCount() {
    for (Grade grade : Grade.values()) {
      GradeAdder adder = new GradeAdder();
      adder.add(grade);
      assertEquals(1, adder.getCourseCount());
      assertEquals(grade.toPoints(), adder.getTotalGradePoints(), 0.00001);
      assertEquals(grade.toPoints(), adder.computeGradePointAverage(), 0.00001);
    }

  }
}
