package utils;

/**
 *
 * Created by andrei-sandu on 18/02/17.
 */
public class InputFormat {

    private String[] headerList;

    public InputFormat(String[] headerList) {
        this.headerList = headerList;
    }

    public String getHeaderForColumnAt(int columnIndex) {
        return this.headerList[columnIndex].toLowerCase();
    }
}
