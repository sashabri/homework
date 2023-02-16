package block3.unit1.task1;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    public Calculator() {}

    public BinaryOperator<Integer> plus = (x, y) -> x + y;
    public BinaryOperator<Integer> minus = (x, y) -> x - y;
    public BinaryOperator<Integer> multiply = (x, y) -> x * y;
    public BinaryOperator<Integer> devide = (x, y) -> {
       if (y == 0) {
           throw new IllegalArgumentException();
       }
        return x / y;
    };

    public UnaryOperator<Integer> pow = x -> x * x;
    public UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    public Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}
