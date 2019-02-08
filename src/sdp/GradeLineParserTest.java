package sdp;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GradeLineParserTest {
  @Test
  public void coursePrefixesCanBeParsed() {
    Scanner scanner = new Scanner("  CS   ");
    GradeLineParser parser = new GradeLineParser(scanner);
    String course = parser.readDeptPrefix();
    assertEquals("CS", course);
  }

  @Test
  public void courseNumbersCanBeParsed() {
    Scanner scanner = new Scanner("  CS   234 ");
    GradeLineParser parser = new GradeLineParser(scanner);
    parser.readDeptPrefix();
    String number = parser.readCourseNumber();
    assertEquals("234", number);
  }

  @Test
  public void nextLineReturnsRemainingOfCurrentLineThenSkipsNewline() {
    Scanner scanner = new Scanner(" CS  \n ");
    assertEquals("CS", scanner.next());
    assertEquals(true, scanner.hasNextLine());
    assertEquals("  ", scanner.nextLine());
    assertEquals(" ", scanner.nextLine());
  }
}
