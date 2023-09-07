import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        String[] studentNames = new String[numStudents];
        double[] testScores = new double[numStudents];
        double[] otherScores = new double[numStudents];
        char[] studentGrades = new char[numStudents];

        // Input student names, test scores, and other scores
        inputStudentData(scanner, studentNames, testScores, otherScores);

        // Calculate and assign grades
        calculateStudentGrades(numStudents, testScores, otherScores, studentGrades);

        // Display the results
        displayStudentGradeReport(numStudents, studentNames, testScores, otherScores, studentGrades);

        scanner.close();
    }

    public static void inputStudentData(Scanner scanner, String[] studentNames, double[] testScores, double[] otherScores) {
        for (int i = 0; i < studentNames.length; i++) {
            scanner.nextLine();  // Consume newline
            System.out.print("Enter the name of student #" + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
            System.out.print("Enter the test score for " + studentNames[i] + ": ");
            testScores[i] = scanner.nextDouble();
            System.out.print("Enter the other score for " + studentNames[i] + ": ");
            otherScores[i] = scanner.nextDouble();
        }
    }

    public static void calculateStudentGrades(int numStudents, double[] testScores, double[] otherScores, char[] studentGrades) {
        for (int i = 0; i < numStudents; i++) {
            studentGrades[i] = calculateGrade(testScores[i], otherScores[i]);
        }
    }

    public static char calculateGrade(double testScore, double otherScore) {
        // Calculate the weighted average: 40% test score + 60% other score
        double weightedAverage = (0.4 * testScore) + (0.6 * otherScore);

        if (weightedAverage >= 90) {
            return 'A';
        } else if (weightedAverage >= 80) {
            return 'B';
        } else if (weightedAverage >= 70) {
            return 'C';
        } else if (weightedAverage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void displayStudentGradeReport(int numStudents, String[] studentNames, double[] testScores,
                                                 double[] otherScores, char[] studentGrades) {
        System.out.println("\nStudent Grade Report:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(studentNames[i] + " - Test Score: " + testScores[i] +
                    ", Other Score: " + otherScores[i] + ", Grade: " + studentGrades[i]);
        }
    }
}



