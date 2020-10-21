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
        assertEquals(7, gridManager.getGridHeight("joshua"));
        assertEquals(16, gridManager.getGridHeight("joshua leblanc"));
        assertEquals(18, gridManager.getGridHeight("bonjour le monde"));
        assertEquals(10, gridManager.getGridHeight("El Blanco"));
        assertEquals(27, gridManager.getGridHeight("Une planche de huit pied"));
        assertEquals(13, gridManager.getGridHeight("Miami palms"));
    }

    // TODO : REMOVE IF NOT NECESSARY
    @Test
    public void testIsLastBlock() {
        assertEquals(true, gridManager.isLastBlock(10, 18));
        assertEquals(false, gridManager.isLastBlock(6, 18));
        assertEquals(false, gridManager.isLastBlock(13, 54));
        assertEquals(true, gridManager.isLastBlock(60, 66));
    }

    @Test
    public void testIsLastLine() {
        assertEquals(false, gridManager.isLastLine(18, 80));
        assertEquals(true, gridManager.isLastLine(18, 19));
        assertEquals(true, gridManager.isLastLine(2, 3));
        assertEquals(true, gridManager.isLastLine(100, 101));
        assertEquals(false, gridManager.isLastLine(22, 20));
        assertEquals(false, gridManager.isLastLine(0, 3190));
    }

    @Test
    public void testLastBlockToStartAt() {
        assertEquals(6, gridManager.getLastBlockToStartAt(16));
        assertEquals(4, gridManager.getLastBlockToStartAt(23));
    }

    @Test
    public void testGetDecimals() {
        assertEquals(0.27, gridManager.getDecimals(1.27));
        assertEquals(0.99, gridManager.getDecimals(55.99));
    }
}
