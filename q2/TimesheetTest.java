package q2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * These are JUnit tests that test each of the methods from the Timesheet
 * class.
 *
 * @author Monica
 * @version 1.0
 */
public class TimesheetTest {
    
    /**
     * The Timesheet object to test.
     */
    private Timesheet timesheet;
    private Timesheet timesheetEmpty;

    /**
     * Creates a new Timesheet object before each test is executed.
     * 
     * @throws Exception
     *             if a Timesheet object cannot be created.
     */
    @BeforeEach
    public void setUp() throws Exception {
          timesheet = new Timesheet("ABC123", LocalDate.parse("2021-11-19"));
          timesheetEmpty = new Timesheet();
    }
    
    
    /**
     * Test the constructor.
     */
    @Test
    public void testConstructor() {
        // Make a timesheet with a date that's not Friday
        Timesheet timesheetTest = new Timesheet("ABC123", 
                LocalDate.parse("2021-11-01"));
        
        // Date the constructor will be set to
        LocalDate newDate = LocalDate.parse("2021-11-05");
        
        // Date equals the next Friday
        assertEquals(newDate, timesheetTest.getEndWeek());
    }
    
    
    /**
     * Test get employee number method.
     */
    @Test
    public void testGetEmpNum() {
        assertEquals("ABC123", timesheet.getEmpNum());
    }
    
    /**
     * Test get employee number method with empty constructor.
     */
    @Test
    public void testGetEmpNum2() {
        assertEquals("", timesheetEmpty.getEmpNum());
    }
    
    /**
     * Test set employee number method.
     */
    @Test
    public void testSetEmpNum() {
        // Set employee number method
        timesheetEmpty.setEmpNum("A1B2C3");
        
        assertEquals("A1B2C3", timesheetEmpty.getEmpNum());
    }
    
    
    /**
     * Test get end week method.
     */
    @Test
    public void testGetEndWeek() {
        assertEquals(LocalDate.parse("2021-11-19"), timesheet.getEndWeek());
    }
    
    /**
     * Test get end week method with empty constructor.
     */
    @Test
    public void testGetEndWeek3() {
        // Variable stores the day Friday
        DayOfWeek friday = DayOfWeek.FRIDAY;
        
        LocalDate today = LocalDate.now();
        
        // Stores expected date output
        LocalDate date;
        
        // If today's date is Friday
        if (today.getDayOfWeek() == DayOfWeek.FRIDAY) {
            // Store it in endWeek
            date = today;
        } else {
            // Adjust date to the next Friday
            LocalDate newDate = today.with(TemporalAdjusters.next(friday));
            
            // Store the next Friday in endWeek
            date = newDate;
        }
        
        assertEquals(date, timesheetEmpty.getEndWeek());
    }
    
    /**
     * Test get end week method with empty constructor.
     */
    @Test
    public void testGetEndWeek2() {
        // Variable stores the day Friday
        DayOfWeek friday = DayOfWeek.FRIDAY;
        
        // Default date is today's date
        LocalDate today = LocalDate.now();
        
        // Stores expected date output
        LocalDate date;
        
        // If today's date is Friday
        if (today.getDayOfWeek() == DayOfWeek.FRIDAY) {
            // Store it in endWeek
            date = today;
        } else {
            // Adjust date to the next Friday
            LocalDate newDate = today.with(TemporalAdjusters.next(friday));
            
            // Store the next Friday in endWeek
            date = newDate;
        }
        
        assertEquals(date, timesheetEmpty.getEndWeek());
    }
    
    /**
     * Test set end week method.
     */
    @Test
    public void testSetEndWeek() {
        // Get a date that's not Friday
        LocalDate date = LocalDate.parse("2021-11-01");
        
        // Throws exception
        assertThrows(IllegalArgumentException.class,
                () -> {timesheetEmpty.setEndWeek(date);} );
    }
    
    /**
     * Test set end week method.
     */
    @Test
    public void testSetEndWeek2() {
        // Get a date that's not Friday
        LocalDate date = LocalDate.parse("2021-11-03");
        
        // Throws exception
        assertThrows(IllegalArgumentException.class,
                () -> {timesheetEmpty.setEndWeek(date);} );
    }
    
    /**
     * Test set end week method.
     */
    @Test
    public void testSetEndWeek3() {
        // Get a date that's Friday
        LocalDate date = LocalDate.parse("2021-11-19");
        
        // Set end week method
        timesheetEmpty.setEndWeek(date);
        
        assertEquals(date, timesheetEmpty.getEndWeek());
    }
    
    /**
     * Test set end week method.
     */
    @Test
    public void testSetEndWeek4() {
        // Get a date that's Friday
        LocalDate date = LocalDate.parse("2021-10-01");
        
        // Set end week method
        timesheetEmpty.setEndWeek(date);
        
        assertEquals(date, timesheetEmpty.getEndWeek());
    }
    
    
    /**
     * Test set details and get details methods.
     */
    @Test
    public void testGetDetails() {
        ArrayList<TimesheetRow> details = new ArrayList<TimesheetRow>();
        
        // Set details method
        timesheet.setDetails(details);
        
        // Check output using get details method
        assertEquals(details, timesheet.getDetails());
    }
    
    
    /**
     * Test add row method.
     */
    @Test
    public void testAddRow() {
        // Create ArrayList details to store timesheet rows
        ArrayList<TimesheetRow> details = new ArrayList<TimesheetRow>();
        timesheetEmpty.setDetails(details);
        
        // Create timesheet row
        float[] hrsEachDay = {3.2F, 1.1F, 4.5F, 5.5F, 3.2F, 2.0F, 5.0F};
        TimesheetRow tRow = new TimesheetRow(1, "Package", hrsEachDay);
        
        // Add row method
        timesheetEmpty.addRow(tRow);
        
        // Checks that the row is added to the timesheet ArrayList
        assertEquals(tRow, details.get(0));
    }
    
    
    /**
     * Test to string method.
     */
    @Test
    public void testToString() {
        // Create ArrayList details to store timesheet rows
        ArrayList<TimesheetRow> details = new ArrayList<TimesheetRow>();
        
        // Create timesheet row
        float[] hrsEachDay = {3.2F, 1.1F, 4.5F, 5.5F, 3.2F, 2.0F, 5.0F};
        TimesheetRow tRow = new TimesheetRow(1, "Package", hrsEachDay);
        
        // Add the row to the ArrayList
        timesheet.addRow(tRow);
        
        // Set the ArrayList to the timesheet
        timesheet.setDetails(details);
        
        // Expected toString() method output
        String timesheetString = "Timesheet Data: " + details;
        
        // Checks that the string output is correct
        assertEquals(timesheetString, timesheet.toString());
    }
    
}
