package study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class StringCalculator {

  StringValidator stringValidator = new StringValidator();

  public int calculate(String stringFormula) {
    Optional<String> optionalFormula = Optional.ofNullable(stringFormula);
    optionalFormula.orElseThrow(() -> new IllegalArgumentException());

    if (stringValidator.validString(stringFormula) != null) {
      return stringValidator.validString(stringFormula);
    }
    String[] values = stringFormula.split(" ");

    Deque<Integer> numbers = new LinkedList<>();
    Queue<String> operations = new LinkedList<>();

    distinguishNumberAndOperation(values, numbers, operations);

    stringValidator.validNumbersAndOperations(numbers,operations);

    int result = 0;
    int size = operations.size();

    for ( int i = 0; i < size; i++ ) {
      result = operate(numbers, operations);
      numbers.addFirst(result);
    }

    return result;
  }

  private int operate(Deque<Integer> numbers, Queue<String> operations) {
    int x = numbers.poll();
    int y= numbers.poll();
    String operation = operations.poll();

    if (operation.equals("+")) {
      return (x + y);
    }
    if (operation.equals("-")) {
      return (x - y);
    }
    if (operation.equals("*")) {
      return (x * y);
    }
    if (operation.equals("/")) {
      return (x / y);
    }

    return 0;
  }

  private void distinguishNumberAndOperation(String[] values, Deque<Integer> numbers, Queue<String> operations) {
    for(String value : values) {
      distinguish(numbers, operations, value);
    }
  }

  private void distinguish(Deque<Integer> numbers, Queue<String> operations, String value) {
    if (stringValidator.isNumeric(value)) {
      numbers.offer(Integer.parseInt(value));
      return;
    }
    operations.offer(value);
  }
}
