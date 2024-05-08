import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("summultest.txt"));
        List<BigInteger> numbers = new ArrayList<>();

        while (scanner.hasNextBigInteger()) {
            numbers.add(scanner.nextBigInteger());
        }

        System.out.println(_min(numbers));
        System.out.println(_max(numbers));
        System.out.println(_sum(numbers));
        System.out.println(_mult(numbers));
    }

    public static BigInteger _min(List<BigInteger> numbers) {
        BigInteger min = numbers.get(0);
        for (BigInteger num : numbers) {
            if (num.compareTo(min) < 0) {
                min = num;
            }
        }
        return min;
    }

    public static BigInteger _max(List<BigInteger> numbers) {
        BigInteger max = numbers.get(0);
        for (BigInteger num : numbers) {
            if (num.compareTo(max) > 0) {
                max = num;
            }
        }
        return max;
    }

    public static BigInteger _sum(List<BigInteger> numbers) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger num : numbers) {
            sum = sum.add(num);
        }
        return sum;
    }

    public static String _mult(List<BigInteger> numbers) {
        BigInteger mult = BigInteger.ONE;
        BigInteger limit = new BigInteger("10").pow(64);
        for (BigInteger num : numbers) {
            mult = mult.multiply(num);
            if (mult.compareTo(limit) > 0) {
                return "Too big";
            }
        }
        return mult.toString();
    }
}
