package sdp;

public enum Grade {
  A      ("A", 4.00),
  AMINUS ("A-", 3.67),
  BPLUS  ("B+", 3.33),
  B      ("B", 3.00),
  BMINUS ("B-", 2.67),
  CPLUS  ("C+", 2.33),
  C      ("C", 2.00),
  CMINUS ("C-", 1.67),
  DPLUS  ("D+", 1.33),
  D      ("D", 1.00),
  F      ("F", 0.00),
  W      ("W", 0.00);

  private final String letter;

  private final double points;
  Grade(String letter, double points) {
    this.letter = letter;
    this.points = points;
  }

  public static Grade fromLetter(String letterGrade) {
    switch (letterGrade) {
    case "A":  return A;
    case "A-": return AMINUS;
    case "B+": return BPLUS;
    case "B": return B;
    case "B-": return BMINUS;
    case "C+": return CPLUS;
    case "C": return C;
    case "C-": return CMINUS;
    case "D+": return DPLUS;
    case "D": return D;
    case "F": return F;
    case "W": return W;
    default:
      throw new RuntimeException();
    }
  }

  boolean countsForGPA() {
    return this != W;
  }

  public String toString() {
    return letter;
  }

  public double toPoints() {
    return points;
  }
}
