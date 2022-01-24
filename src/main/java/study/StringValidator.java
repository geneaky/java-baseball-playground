package study;

import java.util.Deque;
import java.util.Queue;

public class StringValidator {

  public Integer validString(String stringFormula) {
    String[] values = stringFormula.split(" ");
    if (values.length == 1) {
      return verifyStringFormula(stringFormula);
    }

    if (values.length < 3) {
      throw new IllegalArgumentException();
    }

    if (!isNumeric(values[0]) || !isNumeric(values[values.length-1])) {
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

  public void validNumbersAndOperations(Deque<Integer> numbers, Queue<String> operations) {
    if(operations.size() >= numbers.size()) {
      throw new IllegalArgumentException();
    }
  }
}
