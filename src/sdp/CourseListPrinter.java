package sdp;

import java.util.ArrayList;
import java.util.List;

public class CourseListPrinter {
  private List<Course> courses;

  public CourseListPrinter(List<Course> courses) {
    this.courses = courses;
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