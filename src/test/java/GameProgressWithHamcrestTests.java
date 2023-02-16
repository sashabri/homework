import block3.unit3.task2and3.GameProgress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GameProgressWithHamcrestTests {
    static class TestData {
        String locationSave;
        GameProgress expectedGameProgress;

        public TestData(String locationSave, GameProgress expectedGameProgress) {
            this.locationSave = locationSave;
            this.expectedGameProgress = expectedGameProgress;
        }
    }

    public static List<GameProgressTests.TestData> sourceLocationSave() {
        List<GameProgressTests.TestData> result = new ArrayList<>();

        result.add(
                new GameProgressTests.TestData(
                        "E:\\desk top\\homework\\Games\\savegames\\save1.dat",
                        new GameProgress(45, 50, 30, 125.4)
                )
        );
        result.add(
                new GameProgressTests.TestData(
                        "E:\\desk top\\homework\\Games\\savegames\\save2.dat",
                        new GameProgress(47, 55, 31, 200.7)
                )
        );
        result.add(
                new GameProgressTests.TestData(
                        "E:\\desk top\\homework\\Games\\savegames\\save3.dat",
                        new GameProgress(50, 60, 32, 270.5)
                )
        );


        return result;
    }

    @ParameterizedTest
    @MethodSource("sourceLocationSave")
    public void TestOpenProgressWithParameters2(GameProgressTests.TestData testData) {


        // when:
        GameProgress actualGameProgress = block3.unit3.task2and3.Main.openProgress(testData.locationSave);

        // then:
        assertThat(testData.expectedGameProgress, samePropertyValuesAs(actualGameProgress));
    }

    @Test
    public void givenBean_whenHasCorrectValue_thenCorrect() {
        GameProgress gameProgress = new GameProgress(50, 60, 32, 270.5);
        assertThat(gameProgress, hasProperty("lvl", equalTo(32)));
    }

    @Test
    public void givenBean_whenHasValue_thenCorrect() {
        GameProgress gameProgress = new GameProgress(50, 60, 32, 270.5);
        assertThat(gameProgress, hasProperty("health"));
    }
}
