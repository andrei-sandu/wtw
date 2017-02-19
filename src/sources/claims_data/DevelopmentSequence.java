package claims_data;

/**
 *
 * Created by andrei-sandu on 19/02/17.
 */
public class DevelopmentSequence {

    private String productName;
    private int originYear;

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

    public DevelopmentSequence(String productName, int originYear) {
        this.productName = productName;
        this.originYear = originYear;
    }
}
