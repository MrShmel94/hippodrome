import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HorseTest {

    private final Horse horse = new Horse("Stela", 2.0, 2.5);

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
    @ValueSource(strings = {"", " ", "\n"})
    void HorseConstructorArgumentTest(String s) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Horse(s, 2.5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
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
        Assertions.assertEquals(2.0 , horse.getSpeed());
    }

    @Test
    void HorseGetDistanceTest() {
        Assertions.assertEquals(2.5, horse.getDistance());
    }

    @Test
    void HorseGetMoveTest() {
        try (MockedStatic <Horse> horseMockedStatic = Mockito.mockStatic(Horse.class)){
            Mockito.verify(horse).move();
        }
    }
}
