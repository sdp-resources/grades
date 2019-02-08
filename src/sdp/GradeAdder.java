package sdp;

class GradeAdder {
  private double totalGradePoints = 0;
  private int courseCount = 0;
  private double gradePointAverage;


  void computeGradePointAverage() {
    gradePointAverage = courseCount == 0 ? 0 : totalGradePoints / courseCount;
  }

  void add(Grade grade) {
    totalGradePoints += grade.toPoints();
    courseCount += 1;
  }

  String prepareReport() {
    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, gradePointAverage);
  }
}