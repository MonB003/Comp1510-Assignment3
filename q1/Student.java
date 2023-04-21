package q1;

import java.text.DecimalFormat;

/**
 * Represents a BCIT student.
 * 
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @author Monica
 * @version 2017
 */
public class Student {
    /** First name of this student. */
    private String firstName;

    /** Last name of this student. */
    private String lastName;

    /** Home address of this student. */
    private Address homeAddress;

    /** School address of this student.  Can be shared by other students */
    private Address schoolAddress;
    
    /** Score of test one. */
    private int testOneScore;
    
    /** Score of test two. */
    private int testTwoScore;
    
    /** Score of test three. */
    private int testThreeScore;

    /**
     * Constructs a Student object that contains the specified values.
     * @param first a String representing the first name
     * @param last a String representing the last name
     * @param home an Address object containing the home address
     * @param school an Address object containing the school address
     */
    public Student(String first, String last, Address home, Address school) {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
    }
    
    /**
     * Constructs a Student object that sets the values of each test score to
     * zero.
     */
    public Student() {
        testOneScore = 0;
        testTwoScore = 0;
        testThreeScore = 0;
    }
    
    
    /**
     * Sets the value for the test score of the test number in the parameters.
     * @param testNum integer
     * @param testScore integer
     * @throws IllegalArgumentException if testNum isn't a valid test number
     */
    public void setTestScore(int testNum, int testScore) {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        
        if (testNum == one) {
            testOneScore = testScore;
        } else if (testNum == two) {
            testTwoScore = testScore;
        } else if (testNum == three) {
            testThreeScore = testScore;
        } else {
            // Throw an exception
            throw new IllegalArgumentException("Not a valid test number.");
        }
    }
    
    
    /**
     * Gets and returns the test score of the test number in the parameters.
     * @param testNum integer
     * @return testScore integer
     * @throws IllegalArgumentException if testNum isn't a valid test number
     */
    public int getTestScore(int testNum) {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        
        // Variable stores student's test score
        int testScore = 0;
        
        if (testNum == one) {
            testScore = testOneScore;
        } else if (testNum == two) {
            testScore = testTwoScore;
        } else if (testNum == three) {
            testScore = testThreeScore;
        } else {
            // Throw an exception
            throw new IllegalArgumentException("Not a valid test number.");
        }
        
        // Return appropriate test score
        return testScore;
    }
    
    
    /**
     * Calculates the average of the student's test scores.
     * @return average double
     */
    public double average() {
        // DecimalFormat rounds average calculation
        DecimalFormat decFormat = new DecimalFormat("#.####");
        
        // Stores number of tests being divided by in the calculation
        final int three = 3;
        
        // Variable stores calculation of student's average
        double calculate = (testOneScore + testTwoScore + testThreeScore) 
                / three;
        
        // Variable stores student's average
        double average = Double.valueOf(decFormat.format(calculate));
        
        // Return average
        return average;
    }
 

    /**
     * Returns a String description of this Student object.
     * @return description a String
     */
    public String toString() {
        // String stores the description of the student
        String result;

        // Append the student's information to the string
        result = firstName + " " + lastName + "\n";
        result += "Home Address:\n" + homeAddress + "\n";
        result += "School Address:\n" + schoolAddress + "\n";
        result += "Test Scores:\n";
        result += "Test 1 Score: " + testOneScore + "\n";
        result += "Test 2 Score: " + testTwoScore + "\n";
        result += "Test 3 Score: " + testThreeScore + "\n";
        result += "Average: " + average();

        // Return the student description
        return result;
    }
}

