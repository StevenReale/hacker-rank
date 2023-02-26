package steven.reale.thirtydays;

import java.util.Scanner;

/*
    You are given two classes, Person and Student, where Person is the base class and Student is the derived class.
    Completed code for Person and a declaration for Student are provided for you in the editor. Observe that Student
    inherits all the properties of Person.

    Complete the Student class by writing the following:

    A Student class constructor, which has  parameters:
    1. A string, firstName.
    2. A string, lastName.
    3. An integer, idNumber.
    4. An integer array (or vector) of test scores, scores.

    A char calculate() method that calculates a Student object's average and returns the grade character representative
    of their calculated average:

    O: 90 <= a <= 100
    E: 80 <= a < 90
    A: 70 <= a < 80
    P: 55 <= a < 70
    D: 40 <= a < 55
    T: a < 40

 */

//given code begins here
class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson() {
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + "\nID: " + idNumber);
    }

}
//given code ends here

class Student extends Person {
    private int[] testScores;

    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the Person's first name.
     *   @param lastName - A string denoting the Person's last name.
     *   @param id - An integer denoting the Person's ID number.
     *   @param scores - An array of integers denoting the Person's test scores.
     */
    // Write your constructor here
    Student(String firstName, String lastName, int id, int[] testScores) {
        super(firstName, lastName, id);
        this.testScores = testScores;
    }

    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    // Write your method here
    public char calculate() {
        int totalScore = 0;
        for (int score : testScores) {
            totalScore += score;
        }
        int averageScore = totalScore / testScores.length;

        if (averageScore >= 90) return 'O';
        if (averageScore >= 80) return 'E';
        if (averageScore >= 70) return 'A';
        if (averageScore >= 55) return 'P';
        if (averageScore >= 40) return 'D';
        else return 'T';
    }
}

//given code begins here
public class Day12 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for (int i = 0; i < numScores; i++) {
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
    }


}
//given code ends here