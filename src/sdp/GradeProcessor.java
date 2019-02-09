package sdp;

class GradeProcessor {
  final GradeAdder gradeAdder = new GradeAdder();

  public void addGrades(Iterable<Grade> grades) {
    for (Grade grade : grades)
      addGrade(grade);
  }

  public void addGrade(Grade grade) {
    gradeAdder.add(grade);
  }

  public String reportTotals() {
    return gradeAdder.prepareReport();
  }

}
