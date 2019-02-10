package sdp;

import java.util.ArrayList;
import java.util.List;

public class CourseListPrinter {
  private String formatString = "%s %s %s\n";

  public String reportSummary(GradeSummary summary) {
    return String.format("Courses: %d\nGPA: %.2f\n", summary.courseCount, summary.gpa);
  }

  private void determineFormatList(List<Course> courses) {
    formatString =
            "%-" + getMaxPrefixLength(courses) + "s " +
            "%-" + getMaxCodeLength(courses) + "s %s\n";
  }

  public String reportCourseList(List<Course> courses) {
    determineFormatList(courses);
    StringBuilder sb = new StringBuilder();
    for (Course course : getAlphabeticallySortedCourses(courses)) {
      sb.append(formattedCourse(course));
    }
    return sb.toString();
  }

  private ArrayList<Course> getAlphabeticallySortedCourses(List<Course> courses) {
    ArrayList<Course> sortedCourses = new ArrayList<>(courses);
    sortedCourses.sort(Course.alphabeticalComparator());
    return sortedCourses;
  }

  private String formattedCourse(Course course) {
    return String.format(formatString, course.deptPrefix, course.courseCode, course.grade);
  }

  private int getMaxPrefixLength(List<Course> courses) {
    return courses.stream()
            .map( c -> c.deptPrefix.length())
            .reduce(0, (x,y) -> Integer.max(x,y));
  }

  private int getMaxCodeLength(List<Course> courses) {
    return courses.stream()
            .map( c -> c.courseCode.length())
            .reduce(0, (x,y) -> Integer.max(x,y));
  }

}