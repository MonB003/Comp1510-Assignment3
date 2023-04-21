package q2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.TemporalAdjusters;

/**
 * <p>The Timesheet class represents a Timesheet object, which stores an
 * employee number, end date, and ArrayList of TimesheetRow objects. If a
 * Timesheet is made the no constructors, the empty constructor sets the
 * initial values of each instance variable. The employee number is set to an
 * empty string. The date is stored as today's date if it's a Friday, or the
 * next Friday if today's date isn't Friday. The parameter constructor checks
 * if the LocalDate passed in the parameters is valid, otherwise it adjusts the
 * date to be the next Friday. The initial value of employee number is set to
 * the parameter passed for empNum.</p>
 * 
 * <p>There are getters and setters to get and set each of the instance
 * variables. The method addRow() takes a TimesheetRow object as the parameter,
 * then adds it to the details ArrayList of the Timesheet. The toString()
 * method prints the ArrayList of the Timesheet.</p>
 * 
 * <p>There is a main method to demonstrate how some of these methods are used.
 * </p>
 * 
 * <p>JUnit tests are provided for this class.</p>
 *
 * @author Monica
 * @version 1.0
 */
public class Timesheet {
    /** Employee number. */
    private String empNum;
    
    /** End date (must be Friday). */
    private LocalDate endWeek; 
    
    /** List of TimesheetRow objects. */
    private ArrayList<TimesheetRow> details = new ArrayList<TimesheetRow>();
    
    
    /**
     * Constructs an empty Timesheet object.
     */
    public Timesheet() {
        empNum = "";
        
        // Variable stores the day Friday
        DayOfWeek friday = DayOfWeek.FRIDAY;
        
        // Default date is today's date
        LocalDate date = LocalDate.now();
        
        // If today's date is Friday
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
            // Store it in endWeek
            endWeek = date;
        } else {
            // Adjust date to the next Friday
            LocalDate newDate = date.with(TemporalAdjusters.next(friday));
            
            // Store the next Friday in endWeek
            endWeek = newDate;
        }
    }
    
    
    /**
     * Constructs a Timesheet object with the specified data.
     *
     * @param empNum string
     * @param endWeek LocalDate
     */
    public Timesheet(String empNum, LocalDate endWeek) {
        this.empNum = empNum;
        
        // Variable stores the day Friday
        DayOfWeek friday = DayOfWeek.FRIDAY;
        
        // If the parameter day isn't Friday
        if (endWeek.getDayOfWeek() != friday) {
            
            // Sets the day to the next Friday
            this.endWeek = endWeek.with(TemporalAdjusters.next(friday));
            
        } else {
            // If the parameter day is Friday
            // Set the parameter date as the end date
            this.endWeek = endWeek;
        }
    }
    
    
    /**
     * Returns the value of empNum as a string.
     * @return the empNum
     */
    public String getEmpNum() {
        return empNum;
    }

    /**
     * Sets the value of empNum to the specified value.
     * @param empNum the empNum to set
     */
    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    /**
     * Returns the value of endWeek as a LocalDate.
     * @return the endWeek
     */
    public LocalDate getEndWeek() {
        return endWeek;
    }

    /**
     * Sets the value of endWeek to the specified value.
     * @param endWeek the endWeek to set
     * @throws IllegalArgumentException if parameter LocalDate isn't Friday
     */
    public void setEndWeek(LocalDate endWeek) {  
        // Variable stores the day Friday
        DayOfWeek friday = DayOfWeek.FRIDAY;
        
        // If the parameter day isn't Friday
        if (endWeek.getDayOfWeek() != friday) {
            
            // Set the end date to the next Friday
            this.endWeek = endWeek.with(TemporalAdjusters.next(friday));
            
            // Throw an exception because parameter isn't valid
            throw new IllegalArgumentException("Day must be Friday.");
            
        } else {
            // If the parameter day is Friday
            // Set the parameter date as the end date
            this.endWeek = endWeek;
        }
    }

    /**
     * Returns the value of details as an ArrayList.
     * @return the details
     */
    public ArrayList<TimesheetRow> getDetails() {
        return details;
    }

    /**
     * Sets the value of details to the specified value.
     * @param details the details to set
     */
    public void setDetails(ArrayList<TimesheetRow> details) {
        this.details = details;
    }
    
    
    /**
     * Adds a timesheet row to the timesheet row list.
     *
     * @param timeSheetRow TimesheetRow
     */
    public void addRow(TimesheetRow timeSheetRow) {
        details.add(timeSheetRow);
    }
    
    
    /**
     * Returns a description of the Timesheet data.
     *
     * @return all Timesheet data as a string
     */
    public String toString() {
        return "Timesheet Data: " + details;
    }

}
