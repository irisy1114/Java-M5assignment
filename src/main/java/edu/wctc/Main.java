package edu.wctc;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Middle initial: ");
        String middleInitial = scanner.nextLine().toUpperCase();
        System.out.print("First name: ");
        String firstName = scanner.nextLine().toUpperCase();
        System.out.print("Month of birth (1-12): ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Day of birth (1-31): ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Year of birth (YYYY): ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Gender (M/F): ");
        char gender = scanner.nextLine().toUpperCase().charAt(0);


        try {
            DriversLicense driversLicense = new DriversLicense();
            LastNameUtility ls = new LastNameUtility();
            driversLicense.setSSSS(ls.encodeLastName(lastName));

            FirstNameUtility fn = new FirstNameUtility();
            driversLicense.setFFF(fn.encodeFirstName(firstName, middleInitial));

            // The last two digits of birth year
            int lastTwoDigits = year % 100;
            driversLicense.setYY(lastTwoDigits);

            MonthDayGenderUtility md = new MonthDayGenderUtility();
            driversLicense.setDDD(md.encodeMonthDayGender(month, day, year, gender));

            // wisconsin driver license output
            WisconsinFormatter wi = new WisconsinFormatter();
            driversLicense.setNN(00);
            System.out.printf("Wisconsin: %s", wi.formatLicenseNumber(driversLicense));
            System.out.println();

            // florida driver license output
            FloridaFormatter fl = new FloridaFormatter();
            driversLicense.setNN(0);
            System.out.printf("Florida: %s", fl.formatLicenseNumber(driversLicense));

        }
        catch (Exception e)
        {
            System.out.println("Invalid input detected. Program will exit.");
        }
    }
}
