package q2;

/**
 * <p>The TimesheetRow class represents a TimesheetRow object, which stores a
 * project, work package, and hours worked. A TimesheetRow with no parameters
 * sets each instance variable to 0 if it's a number, and an empty string if
 * it's a string. A TimesheetRow with parameters sets the values of the project
 * and work package to the parameters passed. To set the hours, TimesheetRow
 * has a method called setHour(), which takes a day and the hours, and sets it
 * to the UMASK array for that specific day. The setHour() method converts the
 * float parameter to an hour by multiplying it by ten, then storing that value
 * into a long. The bitwise operator '&' is used to change all the values in
 * that array index to 1 except the part being changed, which becomes 0. The
 * '<<' operator is used to shift the long that was calculated into the array
 * index for that day. The long is shifted 8 spaces (because each float holds 8
 * bits) multiplied by the day of the week number (so that the long is in the
 * right position for that day). The days are organized from Saturday (0) to
 * Friday (6). The instance variable hours stores the result of using the 'OR'
 * operator on the '&' operation and the shifting. </p>
 * 
 * <p>The getHour() method does the opposite of the setHour() method. It takes
 * a day of the week as a number, and uses '&' to change all the values in that
 * array index to 1 except the hours for that day. The '>>' operator is used to
 * shift the MASK array index for that day 8 multiplied by the day as a number
 * (to remove the zeroes after that specific day's hours). The result of the
 * shifting is stored in a long. The number is divided by 10 (to convert the
 * hours back to decihours), and that result is stored in a float.</p>
 * 
 * <p>There are getters and setters for each of the instance variables. The
 * MASK and UMASK are used for the getHour() and setHour() methods to set each
 * day's hours. The toString() method returns a string of the hours for each
 * day.</p>
 * 
 * <p>JUnit tests are provided for this class.</p>
 *
 * @author Monica
 * @version 1.0
 */
public class TimesheetRow {
    /** MASK. */
    private static final long[] MASK = {0xFFL, 0xFF00L,
        0xFF0000L, 0xFF000000L, 0xFF00000000L,
        0xFF0000000000L, 0xFF000000000000L};
    
    /** UNMASK. */
    private static final long[] UMASK =
        {0xFFFFFFFFFFFFFF00L,
        0xFFFFFFFFFFFF00FFL,
        0xFFFFFFFFFF00FFFFL,
        0xFFFFFFFF00FFFFFFL,
        0xFFFFFF00FFFFFFFFL,
        0xFFFF00FFFFFFFFFFL,
        0xFF00FFFFFFFFFFFFL};
        
    /** A project. */
    private int project;
    
    /** A work package. */
    private String workPackage;
    
    /** Hours worked. */
    private long hours;
    
    
    /**
     * Constructs an empty Timesheet Row object.
     */
    public TimesheetRow() {
        project = 0;
        workPackage = "";
        
        // Variable stores number of days in a week
        final int seven = 7;
        
        // Variable stores default hours
        final int zero = 0;
        
        // For loop goes through each day and sets its hours
        for (int day = 0; day < seven; day++) {
            // Use setHour() to set each day's hours
            setHour(day, zero);
        }
    }
    
    
    /**
     * Constructs a Timesheet Row object with the initial values of project,
     * work package, and the hours for each day.
     *
     * @param project integer
     * @param workPackage string
     * @param hrsEachDay array of floats
     * @throws ArrayIndexOutOfBoundsException is parameter array has more than
     *      seven values
     */
    public TimesheetRow(int project, String workPackage, float...hrsEachDay) {
        this.project = project;
        this.workPackage = workPackage;
        
        // Variable stores number of days in a week
        final int seven = 7;
        
        // Check if the number of indexes in the parameter array is not valid
        if (hrsEachDay.length > seven) {
            // Throw exception if number of indexes in parameter is greater
            // than the number of days in a week
            throw new ArrayIndexOutOfBoundsException("Maximum number of values" 
                    + " that can be in the array is 7.");
        } else {
            // If parameter array is valid, store each index of the array
            
            // For loop goes through each day in the array and sets its hours
            for (int day = 0; day < hrsEachDay.length; day++) {
                // Use setHour() to set each day's hours
                setHour(day, hrsEachDay[day]);
            }
        }
        
    }
     
    
    /**
     * Returns the value of project as a integer.
     * @return the project
     */
    public int getProject() {
        return project;
    }

    /**
     * Sets the value of project to the specified value.
     * @param project the project to set
     */
    public void setProject(int project) {
        this.project = project;
    }

    /**
     * Returns the value of workPackage as a string.
     * @return the workPackage
     */
    public String getWorkPackage() {
        return workPackage;
    }

    /**
     * Sets the value of workPackage to the specified value.
     * @param workPackage the workPackage to set
     */
    public void setWorkPackage(String workPackage) {
        this.workPackage = workPackage;
    }

    /**
     * Returns the value of hours as a long.
     * @return the hours
     */
    public long getHours() {
        return hours;
    }

    /**
     * Sets the value of hours to the specified value.
     * @param hours the hours to set
     */
    public void setHours(long hours) {
        this.hours = hours;
    }

  
    /**
     * Gets a day of the week number (0 is Saturday, 6 is Friday) and returns
     * the hours for that day as a float.
     * 
     * @param dayOfWeek integer
     * @return floatHours float
     */
    public float getHour(int dayOfWeek) {
        // Variable stores the value 8, which is the number of bits in each
        // float
        final int eight = 8;
        
        // Get the day's hours in mask, "and" it with the mask at that day's
        // index
        // Shift the hours right 8 places to remove zeros after that bit
        long getBits = (hours & MASK[dayOfWeek]) >> (dayOfWeek * eight);
        
        // Variable stores the value 10
        final int ten = 10;
        
        // Divide by 10 because it was originally multiplied by ten in the
        // setHour() method to get the unsigned byte
        float floatHours = (float) getBits / ten;
        
        // Return float hours
        return floatHours;
    }
    
    /**
     * Gets a day of the week number and hours as a float and sets it into the
     * appropriate byte of hours.
     * 
     * @param dayOfWeek integer
     * @param floatHours float
     */
    public void setHour(int dayOfWeek, float floatHours) {
        // Variable stores the number 10
        final int ten = 10;
        
        // Get hours and multiply it by 10 to convert the decihour to hours
        // Convert the hours to a long
        long byteHours = (long) (floatHours * ten);
        
        // Variable stores the number 8
        final int eight = 8;
        
        // "And" the hours with the index of the day in UMASK
        // This creates empty spaces so the hours can be inserted
        // The current zeroes in the index are where the hours are inserted
        long insert = hours & UMASK[dayOfWeek];
        
        // In UMASK, shift the hours 8 bits left for each day
        long shift = byteHours << dayOfWeek * eight;
        
        // "Or" the two values together to add them
        hours = insert | shift;
    }
    
    
    /**
     * Returns a description of the hours worked each day in order from
     * Saturday to Friday.
     *
     * @return hoursEachDay in order
     */
    public String toString() {
        // Variable stores the hours each day as a string
        String hoursEachDay = "";
        
        // Array stores the values of each day in a week
        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", 
            "Wednesday", "Thursday", "Friday"};
        
        // Adds the days in order from Saturday to Friday
        final int seven = 7;
        for (int day = 0; day < seven; day++) {
            // Add each day and it's hours to the string
            hoursEachDay += daysOfWeek[day] + " Hours: " + getHour(day) + "\n";
        }
            
        // Return the hours each day as a string
        return hoursEachDay;
    }
    
}
