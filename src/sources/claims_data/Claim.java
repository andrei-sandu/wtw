package claims_data;

/**
 *
 * Created by andrei-sandu on 19/02/17.
 */
public class Claim {

    private String productName;
    private int originYear;
    private int developmentYear;
    private double claimValue;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getOriginYear() {
        return originYear;
    }

    public void setOriginYear(int originYear) {
        this.originYear = originYear;
    }

    public int getDevelopmentYear() {
        return developmentYear;
    }

    public void setDevelopmentYear(int developmentYear) {
        this.developmentYear = developmentYear;
    }

    public double getClaimValue() {
        return claimValue;
    }

    public void setClaimValue(double claimValue) {
        this.claimValue = claimValue;
    }

    public Claim(String productName, int originYear, int developmentYear, double claimValue) {
        this.productName = productName;
        this.originYear = originYear;
        this.developmentYear = developmentYear;
        this.claimValue = claimValue;
    }

}
