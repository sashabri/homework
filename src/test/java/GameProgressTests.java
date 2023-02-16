import block3.unit1.task1.Main;
import block3.unit3.task2and3.GameProgress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class GameProgressTests {

    static class TestData {
        String locationSave;
        GameProgress expectedGameProgress;

        public TestData(String locationSave, GameProgress expectedGameProgress) {
            this.locationSave = locationSave;
            this.expectedGameProgress = expectedGameProgress;
        }
    }

    public static List<TestData> sourceLocationSave() {
        List<TestData> result = new ArrayList<>();

        result.add(
                new TestData(
                        "E:\\desk top\\homework\\Games\\savegames\\save1.dat",
                        new GameProgress(45, 50, 30, 125.4)
                )
        );
        result.add(
                new TestData(
                        "E:\\desk top\\homework\\Games\\savegames\\save2.dat",
                        new GameProgress(47, 55, 31, 200.7)
                )
        );
        result.add(
                new TestData(
                        "E:\\desk top\\homework\\Games\\savegames\\save3.dat",
                        new GameProgress(50, 60, 32, 270.5)
                )
        );


        return result;
    }

    @ParameterizedTest
    @MethodSource("sourceLocationSave")
    public void TestOpenProgressWithParameters(TestData testData) {


        // when:
        GameProgress actualGameProgress = block3.unit3.task2and3.Main.openProgress(testData.locationSave);

        // then:
        Assertions.assertEquals(testData.expectedGameProgress, actualGameProgress, "Результат не совпал с ожидаемым");
    }
}
