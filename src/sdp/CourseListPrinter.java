package sdp;

import java.util.ArrayList;
import java.util.List;

public class CourseListPrinter {
  private List<Course> courses;
  private String formatString = "%s %s %s\n";

  public CourseListPrinter(List<Course> courses) {
    this.courses = courses;
    determineFormatList();
  }

  private void determineFormatList() {
    formatString =
            "%-" + getMaxPrefixLength() + "s " +
            "%-" + getMaxCodeLength() + "s %s\n";
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
    return String.format(formatString, course.deptPrefix, course.courseCode, course.grade);
  }

  private int getMaxPrefixLength() {
    return courses.stream()
            .map( c -> c.deptPrefix.length())
            .reduce(0, (x,y) -> Integer.max(x,y));
  }

  private int getMaxCodeLength() {
    return courses.stream()
            .map( c -> c.courseCode.length())
            .reduce(0, (x,y) -> Integer.max(x,y));
  }

}