package q2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * These are JUnit tests that test each of the methods from the TimesheetRow
 * class.
 *
 * @author Monica
 * @version 1.0
 */
public class TimesheetRowTest {
    
    /**
     * The TimesheetRow object to test.
     */
    private TimesheetRow timesheetRow;
    private TimesheetRow timesheetRowEmpty;

    /**
     * Creates a new TimesheetRow object before each test is executed.
     * 
     * @throws Exception
     *             if a TimesheetRow object cannot be created.
     */
    @BeforeEach
    public void setUp() throws Exception {
        float[] hrsEachDay = {3.2F, 1.1F, 4.5F, 5.5F, 3.2F, 2.0F, 5.0F};
        timesheetRow = new TimesheetRow(1, "Package", hrsEachDay);
        
        timesheetRowEmpty = new TimesheetRow();
    }

    
    /**
     * Test constructor with invalid array input.
     */
    @Test
    public void testConstructor() {
        // Test with an array that has more than 7 inputs (exceeds number of
        // days in a week)
        float[] hours = {3.2F, 1.1F, 4.5F, 5.5F, 3.2F, 2.0F, 5.0F, 4.0F};
        
        // Throws exception when TimesheetRow object is created
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {new TimesheetRow(1, "Package", hours);} );
    }
    
    
    /**
     * Test get project method.
     */
    @Test
    public void testGetProject() {
        assertEquals(1, timesheetRow.getProject());
    }
    
    /**
     * Test get project method with empty constructor.
     */
    @Test
    public void testGetProject2() {
        assertEquals(0, timesheetRowEmpty.getProject());
    }
    
    /**
     * Test set project method.
     */
    @Test
    public void testSetProject() {
        timesheetRowEmpty.setProject(3);
        
        assertEquals(3, timesheetRowEmpty.getProject());
    }
    
    
    /**
     * Test get work package method.
     */
    @Test
    public void testGetWorkPackage() {
        assertEquals("Package", timesheetRow.getWorkPackage());
    }
    
    /**
     * Test get project method with empty constructor.
     */
    @Test
    public void testGetWorkPackage2() {
        assertEquals("", timesheetRowEmpty.getWorkPackage());
    }
    
    /**
     * Test set work package method.
     */
    @Test
    public void testSetWorkPackage() {
        timesheetRowEmpty.setWorkPackage("Work Package");
        
        assertEquals("Work Package", timesheetRowEmpty.getWorkPackage());
    }
    
    
    /**
     * Test get hours method.
     */
    @Test
    public void testGetHours() {
        assertEquals(14095877432740640L, timesheetRow.getHours(), 0.00001);
    }
    
    /**
     * Test get hours method.
     */
    @Test
    public void testGetHours2() {
        assertEquals(0L, timesheetRowEmpty.getHours(), 0.00001);
    }
    
    /**
     * Test set hours method.
     */
    @Test
    public void testSetHours() {
        timesheetRowEmpty.setHours(12345678910L);
        
        assertEquals(12345678910L, timesheetRowEmpty.getHours(), 0.00001);
    }
    
    
    /**
     * Test get hour method.
     */
    @Test
    public void testGetHour() {
        assertEquals(3.2F, timesheetRow.getHour(0), 0.00001);
    }
    
    /**
     * Test get hour method.
     */
    @Test
    public void testGetHour2() {
        assertEquals(1.1F, timesheetRow.getHour(1), 0.00001);
    }
    
    /**
     * Test get hour method.
     */
    @Test
    public void testGetHour3() {
        assertEquals(4.5F, timesheetRow.getHour(2), 0.00001);
    }
    
    /**
     * Test get hour method.
     */
    @Test
    public void testGetHour4() {
        assertEquals(5.5F, timesheetRow.getHour(3), 0.00001);
    }
    
    /**
     * Test get hour method with empty constructor.
     */
    @Test
    public void testGetHour5() {
        assertEquals(0.0F, timesheetRowEmpty.getHour(0), 0.00001);
    }
    
    /**
     * Test get hour method with empty constructor.
     */
    @Test
    public void testGetHour6() {
        assertEquals(0.0F, timesheetRowEmpty.getHour(2), 0.00001);
    }
    
    /**
     * Test get hour method with empty constructor.
     */
    @Test
    public void testGetHour7() {
        assertEquals(0.0F, timesheetRowEmpty.getHour(4), 0.00001);
    }
    
    /**
     * Test get hour method with empty constructor.
     */
    @Test
    public void testGetHour8() {
        // Tests partly filled list of hours
        float[] hoursEachDay = {3.2F, 1.1F, 2.2F, 1.5F};
        timesheetRowEmpty = new TimesheetRow(1, "Package", hoursEachDay);
        
        assertEquals(3.2F, timesheetRowEmpty.getHour(0), 0.00001);
        assertEquals(1.1F, timesheetRowEmpty.getHour(1), 0.00001);
        assertEquals(2.2F, timesheetRowEmpty.getHour(2), 0.00001);
        assertEquals(1.5F, timesheetRowEmpty.getHour(3), 0.00001);
        assertEquals(0.0F, timesheetRowEmpty.getHour(4), 0.00001);
        assertEquals(0.0F, timesheetRowEmpty.getHour(5), 0.00001);
        assertEquals(0.0F, timesheetRowEmpty.getHour(6), 0.00001);
    }
    
    /**
     * Test set hour method.
     */
    @Test
    public void testSetHour() {
        timesheetRowEmpty.setHour(4, 4.3F);
        
        assertEquals(4.3F, timesheetRowEmpty.getHour(4), 0.00001);
    }
    
    /**
     * Test set hour method.
     */
    @Test
    public void testSetHour2() {
        timesheetRowEmpty.setHour(5, 3.2F);
        
        assertEquals(3.2F, timesheetRowEmpty.getHour(5), 0.00001);
    }
    
    /**
     * Test set hour method.
     */
    @Test
    public void testSetHour3() {
        timesheetRowEmpty.setHour(6, 3.3F);
        
        assertEquals(3.3F, timesheetRowEmpty.getHour(6), 0.00001);
    }
    
    
    /**
     * Test to string method.
     */
    @Test
    public void testToString() {
        // Value for expected toString() method output
        String timesheetRowStr = "";
        
        // Array for each day of the week
        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", 
                "Wednesday", "Thursday", "Friday"};
        
        // Add each day and it's hours to the string in order
        for (int day = 0; day < 7; day++) {
            timesheetRowStr += daysOfWeek[day] + " Hours: " 
                + timesheetRow.getHour(day) + "\n";
        }
        
        // Checks that the string output is correct
        assertEquals(timesheetRowStr, timesheetRow.toString());
    }
}
