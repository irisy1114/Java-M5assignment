package edu.wctc;

public class FloridaFormatter implements DriversLicenseFormatter{

    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {
        String ssss = driversLicense.getSSSS();
        String fff = String.valueOf(driversLicense.getFFF());
        String yy = String.valueOf(driversLicense.getYY());
        String ddd = String.format("%03d", (driversLicense.getDDD()));
        String n = Integer.toString(driversLicense.getNN());

        return String.format("%s-%s-%s-%s-%s", ssss, fff, yy, ddd, n);
    }
}
