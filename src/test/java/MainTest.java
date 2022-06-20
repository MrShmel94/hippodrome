import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.runner.JUnitCore;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainTest {

    @Test
    @Timeout(value = 21, unit = TimeUnit.SECONDS)
    @Disabled
    public void timeOutMainTest (){
        try {
            Main.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Assertions.assertTimeout(Duration.ofSeconds(21), () -> {Main.main();
//        });
    }
}
