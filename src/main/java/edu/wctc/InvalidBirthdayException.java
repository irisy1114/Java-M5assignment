package edu.wctc;

public class InvalidBirthdayException extends Exception{

    public InvalidBirthdayException(int month, int day, int year) {
        System.out.printf("The date %d/%d/%d is invalid\n", month, day, year);
    }
}
