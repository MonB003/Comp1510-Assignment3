package q1;

/**
 * <p>The TestCourse class creates a Course object and adds Student objects with
 * strings and Address objects as the parameters. This program uses the Course
 * class method addStudent() to add a Student object to a Course. The Student
 * class method called setTestCourse() takes in two number parameters: a test 
 * number and a score, then stores the score into that test variable for the
 * student. If the test number in the parameter isn't 1, 2, or 3, an exception
 * is thrown because the test number would not be valid. If a sixth student is
 * added to the class, an exception will also be thrown that says the course is
 * already full, since the maximum number of students in a course in five.</p>
 * 
 * <p>This program uses the Course class roll() method, which prints out each
 * student in the course, as well as their information from the toString()
 * method. The Course average() method is used to calculate all the student's
 * total average. The results from the roll() and average() methods are printed
 * to the console.</p>
 *
 * @author Monica
 * @version 1.0
 */
public class TestCourse {
    /**
     * This is the main method (entry point) that gets called by the JVM.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // Create a Course object
        Course course = new Course("Programming Methods");
        
        // Create Addresses for Student objects
        Address address1 
            = new Address("121 Elm Street", "Vancouver", "BC", "V5V 5V5");
        Address address2 
            = new Address("123 Elm Street", "Vancouver", "BC", "V5A 5A5");
        Address address3 
            = new Address("125 Elm Street", "Vancouver", "BC", "V5B 5B5");
        Address address4 
            = new Address("127 Elm Street", "Vancouver", "BC", "V5C 5C5");
        Address address5 
            = new Address("129 Elm Street", "Vancouver", "BC", "V5D 5D5");
        Address school =
                new Address("3700 Willingdon Ave.", "Burnaby", "BC", "V5G 3H2");
        
        // Create Student objects
        Student student1 = new Student("Monica", "Bacatan", address1, school);
        Student student2 = new Student("Sally", "Jones", address2, school);
        Student student3 = new Student("Mary", "Smith", address3, school);
        Student student4 = new Student("Joe", "Roberts", address4, school);
        Student student5 = new Student("Willy", "Williams", address5, school);

        // Add students to course
        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);
        course.addStudent(student4);
        course.addStudent(student5);
        
        // Variables for test numbers
        final int test1 = 1;
        final int test2 = 2;
        final int test3 = 3;
        
        final int seventy = 70;
        final int seventyFive = 75;
        final int eighty = 80;
        final int eightyFive = 85;
        final int ninety = 90;
        final int ninetyFive = 95;
        
        // Set test scores for each student
        student1.setTestScore(test1, eighty);
        student1.setTestScore(test2, eightyFive);
        student1.setTestScore(test3, ninety);
        
        student2.setTestScore(test1, ninety);
        student2.setTestScore(test2, seventy);
        student2.setTestScore(test3, eighty);
        
        student3.setTestScore(test1, seventy);
        student3.setTestScore(test2, eighty);
        student3.setTestScore(test3, ninety);
        
        student4.setTestScore(test1, seventyFive);
        student4.setTestScore(test2, eightyFive);
        student4.setTestScore(test3, ninetyFive);
        
        student5.setTestScore(test1, ninety);
        student5.setTestScore(test2, ninetyFive);
        student5.setTestScore(test3, ninetyFive);
        
        // Print the roll
        System.out.println("Roll: ");
        course.roll();
       
        // Print the overall course test average
        double overallAverage = course.average();
        System.out.println("Course Test Average: " + overallAverage);
        
        // Prints at the end of the main method
        System.out.println();
        System.out.println("Question one was called and ran successfully.");
    }

}
