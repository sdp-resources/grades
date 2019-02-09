package sdp;

import java.util.Objects;

public class Course {
  private final String deptPrefix;
  private final String courseCode;
  private final Grade grade;

  public Course(String deptPrefix, String courseCode, Grade grade) {
    this.deptPrefix = deptPrefix;
    this.courseCode = courseCode;
    this.grade = grade;
  }

  public String getDeptPrefix() {
    return deptPrefix;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public Grade getGrade() {
    return grade;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return Objects.equals(deptPrefix, course.deptPrefix) &&
            Objects.equals(courseCode, course.courseCode) &&
            grade == course.grade;
  }

  @Override
  public int hashCode() {

    return Objects.hash(deptPrefix, courseCode, grade);
  }

  @Override
  public String toString() {
    return String.format("Course<%s %s: %s>", deptPrefix, courseCode, grade);
  }
}
