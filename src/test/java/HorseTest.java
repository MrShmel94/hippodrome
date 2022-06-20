import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class HorseTest {

    private final Horse horse = new Horse("Stela", 31.0, 2.5);

    @Test
    void HorseConstructorNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(null, 2.5));
    }

    @Test
    void HorseConstructorNullMessageTest() {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(null, 2.1)).getMessage();
        Assertions.assertEquals("Name cannot be null.", message);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "\t"})
    void HorseConstructorArgumentTest(String s) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(s, 2.5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n", "\t"})
    void HorseConstructorArgumentMessageTest(String s) {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(s, 2.5)).getMessage();
        Assertions.assertEquals("Name cannot be blank.", message);
    }

    @Test
    void HorseConstructorNegativeValueSecondParameterTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Stela", -1));
    }

    @Test
    void HorseConstructorNegativeValueSecondParameterMessageTest() {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Stela", -1)).getMessage();
        Assertions.assertEquals("Speed cannot be negative.", message);
    }

    @Test
    void HorseConstructorNegativeValueThirdParameterTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Stela", 1, -1));
    }

    @Test
    void HorseConstructorNegativeValueThirdParameterMessageTest() {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse("Stela", 1, -1)).getMessage();
        Assertions.assertEquals("Distance cannot be negative.", message);
    }

    @Test
    void HorseGetNameTest() {
        Assertions.assertEquals("Stela", horse.getName());
    }

    @Test
    void HorseGetSpeedTest() {
        Assertions.assertEquals(31.0 , horse.getSpeed());
    }

    @Test
    void HorseGetDistanceTest() {
        Assertions.assertEquals(2.5, horse.getDistance());
    }

    @Test
    void HorseGetMoveTest() {
        try (MockedStatic <Horse> horseMockedStatic = Mockito.mockStatic(Horse.class)){
            horseMockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.7);
            horse.move();
            horseMockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.8, 0.6, 0.3})
    void HorseMoveExpectedDistanceTest (double value) {
        try (MockedStatic <Horse> horseMockedStatic = Mockito.mockStatic(Horse.class)) {
            horseMockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(value);
            horse.move();
            Assertions.assertEquals(2.5 + 31 * value, horse.getDistance());
        }
    }

}
