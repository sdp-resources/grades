package sdp;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GradeAdderTest {

  @Test
  public void noCoursesResultInZeroGPA_AndZeroCount() {
    assertAdder_ResultsIn(
            new GradeAdder(),
            new GradeSummary(0, 0.00, 0.00));
  }

  @Test
  public void oneNormalCourseAddedResultsInThatGradeAsGPA_AndOneCourseCount() {
    for (Grade grade : Grade.values()) {
      if (grade.countsForGPA())
        assertAdder_ResultsIn(
            new GradeAdder(List.of(grade)),
            new GradeSummary(1, grade.toPoints(), grade.toPoints()));
      else
        assertAdder_ResultsIn(
            new GradeAdder(List.of(grade)),
            new GradeSummary(0, 0, 0));
    }
  }

  @Test
  public void twoCoursesAddedResultsInCombinedTotal_AndTwoCourseCount() {
    assertAdder_ResultsIn(
        new GradeAdder(List.of(Grade.A, Grade.B)),
        new GradeSummary(2, 7, 3.5));
  }

  @Test
  public void moreCoursesAddedResultsInCombinedTotal_AndAppropriateCourseCount() {
    assertAdder_ResultsIn(
        new GradeAdder(List.of(Grade.A, Grade.B, Grade.AMINUS, Grade.C)),
        new GradeSummary(4, (4 + 3 + 3.67 + 2), (4 + 3 + 3.67 + 2) / 4));
  }

  @Test
  public void withdrawnCoursesAreIgnored() {
    assertAdder_ResultsIn(
        new GradeAdder(List.of(Grade.A, Grade.W, Grade.B)),
        new GradeSummary(2, 7, 3.5));
  }

  private void assertAdder_ResultsIn(GradeAdder adder, GradeSummary gradeSummary) {
    assertEquals(gradeSummary, adder.getSummary());
  }

}
