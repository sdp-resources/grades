package sdp;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GradeAdderTest {

  @Test
  public void noCoursesResultInZeroGPA_AndZeroCount() {
    assertAdder_ResultsIn(
            new GradeAdder(),
            0, 0.00, 0.00);
  }

  @Test
  public void oneNormalCourseAddedResultsInThatGradeAsGPA_AndOneCourseCount() {
    for (Grade grade : Grade.values())
      assertAdder_ResultsIn(
              adderFrom(List.of(grade)),
              1, grade.toPoints(), grade.toPoints());
  }

  private GradeAdder adderFrom(Iterable<Grade> grades) {
    GradeAdder adder = new GradeAdder();
    adder.addAll(grades);

    return adder;
  }

  private void assertAdder_ResultsIn(GradeAdder adder, int courseCount, double totalPoints, double gpa) {
    assertEquals(courseCount, adder.getCourseCount());
    assertEquals(totalPoints, adder.getTotalGradePoints(), DELTA);
    assertEquals(gpa, adder.computeGradePointAverage(), DELTA);
  }

  private static final double DELTA = 0.00001;
}
