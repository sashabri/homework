package block3.unit1.task1;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    Calculator() {}

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> {
        int result = 0;
        try {
            result = x / y;
        } catch (Exception e) {
            System.out.println("Ошибка деления");
        }
        return result;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}