import claims_data.DevelopmentSequence;
import claims_data.IncrementalClaim;
import utils.HeaderFormatException;
import utils.InputParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * Created by andrei-sandu on 18/02/17.
 */
public class TriangleMain {
    public static void main(String[] args) {
        try {
            InputParser inputParser = new InputParser("src/input.txt");
            // get earliest origin year
            // get max development years

            // get product names
            // for each product get origin years

            HashMap<String, ArrayList<Integer>> productsToOriginYearMap;
            HashMap<Integer, ArrayList<IncrementalClaim>> developmentSequence;
                // origin year to list of incremental claims

            //Build the two up there, iterate through each name, through each devSequence, through each Incremental claim and add them up

        } catch (IOException | HeaderFormatException e) {
            e.printStackTrace();
        }
    }
}
