package sdp;

import java.util.Objects;

public class GradeSummary {
  public final double units;
  public final double totalPoints;
  public final double gpa;
  public final double inProgress;

  public GradeSummary(double units, double totalPoints, double gpa, double inProgress) {
    this.units = units;
    this.totalPoints = totalPoints;
    this.gpa = gpa;
    this.inProgress = inProgress;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GradeSummary that = (GradeSummary) o;
    return Double.compare(units, that.units) == 0 &&
        Double.compare(totalPoints, that.totalPoints) == 0 &&
        Double.compare(gpa, that.gpa) == 0 &&
        Double.compare(inProgress, that.inProgress) == 0;
  }

  public int hashCode() {

    return Objects.hash(units, totalPoints, gpa, inProgress);
  }

  @Override
  public String toString() {
    return "GradeSummary{" +
        "units=" + units +
        ", totalPoints=" + totalPoints +
        ", gpa=" + gpa +
        ", inProgress=" + inProgress +
        '}';
  }
}
