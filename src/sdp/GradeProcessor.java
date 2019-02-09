package sdp;

import java.util.ArrayList;
import java.util.List;

class GradeProcessor {
  final GradeAdder gradeAdder = new GradeAdder();
  private List<Course> courses = new ArrayList<>();

  public void addCourse(Course course) {
    courses.add(course);
  }

  public void addGrades(Iterable<Grade> grades) {
    for (Grade grade : grades)
      addGrade(grade);
  }

  public void addGrade(Grade grade) {
    gradeAdder.add(grade);
  }

  public String reportTotals() {
    return gradeAdder.prepareReport();
  }

  public List<Course> getCourses() {
    return courses;
  }
}
