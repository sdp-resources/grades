package sdp;

class GradeProcessor {
  private Iterable<Grade> grades;
  private double totalGradePoints = 0;
  private int courseCount = 0;
  private double gradePointAverage;

  public GradeProcessor(Iterable<Grade> grades) {
    this.grades = grades;
  }

  public String compute() {
    for (Grade grade : grades)
      adjustCourseCountAndPoints(grade);

    computeGradePointAverage();
    return prepareReport();
  }

  private void adjustCourseCountAndPoints(Grade grade) {
    if (grade.countsForGPA()) {
      totalGradePoints += grade.toPoints();
      courseCount += 1;
    }
  }

  private String prepareReport() {
    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, gradePointAverage);
  }

  private void computeGradePointAverage() {
    gradePointAverage = courseCount == 0 ? 0 : totalGradePoints / courseCount;
  }

}
