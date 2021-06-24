package info.jab.reactive.ch0.euler;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

/**
 * Problem 20: Factorial digit sum
 * n! means n (n 1) ... 3 2 1
 *
 * For example, 10! = 10   9   ...   3   2   1 = 3628800,
 *
 * and the sum of the digits in the number 10! is
 * 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 */
public class EulerProblem20 {

    /*
     * Old-school testing ;)
     */
    public static void main(String[] args) {
        // Non-Blocking way - NOT IN USE
        // factorial(100).subscribe(result -> System.out.println(result.toString().chars().mapToLong(Character::getNumericValue).sum()));
        // factorial(10).subscribe(result -> System.out.println(result.toString().chars().mapToLong(Character::getNumericValue).sum()));

        // Blocking way - NOT IN USE
        // System.out.print(factorial(10).block().toString().chars().mapToLong(Character::getNumericValue).sum());
        // System.out.print(factorial(100).block().toString().chars().mapToLong(Character::getNumericValue).sum());
    }

    public Mono<Long> ReactorSolution(Long limit) {
            return Flux.range(1,limit.intValue()).map(BigDecimal::valueOf).reduce((x, y) -> x.multiply(y))
                    .map(x -> x.toString().chars().mapToLong(Character::getNumericValue).sum());
    }

    /*
     * Method to calculate factorial
     *
     */
    @Deprecated
    private static Mono<BigDecimal> factorial(Integer number) {
        return Flux.range(1,number).map(BigDecimal::valueOf).reduce((x, y) -> x.multiply(y));
    }

}
