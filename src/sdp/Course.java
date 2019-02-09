package sdp;

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
  public String toString() {
    return String.format("Course<%s %s: %s>", deptPrefix, courseCode, grade);
  }
}
