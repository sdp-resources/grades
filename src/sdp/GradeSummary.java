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
    return closeEnough(units, that.units) &&
        closeEnough(totalPoints, that.totalPoints) &&
        closeEnough(gpa, that.gpa) &&
        closeEnough(inProgress, that.inProgress);
  }

  private boolean closeEnough(double d1, double d2) {
    return Math.abs(d1- d2) < 0.00001;
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
