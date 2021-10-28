import java.util.ArrayList;

public class GraduateStudents extends Students {

    static ArrayList<String> gsprogram = new ArrayList<>();
    static ArrayList<Integer> gsyearsworked = new ArrayList<>();
    static ArrayList<Float> gsaverage = new ArrayList<>();
    static ArrayList<String> supervisor = new ArrayList<>();
    static ArrayList<Integer> isPHD = new ArrayList<>();
    static ArrayList<String> undergradSchool = new ArrayList<>();

    String gclassstr = "";

    @Override
    void getStudentInfo() {
        System.out.println("\nEnter Student Program and the years worked on Graduate Degree : ");
        scan.skip("\\R?");
        String[] info = scan.nextLine().split(" ");
        if ((!info[0].equals(null) || !info[info.length - 1].equals(null))
                && (!info[0].equals("") && !info[info.length - 1].equals("")) && info.length >= 2) {
            gsprogram.add(info[0]);
            gsyearsworked.add(Integer.parseInt(info[info.length - 1]));

            System.out.print("Enter Average grade, or leave blank: ");
            String grade = scan.nextLine();
            if (grade.length() == 0) {
                gsaverage.add(0.0f);
            } else {
                gsaverage.add(Float.parseFloat(grade));
            }
            System.out.print("Enter the Name of the Supervisor: ");
            String supname = scan.nextLine();
            if (supname.length() != 0) {
                supervisor.add(supname);
            } else {
                System.out.println("\nSupervisor Name is Mandatory and Cannot be left Blank.");
                return;
            }
            System.out.print("Enter whether student is PHD or not (Enter 1 for Yes and 0 for No): ");
            int isphd = scan.nextInt();
            if (isphd == 1 || isphd == 0) {
                isPHD.add(isphd);
            } else {
                System.out.println("\nPlease Enter either 1 or 0 ( 1 for Yes and 0 for No )");
                return;
            }
            System.out.print("Enter the Name of Undergraduate School or leave blank: ");
            scan.skip("\\R?");
            String ugsname = scan.nextLine();
            if (ugsname.length() == 0) {
                undergradSchool.add("Not_Mentioned");
            } else {
                undergradSchool.add(ugsname);
            }
        } else {
            System.out.println("\nUh Oh! The input is incorrect. Please enter your choice again.");
            System.out.println(
                    "Your Input should be the Program Name(text only) and Year(integer number only) and should not be blank.\n");
        }
    }

    @Override
    void displayStudentInfo() {
        if (gsprogram.size() > 0) {
            for (int i = 0; i < gsprogram.size(); i++) {
                System.out.println("\nGraduate Student " + (i + 1));
                System.out.println("Program : " + gsprogram.get(i));
                System.out.println("Year : " + gsyearsworked.get(i));
                System.out.println("Average Grade : " + gsaverage.get(i));
                System.out.println("Supervisor Name : " + supervisor.get(i));
                System.out.println("Is student a PHD ? : " + ((isPHD.get(i) == 1) ? " Yes " : " No "));
                System.out.println("Name of the Undergraduate School Attended: " + undergradSchool.get(i));
            }
        } else {
            System.out.println("\nNo Graduate Student Data Available");
        }
    }

    @Override
    void AverageTotal() {
        float avg = 0.0f;
        float avgSum = 0.0f;
        int totalStud = 0;
        for (int i = 0; i < gsprogram.size(); i++) {
            avgSum += gsaverage.get(i);
            totalStud++;
        }
        avg = avgSum / totalStud;
        System.out.println("\nGRADUATE STUDENTS");
        System.out.println("Average of the average grades for the class: " + avg);
        System.out.println("Total number of Graduate students : " + totalStud);
    }

    @Override
    void programInfo() {
        System.out.print("Enter the program name for which Graduate Student Information is needed: ");
        scan.skip("\\R?");
        String specificp = scan.nextLine();
        for (int i = 0; i < gsprogram.size(); i++) {
            if (gsprogram.get(i).equals(specificp)) {
                System.out.println("Number of Years Worked on Graduate Degree : " + gsyearsworked.get(i));
                System.out.println("Average Grade : " + gsaverage.get(i));
            }
        }
    }

    @Override
    public String toString() {
        for (int i = 0; i < gsprogram.size(); i++) {
            gclassstr += gsprogram.get(i) + " " + gsyearsworked.get(i) + " " + gsaverage.get(i) + " "
                    + supervisor.get(i) + " " + isPHD.get(i) + " " + undergradSchool.get(i)
                    + ((i == gsprogram.size() - 1) ? "" : "-");
        }
        return gclassstr;
    }

    static void setgsDataFromFile(String dataa) {
        gsprogram.clear();
        gsyearsworked.clear();
        gsaverage.clear();
        supervisor.clear();
        isPHD.clear();
        undergradSchool.clear();
        String[] dataarrr = dataa.split("-");
        for (int i = 0; i < dataarrr.length; i++) {
            String[] dataitems = dataarrr[i].split(" ");
            if (dataitems.length == 6) {
                gsprogram.add(dataitems[0]);
                int yr = Integer.parseInt(dataitems[1]);
                gsyearsworked.add(yr);
                float avg = Float.parseFloat(dataitems[2]);
                gsaverage.add(avg);
                supervisor.add(dataitems[3]);
                int isphdd = Integer.parseInt(dataitems[4]);
                isPHD.add(isphdd);
                undergradSchool.add(dataitems[5]);
            }
        }

    }

}
