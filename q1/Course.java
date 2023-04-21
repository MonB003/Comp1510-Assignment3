package q1;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Course class represents a course.
 * 
 * @author Monica
 * @version 1.0
 */
public class Course {
    /** Course name. */
    private String courseName;
    
    /** ArrayList stores all students in the course. */
    private ArrayList<Student> listOfStudents = new ArrayList<Student>();
    
    /** Number of valid students. */
    private int numOfValidStudents;
    
    /**
     * Constructs a Course object with the specified data.
     *
     * @param courseName string
     */
    public Course(String courseName) {
        this.courseName = courseName;
    }
    
    
    /**
     * Adds a student to the course.
     *
     * @param student Student
     */
    public void addStudent(Student student) {
        final int maxStudentsNum = 5;
        if (numOfValidStudents < maxStudentsNum) {
            // Add student
            listOfStudents.add(student);
            
            // Increment count for valid students
            numOfValidStudents++;
        } else {
            // Throw an exception
            throw new IllegalArgumentException("Course is already full.");
        }
    }
    
    
    /**
     * Calculates and returns the average of all students' test score averages.
     * @return average double
     */
    public double average() {
        // DecimalFormat rounds average calculation
        DecimalFormat decFormat = new DecimalFormat("#.####");
        
        // Stores number of tests being divided by in the calculation
        int numOfAverages = listOfStudents.size();
        
        // Variable stores sum of averages
        double studAverages = 0;
        
        // Add up the averages
        for (Student student : listOfStudents) {
            studAverages += student.average();
        }
        
        // Calculate all students' averages by dividing by the number of
        // averages
        double calculate = studAverages / numOfAverages;
        
        // Variable stores all students� test score averages
        double average = Double.valueOf(decFormat.format(calculate));
        
        // Return average
        return average;
    }
    
    
    /**
     * Prints all students in the course.
     * @return ArrayList Student
     */
    public ArrayList<Student> roll() {
        // Prints the course name
        System.out.println("Course: " + courseName + "\n");
        
        // Prints each student in the list
        for (Student student : listOfStudents) {
            System.out.println("Student: " + student + "\n");
        }
        
        // Return ArrayList
        return listOfStudents;
    }

}
