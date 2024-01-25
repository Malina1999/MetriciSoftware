package implementation;

public class ArrowTest {

    private Arrow arrow;
    private Graphics2D graphics2D;
    private Point base;

    @BeforeEach
    public void setup() {
        arrow = new Arrow();
        graphics2D = Mockito.mock(Graphics2D.class);
        base = new Point(0, 0);
    }

    @Test
    public void testPaintComponentWhenCalledThenStateChanges() {
        Point initialPoint = new Point(arrow.p);
        arrow.paintComponent(graphics2D, base);
        assertEquals(initialPoint, arrow.p, "The state of the object should change after the method is called");
    }

    @Test
    public void testPaintComponentWhenBasePointOutsideFieldThenArrowPointsToMouseLocation() {
        base = new Point(Constants.FIELD_SIZE_X + 1, Constants.FIELD_SIZE_Y + 1);
        Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
        arrow.paintComponent(graphics2D, base);
        assertEquals(mouseLoc, arrow.p, "The arrow should point to the mouse location when the base point is outside the field");
    }

    @Test
    public void testPaintComponentWhenBasePointInsideFieldThenArrowPointsToBasePoint() {
        base = new Point(Constants.FIELD_SIZE_X / 2, Constants.FIELD_SIZE_Y / 2);
        arrow.paintComponent(graphics2D, base);
        assertEquals(base, arrow.p, "The arrow should point to the base point when the base point is inside the field");
    }
}