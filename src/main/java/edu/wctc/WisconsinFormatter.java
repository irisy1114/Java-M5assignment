package edu.wctc;

public class WisconsinFormatter implements DriversLicenseFormatter{
    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {
        String ssss = driversLicense.getSSSS();
        String fff = String.valueOf(driversLicense.getFFF());

        String yy = String.valueOf(driversLicense.getYY());
        char[] y = yy.toCharArray();

        String ddd = String.format("%03d", (driversLicense.getDDD()));
        String nn = String.format("%02d",(driversLicense.getNN()));

        return String.format("%s-%s-%s-%s", ssss, fff + y[0], y[1] + ddd, nn);
    }
}
