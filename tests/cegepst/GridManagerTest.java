package cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridManagerTest {

    private GridManager gridManager;

    public GridManagerTest() {
        this.gridManager = new GridManager();
    }

    @Test
    public void testGetGridHeight() {
        assertEquals(1, gridManager.getNbrOfBlocks("joshua"));
        assertEquals(2, gridManager.getNbrOfBlocks("joshua leblanc"));
        assertEquals(2, gridManager.getNbrOfBlocks("bonjour le monde"));
        assertEquals(2, gridManager.getNbrOfBlocks("El Blanco"));
        assertEquals(3, gridManager.getNbrOfBlocks("Une planche de huit pied"));
        assertEquals(2, gridManager.getNbrOfBlocks("Miami palms"));
    }
}
