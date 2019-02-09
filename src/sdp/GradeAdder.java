package sdp;

class GradeAdder {
  private double totalGradePoints = 0;
  private int courseCount = 0;

  public double computeGradePointAverage() {
    return courseCount == 0 ? 0 : totalGradePoints / courseCount;
  }

  void add(Grade grade) {
    totalGradePoints += grade.toPoints();
    courseCount += 1;
  }

  void addAll(Iterable<Grade> grades) {
    for (Grade grade : grades)
      add(grade);
  }

  public double getTotalGradePoints() {
    return totalGradePoints;
  }

  public int getCourseCount() {
    return courseCount;
  }

  String prepareReport() {
    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, computeGradePointAverage());
  }
}