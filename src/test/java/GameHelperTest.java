import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

class GameHelperTest {

    private final GameHelper gameHelper = new GameHelper();

    @Test
    void moveAndMergeEqualTest() {
        Assertions.assertEquals(asList(4, 2, 4, 2), gameHelper.moveAndMergeEqual(Arrays.asList(4, 2, 4, 2)));
        Assertions.assertEquals(asList(4, 4, 4, null), gameHelper.moveAndMergeEqual(Arrays.asList(4, 2, 2, 4)));
        Assertions.assertEquals(List.of(4), gameHelper.moveAndMergeEqual((Arrays.asList(4))));
        Assertions.assertEquals(List.of(), gameHelper.moveAndMergeEqual(Arrays.asList()));
        Assertions.assertEquals(asList(4, 4, 2, null), gameHelper.moveAndMergeEqual(Arrays.asList(4, 2, 2, 2)));
        Assertions.assertEquals(asList(8, 4, null, null), gameHelper.moveAndMergeEqual(Arrays.asList(4, 4, 2, 2)));
        Assertions.assertEquals(asList(4, 4, null, null), gameHelper.moveAndMergeEqual(Arrays.asList(2, 2, 2, 2)));
        Assertions.assertEquals(asList(4, 2, 4, 4, null), gameHelper.moveAndMergeEqual(Arrays.asList(4, 2, 4, 2, 2)));
        Assertions.assertEquals(asList(4, null, null, null), gameHelper.moveAndMergeEqual(new ArrayList<Integer>(Arrays.asList(null, 2, 2, null))));
        Assertions.assertEquals(List.of(), gameHelper.moveAndMergeEqual(new ArrayList<Integer>(Arrays.asList(null, null, null, null))));
    }
}