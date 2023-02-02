import com.codurance.GameOfLife;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeShould {

//    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    @Test
    void kill_cell_if_it_has_zero_neighbor(){
        boolean[][] board = {
                {false, false, false},
                {false, true, false},
                {false, false, false}
        };

        GameOfLife game = new GameOfLife(board);
        game.nextGen();
        boolean cellNextState = game.cellStateAt(1, 1);

        assertEquals(false, cellNextState);

    }

}