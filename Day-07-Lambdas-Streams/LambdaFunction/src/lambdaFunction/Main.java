package lambdaFunction;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //So Instead of creating the new class and extend the interface
        //java 8 introduce lambda function which helps to write
        //the logic of the functio without creating the object of the
        //class we can use the method of the interface
//        Walkable walk = new WalkFast();
//        walk.walk(10 , true);

        //same thing using the lambda expression
        Walkable obj = (steps , isEnabled) -> {
            System.out.println("You can walk fast");
            return 2 * steps;
        };

        obj.walk(20 , true);


        //Streams where we use lambdas heavily

        List<String> li = List.of("Apple" , "Banana" , "Watermelon");

        Stream<String> stream = li.stream();

        stream
                .filter(fruit -> fruit.length() > 5)
                .sorted()
                //.map(fruit -> fruit.length())
                .forEach(fruitLength -> System.out.println(fruitLength));

        //writing this kind of means we can comment any line in between the code
        //still code will works fine

        List<String> names = List.of("Ankush" , "Aman" , "Govind" , "Bhau" , "Dada");

        //This is the below way by which we can collect and convert the it
        //into any Collections of java using stream
        Map<String , Integer> mp = names
                .stream()
                .collect(Collectors.toMap(
                        fruit -> fruit,
                        friquency -> friquency.length()
                ));
        System.out.println(mp);
    }
}

interface Walkable{
    int walk(int steps , boolean isEnabled);
}

//class WalkFast implements Walkable{
//
//    @Override
//    public int walk(int steps, boolean isEnabled) {
//        System.out.println("You Can Walk Fast");
//        return 2*steps;
//    }
//}