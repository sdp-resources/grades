package sdp;

import java.util.Comparator;
import java.util.Objects;

public class Course {
  public final String deptPrefix;
  public final String courseCode;
  public final Grade grade;

  public Course(String deptPrefix, String courseCode, Grade grade) {
    this.deptPrefix = deptPrefix;
    this.courseCode = courseCode;
    this.grade = grade;
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

  public static Comparator<? super Course> alphabeticalComparator() {
    return (Comparator<Course>) (c1, c2) -> {
      if (c1.deptPrefix.equals(c2.deptPrefix))
        return c1.courseCode.compareTo(c2.courseCode);

      return c1.deptPrefix.compareTo(c2.deptPrefix);
    };
  }
}
