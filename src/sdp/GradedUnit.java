package sdp;

public interface GradedUnit {
  Grade getGrade();

  double getUnits();

  default double toPoints() {
    return getGrade().toPoints();
  }
}
