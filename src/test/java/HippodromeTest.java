import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;


import java.util.ArrayList;
import java.util.List;


public class HippodromeTest {

    private static final List<Horse> horses = new ArrayList<>();
    private final Hippodrome hippodrome = new Hippodrome(horses);

    @BeforeAll
    private static void  initializationsListHorses (){
        for (int i = 0; i < 30; i++){
            horses.add(new Horse("Stela " + i, i + 0.1, i + 0.2));
        }
    }

    @Test
    void HippodromeConstructorNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    void HippodromeConstructorNullMessageTest() {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null)).getMessage();
        Assertions.assertEquals("Horses cannot be null.", message);
    }

    @Test
    void HippodromeConstructorEmptyTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    }

    @Test
    void HippodromeConstructorEmptyMessageTest() {
        String message = Assertions.assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>())).getMessage();
        Assertions.assertEquals("Horses cannot be empty.", message);
    }

    @Test
    void HippodromeGetHorsesMethodsTest() {
        Assertions.assertArrayEquals(horses.toArray(), hippodrome.getHorses().toArray());
    }

    @Test
    void HippodromeGetMaxDistanceHorsesTested(){
        Assertions.assertEquals(horses.get(horses.size() - 1), hippodrome.getWinner());
    }
}
