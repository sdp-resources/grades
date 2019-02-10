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
    return new CourseReporter().reportCourseList(courses);
  }

  public String reportTotals() {
    return new CourseReporter().reportSummary(getSummary());
  }

  private GradeSummary getSummary() {
    return new GradeAdder(courses).getSummary();
  }

  public List<Course> getCourses() {
    return courses;
  }

  String reportAll() {
    return reportCourseList() + "---\n" + reportTotals();
  }
}
