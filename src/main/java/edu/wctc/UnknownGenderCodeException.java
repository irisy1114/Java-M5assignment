package edu.wctc;

public class UnknownGenderCodeException extends Exception{
    public UnknownGenderCodeException (char genderCode) {
        System.out.printf("The gender %c is not known. \n", genderCode);
    }
}
