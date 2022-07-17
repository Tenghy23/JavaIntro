package Java_Intro;

import java.util.*;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // print to console
        System.out.println("Hello world!");

        // console.writeline, input/output
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in username");
        // String input = scanner.next();
        // System.out.println("output is: " + input);

        // hashmap = dictionary
        Map<String, String> countryToCapital = new HashMap<>();
        countryToCapital.put("Germany", "Berlin");
        System.out.println(countryToCapital.get("Germany"));

        // ArrayList for storing and accessing data, and LinkedList to manipulate data.
        // arrayList<T> = List<T>
        var questionList = new ArrayList<>();
        questionList.add("test question 1");
        questionList.add(25);
        System.out.println(questionList.size());
        System.out.println(questionList.get(0));
        System.out.println(questionList.get(1));

        // SETS = collection that contain no duplicate
        var usernames = new HashSet<>();
        usernames.add("joe");
        System.out.println(usernames.add("hi"));
        System.out.println(usernames.add("hi"));

        // classes
        Dog doggo1 = new Dog("doggo pic1", "name1", 1);
        Dog doggo2 = new Dog("doggo pic", "name", 12);
        Cat catto1 = new Cat("catto pic", "name", 2);
        doggo1.makeSound();
        catto1.makeSound();
        doggo2.setAge(2);
        doggo1.pet();
        catto1.pet();
        System.out.println(doggo2.getAge());

        // ENUM
        var difficulty = Enum.EASY;
        advEnum tier = advEnum.DIAMOND;
        System.out.println(tier.getAttackMultiplier());

        // TRY CATCH EXCEPTIONS
        Scanner scanner1 = new Scanner(System.in);
        int i = scanner1.nextInt();

        try {
            checkForZero(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally");
        }

        // lambda expressions, Java Functional Interfaces
        // supplier, consumer, callable, runnable, function
        // https://www.swtestacademy.com/java-functional-interfaces/

        // supplier: does not allow input, it returns a value based on a defined type
        // used more in forge (e.g. delay load in certain var)
        Supplier<Integer> supplier = () -> { return 10; };
        System.out.println(supplier.get());

        // Consumer: takes an input, it does not return a value
        Consumer<String> consumer = (s) -> { System.out.println(s); };
        // BiConsumer takes two parameters and does not return anything!
        BiConsumer<Integer, Integer> powConsumer = (base, power) -> System.out.println(Math.pow(base, power));
        consumer.accept("Hello World");

        // Callable: no parameter, and return value
        // similar to supplier, but it throws exception
        Callable<Float> callable = () -> { return 100f / 0f; };

        // Runnable: no parameters, no return value
        Runnable runnable = () -> { System.out.println("Hello World again"); };
        runnable.run();

        // Function: has parameter, and return value
        // BiFunction Interface takes two inputs rather than one input
        Function<Double, Double> function = (r) -> { return r * 3.14159265; };
        System.out.println(function.apply(10.0));
        //BiFunction Example (Input Type, Input Type, Return Type)
        BiFunction<Integer, Integer, Integer> powerOf = (base, power) -> (int) Math.pow(base, power);

        // Generics
        Pair<Integer, ?> test = new Pair<>(2008, 50.55f);
    }

    private static void checkForZero(int num) throws TestException {
        if (num == 0) {
            throw new TestException("NUMBER IS ZERO");
        }
    }
}