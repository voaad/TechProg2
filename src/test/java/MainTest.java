import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("minmaxtest100k.txt"));
        numbers = new ArrayList<>();

        while (scanner.hasNextBigInteger()) {
            numbers.add(scanner.nextBigInteger());
        }
    }

    @Test
    public void testMin() {
        BigInteger expected = new BigInteger("7");
        BigInteger actual = Main._min(numbers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMax() {
        BigInteger expected = new BigInteger("999995");
        BigInteger actual = Main._max(numbers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSum() {
        BigInteger expected = new BigInteger("49966043273");
        BigInteger actual = Main._sum(numbers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMult() {
        String expected = new String("Too big");
        String actual = Main._mult(numbers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPerformance() { //тест на производительность (затрачиваемое время)
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
    public void testDataType() { //тест на корректность взятых из файла данных
        Object obj = numbers;
        assertTrue(obj instanceof ArrayList<?>);
    }
}
