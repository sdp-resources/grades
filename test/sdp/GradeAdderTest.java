package sdp;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GradeAdderTest {

  @Test
  public void noCoursesResultInZeroGPA_AndZeroCount() {
    assertAdder_ResultsIn(
            new GradeAdder(),
            new GradeSummary(0, 0.00, 0.00, 0));
  }

  @Test
  public void oneNormalCourseAddedResultsInThatGradeAsGPA_AndOneCourseCount() {
    for (Grade grade : Grade.values()) {
      if (!GradeAdder.NO_GPA_GRADES.contains(grade))
        assertAdder_ResultsIn(
            new GradeAdder(List.of(grade)),
            new GradeSummary(1, grade.toPoints(), grade.toPoints(), 0));
    }
  }

  @Test
  public void twoCoursesAddedResultsInCombinedTotal_AndTwoCourseCount() {
    assertAdder_ResultsIn(
        new GradeAdder(List.of(Grade.A, Grade.B)),
        new GradeSummary(2, 7, 3.5, 0));
  }

  @Test
  public void moreCoursesAddedResultsInCombinedTotal_AndAppropriateCourseCount() {
    assertAdder_ResultsIn(
        new GradeAdder(List.of(Grade.A, Grade.B, Grade.AMINUS, Grade.C)),
        new GradeSummary(4, (4 + 3 + 3.67 + 2), (4 + 3 + 3.67 + 2) / 4, 0));
  }

  @Test
  public void withdrawnCoursesAreIgnored() {
    assertAdder_ResultsIn(
        new GradeAdder(List.of(Grade.A, Grade.W, Grade.B)),
        new GradeSummary(2, 7, 3.5, 0));
  }

  @Test
  public void nonCreditGradesDontGiveCredit() {
    assertAdder_ResultsIn(
        new GradeAdder(List.of(Grade.W, Grade.F)),
        new GradeSummary(0, 0, 0, 0));
  }

  @Test
  public void forGraduationCoursesCountAsCoursesButNotForGpa() {
    assertAdder_ResultsIn(
        new GradeAdder(List.of(Grade.A, Grade.S)),
        new GradeSummary(2, 4, 4, 0));
    assertAdder_ResultsIn(
        new GradeAdder(List.of(Grade.A, Grade.U)),
        new GradeSummary(1, 4, 4, 0));
  }

  @Test
  public void coursesContributeWeightBasedOnTheirUnits() {
    assertAdder_ResultsIn(
        new GradeAdder(List.of(new Course("Full", "", Grade.A),
                               new Course("Half", "", Grade.B, 0.5))),
        new GradeSummary(1.5, 5.5, 3.67, 0));
  }

  @Test
  public void inProgressCoursesReportedOnSeparateCount() {
    assertAdder_ResultsIn(
        new GradeAdder(List.of(Grade.A, Grade.IP)),
        new GradeSummary(1, 4, 4, 1));
  }

  private void assertAdder_ResultsIn(GradeAdder adder, GradeSummary gradeSummary) {
    assertEquals(gradeSummary, adder.getSummary());
  }

}
