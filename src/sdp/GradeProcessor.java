package sdp;

import java.util.Scanner;

class GradeProcessor {
  private GradeLineParser gradeLineParser;
  private double totalGradePoints = 0;
  private int courseCount = 0;

  public GradeProcessor(GradeLineParser gradeLineParser) {
    this.gradeLineParser = gradeLineParser;
  }

  static GradeProcessor newProcessorWithScanner(Scanner scanner) {
    return new GradeProcessor(new GradeLineParser(scanner));
  }

  public String compute() {
    while (gradeLineParser.thereAreMoreCourses()) {
      gradeLineParser.readCourseCode();
      Grade processedGrade = gradeLineParser.readLetterGrade();
      adjustCourseCountAndPoints(processedGrade);
      gradeLineParser.goToNextLine();
    }
    return prepareReport();
  }

  private void adjustCourseCountAndPoints(Grade grade) {
    totalGradePoints += grade.toPoints();
    if (grade.countsForGPA()) {
      courseCount += 1;
    }
  }

  private String prepareReport() {
    double gradePointAverage = courseCount == 0 ? 0 : totalGradePoints / courseCount;

    return String.format("Courses: %d\nGPA: %.2f\n", courseCount, gradePointAverage);
  }

}
