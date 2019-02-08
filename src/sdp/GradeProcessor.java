package sdp;

class GradeProcessor {
  private Iterable<Grade> grades;
  private double totalGradePoints = 0;
  private int courseCount = 0;

  public GradeProcessor(Iterable<Grade> grades) {
    this.grades = grades;
  }

  public String compute() {
    for (Grade grade : grades)
      adjustCourseCountAndPoints(grade);

    return prepareReport();
  }

  private void adjustCourseCountAndPoints(Grade grade) {
    totalGradePoints += grade.toPoints();
    if (grade.countsForGPA()) {
      courseCount += 1;
    }
  }

  private String prepareReport() {
    double gradePointAverage = courseCount == 0 ? 0 : totalGradePoints / courseCount;

    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, gradePointAverage);
  }

}
