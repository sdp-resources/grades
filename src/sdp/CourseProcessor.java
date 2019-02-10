package sdp;

import java.util.ArrayList;
import java.util.List;

class CourseProcessor {

  private List<Course> courses = new ArrayList<>();

  public void addCourses(Iterable<Course> courses) {
    for (Course course : courses) {
      addCourse(course);
    }
  }

  public void addCourse(Course course) {
    courses.add(course);
  }

  public String reportCourseList() {
    return new CourseListPrinter().reportCourseList(courses);
  }

  public String reportTotals() {
    GradeAdder gradeAdder = new GradeAdder();
    for (Course course : courses) {
      gradeAdder.add(course.grade);
    }
    return gradeAdder.prepareReport();
  }

  public List<Course> getCourses() {
    return courses;
  }

  String reportAll() {
    return reportCourseList() + "---\n" + reportTotals();
  }
}
