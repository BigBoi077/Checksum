package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockTest {

    private BlockManager blockManager;

    public BlockTest() {
        this.blockManager = new BlockManager();
    }

    @Test
    public void testGetGridHeight() {
        assertEquals(1, blockManager.getNbrOfBlocks("joshua"));
        assertEquals(2, blockManager.getNbrOfBlocks("joshua leblanc"));
        assertEquals(2, blockManager.getNbrOfBlocks("bonjour le monde"));
        assertEquals(2, blockManager.getNbrOfBlocks("El Blanco"));
        assertEquals(3, blockManager.getNbrOfBlocks("Une planche de huit pied"));
        assertEquals(2, blockManager.getNbrOfBlocks("Miami palms"));
        assertEquals(4, blockManager.getNbrOfBlocks("Synthwave music is the best"));
        assertEquals(5, blockManager.getNbrOfBlocks("Please enter a string of characters : "));
    }
}
