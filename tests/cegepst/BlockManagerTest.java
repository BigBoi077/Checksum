package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockManagerTest {

    private BlockManager blockManager;

    public BlockManagerTest() {
        this.blockManager = new BlockManager();
    }

    @Test
    public void testGetNbrBlocks() {
        assertEquals(1, blockManager.getNbrOfBlocks("joshua"));
        assertEquals(2, blockManager.getNbrOfBlocks("joshua leblanc"));
        assertEquals(2, blockManager.getNbrOfBlocks("bonjour le monde"));
        assertEquals(2, blockManager.getNbrOfBlocks("El Blanco"));
        assertEquals(3, blockManager.getNbrOfBlocks("Une planche de huit pied"));
        assertEquals(2, blockManager.getNbrOfBlocks("Miami palms"));
        assertEquals(4, blockManager.getNbrOfBlocks("Synthwave music is the best"));
        assertEquals(5, blockManager.getNbrOfBlocks("Please enter a string of characters : "));
        assertEquals(2, blockManager.getNbrOfBlocks("igqHMg80zT5XdVFU"));
    }

    @Test
    public void testGetNbrBlocksForString() {
        assertEquals(1, blockManager.getNbrOfBlocksForString("011010100011011110011100111011010001000000000000000000000000000000000000000111100"));
        assertEquals(2, blockManager.getNbrOfBlocksForString("011010100011011110011100111011010001011101011011000011001000001011011000010001100011001010011000101011011000011000011011011101011000110000000000000000000000001110"));
        assertEquals(3, blockManager.getNbrOfBlocksForString("011010100011011110011100111011010001000000000000000000000000000000000000000111100011010100011011110011100111011010001011101011011000011001000001011011000010001100011001010011000101011011000011000011011011101011000110000000000000000000000001110"));
    }
}
