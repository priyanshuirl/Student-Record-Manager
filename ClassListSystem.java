import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassListSystem {
    static ArrayList<String> studrecord = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] arg) {

        Students studList = new Students();
        GraduateStudents gStudList = new GraduateStudents();

        int menu = 0;
        String line;

        while (menu != 5) {

            System.out.println("\n------------------------------------------------------------");
            System.out.println("\nMenu Options:\n");

            System.out.println(
                    "(1) Enter information for a new Student.\n(2) Enter information for a new Graduate Student.\n(3) Show all student information with each attribute on a separate line.\n(4) Print the average of the average grades for all students as well as the total number of students.\n(5) Enter a specific program and show all student information for that program.\n(6) Load student information from an input file.\n(7) Save all student information to an output file.\n(8) End program.");

            System.out.print("\nEnter the option number of the action that you want to perform (1 - 8): ");
            menu = studList.scan.nextInt();
            if (menu <= 8 && menu >= 1) {
                if (menu == 1) {
                    studList.getStudentInfo();
                }

                else if (menu == 2) {
                    gStudList.getStudentInfo();
                }

                else if (menu == 3) {
                    studList.displayStudentInfo();
                    gStudList.displayStudentInfo();
                }

                else if (menu == 4) {
                    studList.AverageTotal();
                    gStudList.AverageTotal();
                }

                else if (menu == 5) {
                    studList.programInfo();
                    gStudList.programInfo();
                }

                else if (menu == 6) {
                    System.out.print("Enter the Name of the File you want to Load Data from: ");
                    String fname = scan.nextLine();
                    System.out.print("\nLoading Data from " + fname + "...\n");
                    try {
                        BufferedReader input = new BufferedReader(new FileReader(fname));
                        while ((line = input.readLine()) != null) {
                            studrecord.add(line);
                        }
                        input.close();
                        System.out.println("\nStudent Data\n" + studrecord.get(0));
                        System.out.println("\nGraduate Student Data\n" + studrecord.get(1) + "\n");
                        System.out.println("\nData loaded from file " + fname + " Successfully.\n");
                    } catch (IOException e) {
                        System.out.println("\nSomething Went Wrong, Could Not open the file " + fname
                                + ", Please recheck the Name of the file you entered and make sure it exists.\n");
                    }
                    if (studrecord.size() > 0) {
                        Students.setDataFromFile(studrecord.get(0));
                        GraduateStudents.setgsDataFromFile(studrecord.get(1));
                    }

                }

                else if (menu == 7) {
                    System.out.println("\nSaving into Output File...\n");
                    String out = studList.toString();
                    studrecord.add(out);
                    System.out.println(out);
                    String gout = gStudList.toString();
                    studrecord.add(gout);
                    System.out.println(gout);

                    File students = new File("students.txt");
                    try {
                        FileWriter fw = new FileWriter(students);
                        Writer output = new BufferedWriter(fw);
                        for (int i = 0; i < studrecord.size(); i++) {
                            output.write(studrecord.get(i).toString() + "\n");
                        }
                        output.close();
                        System.out.println("\nFile Saved Successfully!");
                    } catch (IOException e) {
                        System.out.println("\nSomething Went Wrong, Cannot Open File.\n");
                    }
                }

                else if (menu == 8) {
                    System.out.println("\nHave a Nice Day!\n");
                    System.exit(0);
                }
            } else {
                System.out.println("\nPlease enter a Vaild Choice ( A number from 1 to 8 )\n");
            }
        }
    }
}