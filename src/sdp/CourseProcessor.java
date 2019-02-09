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

  public String reportTotals() {
    return gradeAdder.prepareReport();
  }

  public List<Course> getCourses() {
    return courses;
  }

  public String reportCourseList() {
    StringBuilder sb = new StringBuilder();
    for (Course course : getAlphabeticallySortedCourses()) {
      sb.append(formattedCourse(course));
    }
    return sb.toString();
  }

  private ArrayList<Course> getAlphabeticallySortedCourses() {
    ArrayList<Course> sortedCourses = new ArrayList<>(courses);
    sortedCourses.sort(Course.alphabeticalComparator());
    return sortedCourses;
  }

  private String formattedCourse(Course course) {
    return String.format("%s %s %s\n", course.deptPrefix, course.courseCode, course.grade);
  }
}
