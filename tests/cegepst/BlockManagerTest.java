package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockManagerTest {

    private BlockManager gridManager;

    public BlockManagerTest() {
        this.gridManager = new BlockManager();
    }

    @Test
    public void testGetGridHeight() {
        assertEquals(1, gridManager.getNbrOfBlocks("joshua"));
        assertEquals(2, gridManager.getNbrOfBlocks("joshua leblanc"));
        assertEquals(2, gridManager.getNbrOfBlocks("bonjour le monde"));
        assertEquals(2, gridManager.getNbrOfBlocks("El Blanco"));
        assertEquals(3, gridManager.getNbrOfBlocks("Une planche de huit pied"));
        assertEquals(2, gridManager.getNbrOfBlocks("Miami palms"));
        assertEquals(4, gridManager.getNbrOfBlocks("Synthwave music is the best"));
        assertEquals(5, gridManager.getNbrOfBlocks("Please enter a string of characters : "));
    }
}
