package sdp;

import java.util.ArrayList;
import java.util.List;

public class CourseReporter {

  public String reportSummary(GradeSummary summary) {
    if (hasNonzeroInProgress(summary))
      return reportWithInProgress(summary);
    else
      return reportWithoutInProgress(summary);
  }

  private boolean hasNonzeroInProgress(GradeSummary summary) {
    return summary.inProgress > 0;
  }

  private String reportWithInProgress(GradeSummary summary) {
    return String.format("Courses: %d\nGPA: %.2f\nIn Progress: %s\n",
                         summary.courseCount, summary.gpa, summary.inProgress);
  }

  private String reportWithoutInProgress(GradeSummary summary) {
    return String.format("Courses: %d\nGPA: %.2f\n", summary.courseCount, summary.gpa);
  }

  public String reportCourseList(List<Course> courses) {
    String formatString = determineFormatForList(courses);
    StringBuilder sb = new StringBuilder();
    for (Course course : getAlphabeticallySortedCourses(courses)) {
      sb.append(formattedCourse(course, formatString));
    }
    return sb.toString();
  }

  private ArrayList<Course> getAlphabeticallySortedCourses(List<Course> courses) {
    ArrayList<Course> sortedCourses = new ArrayList<>(courses);
    sortedCourses.sort(Course.alphabeticalComparator());
    return sortedCourses;
  }

  private String determineFormatForList(List<Course> courses) {
    return "" +
        "%-" + getMaxPrefixLength(courses) + "s " +
        "%-" + getMaxCodeLength(courses) + "s %s\n";
  }

  private String formattedCourse(Course course, String formatString) {
    return String.format(formatString, course.deptPrefix, course.courseCode, course.grade);
  }

  private int getMaxPrefixLength(List<Course> courses) {
    return courses.stream()
        .map(c -> c.deptPrefix.length())
        .reduce(0, Integer::max);
  }

  private int getMaxCodeLength(List<Course> courses) {
    return courses.stream()
        .map(c -> c.courseCode.length())
        .reduce(0, Integer::max);
  }

}