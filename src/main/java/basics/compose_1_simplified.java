package basics;

/**
 * Created by ypokhrel on 12/27/2017.
 */
public class compose_1_simplified {
    public static void main(String[] args) {
        Function<Integer, Integer> triple = x -> x*3;
        Function<Integer, Integer> square = x -> x*x;

        System.out.println(compose(triple, square).apply(3));

    }

    static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2){
        return arg -> f1.apply(f2.apply(arg));
    }
}
