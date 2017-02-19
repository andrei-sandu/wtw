package utils;

import claims_data.Claim;

import java.io.*;
import java.util.Arrays;

/**
 *
 * Created by andrei-sandu on 18/02/17.
 */
public class InputParser {

    private FileReader inputSource;
    private BufferedReader bufferedReader;
    private InputFormat inputFormat;
    private int lineNumber;

    private final String[] VALID_HEADERS = {"product", "origin year", "development year", "incremental value"};

    public InputParser(String inputPath) throws IOException, HeaderFormatException {
        File inputFile = new File(inputPath);
        this.inputSource = new FileReader(inputFile);
        this.bufferedReader = new BufferedReader(inputSource);
        String headers;
        initializeInputFormat();
        this.lineNumber = 1;
    }

    public Claim getNextClaim() throws IOException, LineFormatException {
        this.lineNumber++;
        String nextInputData = this.bufferedReader.readLine();
        if (nextInputData == null) {
            return null;
        }
        String[] claimDetails = parseLine(nextInputData);
        if (claimDetails.length != VALID_HEADERS.length) {
            throw new LineFormatException("Invalid input length", this.lineNumber);
        }

        // initialized to -1; will take the values from the input or the method will throw a line format exception
        int originYear = -1;
        int developmentYear = -1;
        double claimValue = -1;
        String productName = "";
        for (int i = 0; i < claimDetails.length; i++) {
            switch(this.inputFormat.getHeaderForColumnAt(i)) {
                case "product": productName = claimDetails[i]; break;
                case "origin year":
                    try {
                        originYear = Integer.valueOf(claimDetails[i]);
                        break;
                    } catch(NumberFormatException e) {
                        throw new LineFormatException("Invalid origin year", this.lineNumber);
                    }
                case "development year":
                    try {
                        developmentYear = Integer.valueOf(claimDetails[i]);
                        break;
                    } catch(NumberFormatException e) {
                        throw new LineFormatException("Invalid development year", this.lineNumber);
                    }
                default:
                    try {
                        claimValue = Double.valueOf(claimDetails[i]);
                        break;
                    } catch(NumberFormatException e) {
                        throw new LineFormatException("Invalid claimed value", this.lineNumber);
                    }
            }
        }
        if (originYear > developmentYear) {
            throw new LineFormatException("Development year cannot be before origin year", this.lineNumber);
        }

        if (claimValue < 0.0) {
            throw new LineFormatException("Value claimed must be positive", this.lineNumber);
        }
        return new Claim(productName, originYear, developmentYear, claimValue);
    }

    public void done() throws IOException {
        this.inputSource.close();
    }

    private void initializeInputFormat() throws IOException, HeaderFormatException {
        String headers;
        if ((headers = bufferedReader.readLine()) == null) {
            throw new HeaderFormatException("Empty input file provided, cannot initialize input format.");
        } else {
            String[] parsedHeaders = parseLine(headers);
            if (!checkHeadersValidFormat(parsedHeaders)) {
                throw new HeaderFormatException("Cannot parse input file with headers: " + headers);
            }
            this.inputFormat = new InputFormat(parsedHeaders);
        }
    }

    private String[] parseLine(String line) {
        return line.split(",+\\s*"); // TODO at least one comma and any spaces, because reasons
    }

    private boolean checkHeadersValidFormat(String[] parsedHeaders) {
        for (String header : parsedHeaders) {
            if (!Arrays.asList(VALID_HEADERS).contains(header.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

}
