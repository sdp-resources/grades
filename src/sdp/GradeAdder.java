package sdp;

class GradeAdder {
  private double totalGradePoints = 0;
  private int courseCount = 0;

  double computeGradePointAverage() {
    return courseCount == 0 ? 0 : totalGradePoints / courseCount;
  }

  void addAll(Iterable<Grade> grades) {
    for (Grade grade : grades)
      add(grade);
  }

  void add(Grade grade) {
    if (grade.countsForGPA())
      adjustAmountsFor(grade);
  }

  private void adjustAmountsFor(Grade grade) {
    totalGradePoints += grade.toPoints();
    courseCount += 1;
  }

  double getTotalGradePoints() {
    return totalGradePoints;
  }

  int getCourseCount() {
    return courseCount;
  }

  String prepareReport() {
    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, computeGradePointAverage());
  }
}