import java.util.Scanner;

public class SchoolGradingSystem {
    int inputs;
    String str, values[];
    Float[][] table;
    Scanner scanner;

    public void readData() {
        scanner = new Scanner(System.in);

        System.out.print("How many lines of data do you want to insert? --> ");
        inputs = scanner.nextInt();
        scanner.nextLine();
        table = new Float[inputs][4];

        System.out.println("\nRemember enter each information student-Subject on the same line with space, such as: ");
        System.out.println("StudentID GenderCode SubjectID Grade");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------\n");

        for (int i = 0; i < inputs; i++) {
            System.out.print("Insert line " + (i + 1) + ": ");
            str = scanner.nextLine();
            values = str.split(" ");
            for (int j = 0; j < 4; j++) {
                table[i][j] = Float.parseFloat(values[j]);
            }
        }
    }

    public float question1() {
        float sum = 0.0f, mean, variance;

        for (int i = 0; i < inputs; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 3) {
                    sum += table[i][j];
                }
            }
        }
        mean = sum / inputs;

        sum = 0.0f;
        for (int i = 0; i < inputs; i++) {
            sum += Math.pow(table[i][3] - mean, 2);
        }
        variance = sum / inputs;
        return variance;
    }

    public float question2() {
        float sumRegular = 0.0f, regularGradePercentage;
        for (int i = 0; i < inputs; i++) {
            if (table[i][3] >= 60 && table[i][3] < 80) {
                sumRegular++;
            }
        }
        regularGradePercentage = sumRegular / inputs;
        return regularGradePercentage;
    }

    public String question3() {
        String highestGradeSubject = "";
        int introductionToCs = 0, probSolving = 0, oop = 0;
        float subjects;

        for (int i = 0; i < inputs; i++) {
            if (table[i][3] >= 60) {
                subjects = table[i][2];
                if (subjects == 1.0) {
                    introductionToCs += 1;
                } else if (subjects == 2.0) {
                    probSolving += 1;
                } else if (subjects == 3.0) {
                    oop += 1;
                }
            }
        }

        if (introductionToCs >= probSolving) {
            if (introductionToCs > oop) {
                highestGradeSubject = "introductionToCs";
            } else {
                highestGradeSubject = "oop";
            }
        } else if (probSolving > introductionToCs) {
            if (probSolving >= oop) {
                highestGradeSubject = "probSolving";
            } else {
                highestGradeSubject = "oop";
            }
        } else if (oop > introductionToCs) {
            if (oop > probSolving) {
                highestGradeSubject = "oop";
            } else {
                highestGradeSubject = "probSolving";
            }
        }

        return highestGradeSubject;
    }

    public String question4() {
        String bestCS = "";
        String[] students = { "Jose", "student2", "student3", "student4", "student5", "student6" };
        float student = 0.0f, highestCS = 0.0f;

        for (int i = 0; i < inputs; i++) {
            if (table[i][2] == 1.0) {
                if (table[i][3] > highestCS) {
                    highestCS = table[i][3];
                    student = table[i][0];
                }
            }
        }
        for (int i = 1; i <= 5; i++) {
            if (i == student) {
                bestCS = students[i - 1];
            }
        }
        return bestCS;
    }
}
