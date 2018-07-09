package basics;

/**
 * Created by ypokhrel on 12/27/2017.
 */
public class higherOrderFunction_1 {

    static Function<Function<Integer, Integer>,
                        Function<Function<Integer, Integer>,
                                Function<Integer, Integer>>> compose = x -> y -> z -> x.apply(y.apply(z));

    public static void main(String[] args) {
        Function<Integer, Integer> triple = x -> x*3;
        Function<Integer, Integer> square = x -> x*x;
        Function<Integer, Integer> f = compose.apply(square).apply(triple);

        System.out.println(f.apply(3));
    }
}
