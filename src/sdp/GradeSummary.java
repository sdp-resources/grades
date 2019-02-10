package sdp;

import java.util.Objects;

public class GradeSummary {
  public final int courseCount;
  public final double totalPoints;
  public final double gpa;

  public GradeSummary(int courseCount, double totalPoints, double gpa) {
    this.courseCount = courseCount;
    this.totalPoints = totalPoints;
    this.gpa = gpa;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GradeSummary that = (GradeSummary) o;
    return courseCount == that.courseCount &&
        Double.compare(that.totalPoints, totalPoints) == 0 &&
        Double.compare(that.gpa, gpa) == 0;
  }

  public int hashCode() {

    return Objects.hash(courseCount, totalPoints, gpa);
  }
}
