package claims_data;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * Created by andrei-sandu on 19/02/17.
 */
public class IncrementalClaim {

    private int year;
    private double claimValue;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getClaimValue() {
        return claimValue;
    }

    public void setClaimValue(double claimValue) {
        this.claimValue = claimValue;
    }

    public IncrementalClaim(int year, double claimValue) {

        this.year = year;
        this.claimValue = claimValue;
    }

}