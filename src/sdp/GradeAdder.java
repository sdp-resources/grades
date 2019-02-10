package sdp;

import java.util.List;

class GradeAdder {
  private double totalGradePoints = 0;
  private int courseCount = 0;
  private int inProgress = 0;

  public GradeAdder() { }

  public GradeAdder(List<Course> courses) {
    addCourses(courses);
  }

  public GradeAdder(Iterable<Grade> grades) {
    addAll(grades);
  }

  private void addCourses(List<Course> courses) {
    for (Course course : courses)
      add(course.grade);
  }

  void addAll(Iterable<Grade> grades) {
    for (Grade grade : grades)
      add(grade);
  }

  void add(Grade grade) {
    if (countsForGpa(grade)) {
      totalGradePoints += grade.toPoints();
      courseCount += 1;
    }
    if (isInProgress(grade))
      inProgress += 1;
  }

  private boolean countsForGpa(Grade grade) {
    return grade != Grade.W && grade != Grade.IP && grade != Grade.F;
  }

  private boolean isInProgress(Grade grade) {
    return grade == Grade.IP;
  }

  private double computeGradePointAverage() {
    return courseCount == 0 ? 0 : totalGradePoints / courseCount;
  }

  GradeSummary getSummary() {
    return new GradeSummary(courseCount, totalGradePoints, computeGradePointAverage(), inProgress);
  }
}