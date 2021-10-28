import java.util.ArrayList;
import java.util.Scanner;

public class Students {

    Scanner scan = new Scanner(System.in);

    static ArrayList<String> program = new ArrayList<>();
    static ArrayList<Integer> year = new ArrayList<>();
    static ArrayList<Float> average = new ArrayList<>();

    String classstr = "";

    void getStudentInfo() {
        System.out.println("\nEnter Student Program and Year for the Student: ");
        scan.skip("\\R?");
        String[] info = scan.nextLine().split(" ");
        if ((!info[0].equals(null) || !info[info.length - 1].equals(null))
                && (!info[0].equals("") && !info[info.length - 1].equals("")) && info.length >= 2) {
            program.add(info[0]);
            year.add(Integer.parseInt(info[info.length - 1]));

            System.out.print("Enter Average grade, or leave blank: ");
            String grade = scan.nextLine();
            if (grade.length() == 0) {
                average.add(0.0f);
            } else {
                average.add(Float.parseFloat(grade));
            }
        } else {
            System.out.println("\nUh Oh! The input is incorrect. Please enter your choice again.");
            System.out.println(
                    "Your Input should be the Program Name(text only) and Year(integer number only) and should not be blank.\n");
        }
    }

    void displayStudentInfo() {
        if (program.size() > 0) {
            for (int i = 0; i < program.size(); i++) {
                System.out.println("\nStudent " + (i + 1));
                System.out.println("Program : " + program.get(i));
                System.out.println("Year : " + year.get(i));
                System.out.println("Average Grade : " + average.get(i));
            }
        } else {
            System.out.println("\nNo Student Data Available");
        }
    }

    void AverageTotal() {
        float avg = 0.0f;
        float avgSum = 0.0f;
        int totalStud = 0;
        for (int i = 0; i < program.size(); i++) {
            avgSum += average.get(i);
            totalStud++;
        }
        avg = avgSum / totalStud;
        System.out.println("\nUNDERGRADUATE STUDENTS");
        System.out.println("Average of the average grades for the class: " + avg);
        System.out.println("Total number of students : " + totalStud);
    }

    void programInfo() {
        System.out.print("\nEnter the program name for which Student Information is needed: ");
        scan.skip("\\R?");
        String specificp = scan.nextLine();
        for (int i = 0; i < program.size(); i++) {
            if (program.get(i).equals(specificp)) {
                System.out.println("Year : " + year.get(i));
                System.out.println("Average Grade : " + average.get(i));
            }
        }
    }

    public String toString() {
        for (int i = 0; i < program.size(); i++) {
            classstr += program.get(i) + " " + year.get(i) + " " + average.get(i)
                    + ((i == program.size() - 1) ? "" : "-");
        }
        return classstr;
    }

    static void setDataFromFile(String data) {
        program.clear();
        year.clear();
        average.clear();
        String[] dataarr = data.split("-");
        for (int i = 0; i < dataarr.length; i++) {
            String[] dataitems = dataarr[i].split(" ");
            if (dataitems.length == 3) {
                program.add(dataitems[0]);
                int yr = Integer.parseInt(dataitems[1]);
                year.add(yr);
                float avg = Float.parseFloat(dataitems[2]);
                average.add(avg);
            }
        }
    }
}