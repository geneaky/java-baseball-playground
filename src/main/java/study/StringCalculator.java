package study;

import java.util.LinkedList;
import java.util.Queue;

public class StringCalculator {

  StringValidator stringValidator = new StringValidator();

  public int calculate(String stringFormula) {
    String[] values = stringFormula.split(" ");

    if (stringValidator.valid(stringFormula) != null) {
      return stringValidator.valid(stringFormula);
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
    if (stringValidator.isNumeric(value)) {
      numbers.offer(Integer.parseInt(value));
      return;
    }
    operations.offer(value);
  }
}
