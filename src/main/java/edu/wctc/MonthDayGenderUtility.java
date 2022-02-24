package edu.wctc;

public class MonthDayGenderUtility {
    private final int MOD_MALE = 0;
    private final int MOD_FEMALE = 500;
    private final char CODE_MALE = 'M';
    private final char CODE_FEMALE = 'F';

    public int encodeMonthDayGender(int month, int day, int year, char genderCode) throws UnknownGenderCodeException, InvalidBirthdayException {
        if (genderCode != CODE_MALE && genderCode != CODE_FEMALE) {
            throw new UnknownGenderCodeException(genderCode);
        }

        if(!isValidDate(year,month,day))
            throw new InvalidBirthdayException(month, day, year);

        if (genderCode == 'M') {
            return (month - 1) * 40 + day + 0;
        }
        return (month - 1) * 40 + day + 500;
    }

    static int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static boolean isValidDate(int year, int month, int day) {
        try {
            if (year <= 0)
                return false;
            if (month <= 0 || month > 12)
                return false;
            if (day <= 0 || day > DAYS[month])
                return false;
            if (month == 2 && day == 29 && !isGregorianLeapYear(year)) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    static final boolean isGregorianLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
