package study;

public class StringCalculator {


  private boolean isNumeric(String value) {
    try {
      Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

}
