package sdp;

import java.util.ArrayList;
import java.util.List;

class CourseProcessor {
  private final GradeAdder gradeAdder;
  private List<Course> courses = new ArrayList<>();

  public CourseProcessor() {
    this(new GradeAdder());
  }

  public CourseProcessor(GradeAdder adder) {
    gradeAdder = adder;
  }

  public void addCourses(Iterable<Course> courses) {
    for (Course course : courses) {
      addCourse(course);
    }
  }

  public void addCourse(Course course) {
    courses.add(course);
    gradeAdder.add(course.grade);
  }

  public String reportCourseList() {
    return new CourseListPrinter(courses).reportCourseList();
  }

  public String reportTotals() {
    return gradeAdder.prepareReport();
  }

  public List<Course> getCourses() {
    return courses;
  }

  String reportAll() {
    return reportCourseList() + "---\n" + reportTotals();
  }
}
