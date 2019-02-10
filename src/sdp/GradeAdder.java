package sdp;

import java.util.List;

class GradeAdder {
  private double totalGradePoints = 0;
  private int courseCount = 0;

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
    if (grade.countsForGPA())
      adjustAmountsFor(grade);
  }

  private void adjustAmountsFor(Grade grade) {
    totalGradePoints += grade.toPoints();
    courseCount += 1;
  }

  private double computeGradePointAverage() {
    return courseCount == 0 ? 0 : totalGradePoints / courseCount;
  }

  GradeSummary getSummary() {
    return new GradeSummary(courseCount, totalGradePoints, computeGradePointAverage());
  }
}