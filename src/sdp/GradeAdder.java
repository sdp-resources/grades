package sdp;

import java.util.ArrayList;
import java.util.List;

class GradeAdder {
  public static final List<Grade> NO_GPA_GRADES = List.of(Grade.W, Grade.IP, Grade.F, Grade.S, Grade.U);
  public static final List<Grade> NO_CREDIT_GRADES = List.of(Grade.W, Grade.IP, Grade.F, Grade.U);
  private double totalGradePoints = 0;
  private double gpaAffectingUnits = 0;
  private double inProgressUnits = 0;
  private double creditBearingUnits;

  public GradeAdder() { }

  public GradeAdder(List<? extends GradedUnit> courses) {
    addGradedUnits(courses);
  }

  public GradeAdder(Iterable<Grade> grades) {
    addGradedUnits(gradedUnitsFromGrades(grades));
  }

  private void addGradedUnits(List<? extends GradedUnit> gradedUnits) {
    for (GradedUnit gradedUnit : gradedUnits)
      add(gradedUnit);
  }

  void add(GradedUnit gradedUnit) {
    countForGpaIfEligible(gradedUnit);
    countForGraduationIfEligible(gradedUnit);
    countForInProgressIfEligible(gradedUnit);
  }

  private void countForGpaIfEligible(GradedUnit gradedUnit) {
    if (countsForGpa(gradedUnit)) {
      totalGradePoints += gradedUnit.toPoints() * gradedUnit.getUnits();
      gpaAffectingUnits += gradedUnit.getUnits();
    }
  }

  private void countForGraduationIfEligible(GradedUnit gradedUnit) {
    if (countsForGraduation(gradedUnit))
      creditBearingUnits += gradedUnit.getUnits();
  }

  private void countForInProgressIfEligible(GradedUnit gradedUnit) {
    if (isInProgress(gradedUnit))
      inProgressUnits += gradedUnit.getUnits();
  }

  private boolean countsForGraduation(GradedUnit gradedUnit) {
    return !NO_CREDIT_GRADES.contains(gradedUnit.getGrade());
  }

  private boolean countsForGpa(GradedUnit gradedUnit) {
    return !NO_GPA_GRADES.contains(gradedUnit.getGrade());
  }

  private boolean isInProgress(GradedUnit gradedUnit) {
    return gradedUnit.getGrade() == Grade.IP;
  }

  private double computeGradePointAverage() {
    return gpaAffectingUnits == 0 ? 0 : totalGradePoints / gpaAffectingUnits;
  }

  GradeSummary getSummary() {
    return new GradeSummary(creditBearingUnits, totalGradePoints, computeGradePointAverage(), inProgressUnits);
  }

  private ArrayList<GradedUnit> gradedUnitsFromGrades(Iterable<Grade> grades) {
    ArrayList<GradedUnit> gradesWithUnits = new ArrayList<>();
    for (Grade grade : grades) {
      gradesWithUnits.add(new SimpleOneUnitGrade(grade));
    }
    return gradesWithUnits;
  }

  private class SimpleOneUnitGrade implements GradedUnit {

    private Grade grade;

    public SimpleOneUnitGrade(Grade grade) {
      this.grade = grade;
    }

    public Grade getGrade() {
      return grade;
    }

    public double getUnits() {
      return 1;
    }
  }
}