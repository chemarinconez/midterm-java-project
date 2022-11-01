public class App {
    public static void main(String[] args) {
        System.out.println("\t\tSCHOOL GRADING SYSTEM\n");
        SchoolGradingSystem object1 = new SchoolGradingSystem();

        object1.readData();
        System.out.println(
                "-----------------------------------------------------------------------------------------------------");
        System.out.print("\n\tVariance of the grades for the entire group: ");
        System.out.printf("%.2f\n", object1.question1());
        System.out.print("\n\tPercentage of the Regular exams: ");
        System.out.printf("%.2f\n", object1.question2());
        System.out.print("\n\tSubject with the highest number of approved exams: ");
        System.out.println(object1.question3());
        System.out.print("\n\tStudent with the best performance for the subject Introduction to CS: ");
        System.out.println(object1.question4());

        object1.scanner.close();
    }
}
