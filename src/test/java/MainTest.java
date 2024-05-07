import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private List<BigInteger> numbers;

    public void setUp() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("summultest2.txt"));
        numbers = new ArrayList<>();

        while (scanner.hasNextBigInteger()) {
            numbers.add(scanner.nextBigInteger());
        }
    }

    @Test
    public void testMin() throws FileNotFoundException {
        setUp();
        BigInteger expected = new BigInteger("6");
        BigInteger actual = Main._min(numbers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMax() throws FileNotFoundException {
        setUp();
        BigInteger expected = new BigInteger("1337");
        BigInteger actual = Main._max(numbers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSum() throws FileNotFoundException {
        setUp();
        BigInteger expected = new BigInteger("2054");
        BigInteger actual = Main._sum(numbers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMult() throws FileNotFoundException {
        setUp();
        String expected = new String("8834147280");
        String actual = Main._mult(numbers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPerformance() throws FileNotFoundException { //тест на производительность (затрачиваемое время)
        setUp();
        long startTime = System.currentTimeMillis();
        Main._min(numbers);
        Main._max(numbers);
        Main._sum(numbers);
        Main._mult(numbers);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        Assertions.assertTrue(executionTime < 1000);
    }

    @Test
    public void testDataType() throws FileNotFoundException { //тест на корректность взятых из файла данных
        setUp();
        Object obj = numbers;
        assertTrue(obj instanceof ArrayList<?>);
    }
}
