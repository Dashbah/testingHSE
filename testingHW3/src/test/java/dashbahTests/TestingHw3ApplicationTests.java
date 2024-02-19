package dashbahTests;

import dashbah.AdvSqrt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestingHw3ApplicationTests {

    @Test
    public void testSqrtOfPositiveNumber() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result = advSqrt.sqrt(25.0);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testSqrtOfZero() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result = advSqrt.sqrt(0.0);
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testSqrtOfOne() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result = advSqrt.sqrt(1.0);
        assertEquals(1.0, result, 0.0001);
    }

    @Test
    public void testSqrtOfNegativeNumber() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result = advSqrt.sqrt(-25.0);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testSqrtOfNaN() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result = advSqrt.sqrt(Double.NaN);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testSqrtOfPositiveInfinity() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result = advSqrt.sqrt(Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0001);
    }

    @Test
    public void testSqrtOfNegativeInfinity() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result = advSqrt.sqrt(Double.NEGATIVE_INFINITY);
        assertTrue(Double.isNaN(result));
    }


    @Test
    public void testSqrtOfDenormalizedNumber() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result = advSqrt.sqrt(1.0e-300); // денормализованное число
        assertEquals(1.0e-150, result, 1.0e-160);
    }

    @Test
    public void testSqrtOfNumberNearBorderOfNormalizedAndDenormalized() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result = advSqrt.sqrt(2.0e-308); // число, близкое к границе
        assertEquals(4.47213595499958e-154, result, 1.0e-160);
    }

    @Test
    public void testSqrtOfDifferentNaN() {
        AdvSqrt advSqrt = new AdvSqrt();
        double quietNaN = Double.longBitsToDouble(0x7FF8000000000001L);
        double signalingNaN = Double.longBitsToDouble(0x7FF0000000000001L);
        assertTrue(Double.isNaN(advSqrt.sqrt(quietNaN)));
        assertTrue(Double.isNaN(advSqrt.sqrt(signalingNaN)));
    }

    @Test
    public void testRoundingOfResult() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result = advSqrt.sqrt(8.0); // квадратный корень из 8 - 2.82842712474619
        assertEquals(2.82842712474619, result, 0.00000000000001); // учитывая погрешность
    }

    @Test
    public void testSqrtOfExtremeValues() {
        AdvSqrt advSqrt = new AdvSqrt();
        double result1 = advSqrt.sqrt(Double.MIN_VALUE); // самое маленькое положительное число
        double result2 = advSqrt.sqrt(Double.MAX_VALUE); // самое большое положительное число
        assertEquals(0.0, result1, 0.0); // корень из самого маленького числа должен быть 0
        assertTrue(Double.isFinite(result2)); // корень из самого большого числа должен быть конечным
    }

}
