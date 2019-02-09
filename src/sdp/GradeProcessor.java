package sdp;

class GradeProcessor {
  final GradeAdder gradeAdder = new GradeAdder();

  public void addGrades(Iterable<Grade> grades) {
    for (Grade grade : grades)
      gradeAdder.add(grade);
  }

  String reportTotals() {
    return gradeAdder.prepareReport();
  }

}
