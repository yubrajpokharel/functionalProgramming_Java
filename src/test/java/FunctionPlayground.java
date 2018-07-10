import basics.Function;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;

public class FunctionPlayground {

  public interface BinaryOperator extends Function<Integer, Function<Integer, Integer>> {

  }

  @Test
  public void test_addFunction(){
    Function<Integer, Function<Integer, Integer>> adder = x -> y -> x + y;
    BinaryOperator addOp = x -> y -> x + y;
    BinaryOperator multOp = x -> y -> x * y;

    BiFunction<Integer, Integer, Integer> add2 = (x , y) -> x + y;


    assertEquals(Integer.valueOf(8), adder.apply(3).apply(5));
    assertEquals(Integer.valueOf(8), addOp.apply(3).apply(5));
    assertEquals(Integer.valueOf(15), multOp.apply(3).apply(5));
  }
}
