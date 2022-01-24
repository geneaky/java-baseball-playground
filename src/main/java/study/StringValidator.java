package study;

public class StringValidator {

  public Integer valid(String stringFormula) {
    String[] values = stringFormula.split(" ");
    if (values.length == 1) {
      return verifyStringFormula(stringFormula);
    }

    if (values.length % 3 != 0) {
      throw new IllegalArgumentException();
    }

    if (!isNumeric(values[0])) {
      throw new IllegalArgumentException();
    }
    return null;
  }

  private int verifyStringFormula(String stringFormula) {
    if(isNumeric(stringFormula)) {
      return Integer.parseInt(stringFormula);
    }
    throw new IllegalArgumentException();
  }

  public boolean isNumeric(String value) {
    try {
      Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
