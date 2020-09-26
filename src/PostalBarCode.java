import java.util.*;

/**
 *
 * @author Zhuo Guan & Carlo Navata
 *	A Postal Bar Code that takes numbers, validates if it can be
 *	a bar code then creates a bar code
 */

public class PostalBarCode {
    // FROM 0 - 9                    //  0          1       2       3          4           5       6       7         8       9
    private final String[] BarCodes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    private boolean checkSumErrorFound = true;

    /**
     * Reads the the bar code and returns ZIP code of the read bar code
     * @param barCode
     * @return ZIP code
     */
    public int getZipCode(String barCode){
        ArrayList<String> noFrameBars = new ArrayList();
        for (char a : barCode.toCharArray()){
            noFrameBars.add(Character.toString(a));
        }
        noFrameBars.remove(31);
        noFrameBars.remove(0);
        String onlyNumbers = "";

        for (String character : noFrameBars){
            onlyNumbers += character;
        }

        String barCodeNumber = "";
        String zipCodeBarCode = "";
        String barCodeSubstring = "";
        int checkSum = -1;

        for (int i = 0; i < 4;++i){

            int AMOUNT_OF_BAR_CODES = 10;
            barCodeSubstring = onlyNumbers.substring(0,5);
            for (int j = 0; j < AMOUNT_OF_BAR_CODES; j++){
                barCodeNumber = BarCodes[j];
                barCodeSubstring = onlyNumbers.substring(0,5);

                if (barCodeNumber.contains(barCodeSubstring)){

                    if (onlyNumbers.length() > 5){
                        onlyNumbers = onlyNumbers.substring(5);
                        zipCodeBarCode += Integer.toString(j);
                    }
                    else
                        checkSum = j;

                }
            }
        }
        int zipCode = Integer.parseInt(zipCodeBarCode);
        errorChecker(zipCode,checkSum);
        return zipCode;
    }
    /**
     * Reads ZIP Code and returns a Bar Code
     * @param zipCode
     * @return Bar Code of lines and dots
     */
    public String getBarCode(int zipCode){
        String barCode = "|";
        int number = 0;
        ArrayList<String> barCodeList = new ArrayList();

        int zipCodeValue = zipCode;

        while (zipCode > 0){
            number = zipCode % 10;
            barCodeList.add(BarCodes[number]);
            zipCode = zipCode / 10;
        }
        int sum = 0;

        while (zipCodeValue > 0){
            number = zipCodeValue % 10;
            sum += number;
            zipCodeValue = zipCodeValue / 10;
        }

        int checkSum = (10 - (sum % 10));

        for (int i = barCodeList.size() - 1; i >= 0;i--){
            barCode += barCodeList.get(i);
        }
        barCode += BarCodes[checkSum] + "|";

        return barCode;

    }
    /**
     * Validates the user input bar code
     * @param zipCode
     * @param checkSum
     */
    public void errorChecker(int zipCode, int checkSum) {

        String stringZipCode = Integer.toString(zipCode);
        int sum = 0;
        while (zipCode > 0){
            sum += zipCode % 10;
            zipCode = zipCode / 10;
        }
        sum += checkSum;

        if (sum % 10 == 0){
            this.checkSumErrorFound = false;
        }
    }
    /**
     * Validates the user input ZIP code
     */
    public void showError(){
        if (this.checkSumErrorFound == false)
            System.out.println("Based on the checksum, the zipcode is valid");
        else
            System.out.println("The zipcode is invalid because of an incorrect checksum");
    }
}
/**
 * EXAMPLE CODE:
 *  The zip code is 92395
 Based on the checksum, the zipcode is valid
 ||:|:::::||::||::|::|:|:|:|::|:|
 */
