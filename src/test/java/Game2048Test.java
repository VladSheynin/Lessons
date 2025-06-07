import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class Game2048Test {

    @InjectMocks
    private Game2048 instant;

    @Mock
    private GameHelper gameHelper;

    @BeforeEach
    public void setup() {
        Mockito.reset(gameHelper);
        instant.init();
    }

    @Test
    void addItem() {

        Mockito.when(gameHelper.moveAndMergeEqual(anyList())).thenReturn(List.of(1, 2, 3, 4));
        Boolean flagResult = instant.move(Direction.UP);
        assertEquals(true, flagResult);
        verify(gameHelper, times(1)).moveAndMergeEqual(anyList());

    }

    @Test
    void addItemOnce() {
        Mockito.when(gameHelper.moveAndMergeEqual(anyList())).thenReturn(List.of(1, 2, 3, 4));
        Boolean flagResult = instant.move(Direction.UP);
        assertEquals(true, flagResult);
    }
}