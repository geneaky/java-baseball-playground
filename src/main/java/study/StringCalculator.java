package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringCalculator {


  private boolean isNumeric(String value) {
    try {
      Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  public int calculate(String stringFormula) {
    String[] values = stringFormula.split(" ");

    if (values.length == 1) {
      return verifyStringFormula(stringFormula);
    }

    if (values.length % 3 != 0) {
      throw new IllegalArgumentException();
    }

    Queue<Integer> numbers = new LinkedList<>();
    Queue<String> operations = new LinkedList<>();

    distinguishNumberAndOperation(values, numbers, operations);

    int result = 0;
    int size = operations.size();
    for ( int i = 0; i < size; i++ ) {
      result = operate(numbers, operations, result);
    }

    return result;
  }

  private int verifyStringFormula(String stringFormula) {
    if(isNumeric(stringFormula)) {
      return Integer.parseInt(stringFormula);
    }
    throw new IllegalArgumentException();
  }

  private int operate(Queue<Integer> numbers, Queue<String> operations, int result) {
    int x = numbers.poll();
    int y= numbers.poll();
    String operation = operations.poll();

    if ( operation.equals("+")) {
      result += (x + y);
    }
    return result;
  }

  private void distinguishNumberAndOperation(String[] values, Queue<Integer> numbers, Queue<String> operations) {
    for(String value : values) {
      distinguish(numbers, operations, value);
    }
  }

  private void distinguish(Queue<Integer> numbers, Queue<String> operations, String value) {
    if (isNumeric(value)) {
      numbers.offer(Integer.parseInt(value));
      return;
    }
    operations.offer(value);
  }
}
