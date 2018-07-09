package basics;

/**
 * Created by ypokhrel on 12/27/2017.
 */

public class compose_1 {
    public static void main(String[] args) {
        Function<Integer, Integer> triple = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg * 3;
            }
        };

        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg * arg;
            }
        };

        System.out.println(compose(triple, square).apply(3));
    }

    static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2){
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return f1.apply(f2.apply(arg));
            }
        };
    }
}
