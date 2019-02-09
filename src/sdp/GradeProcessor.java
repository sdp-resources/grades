package sdp;

import java.util.ArrayList;
import java.util.List;

class GradeProcessor {
  final GradeAdder gradeAdder;
  private List<Course> courses = new ArrayList<>();

  public GradeProcessor() {
    this(new GradeAdder());
  }

  public GradeProcessor(GradeAdder adder) {
    gradeAdder = adder;
  }

  void addCourses(Iterable<Course> courses) {
    for (Course course : courses) {
      addCourse(course);
    }
  }

  public void addCourse(Course course) {
    courses.add(course);
    gradeAdder.add(course.getGrade());
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
