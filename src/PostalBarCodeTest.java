public class PostalBarCodeTest {
    public static void main(String[] args) {
        //creates an object newTrial of the class PostalBarCode
        PostalBarCode newTrial = new PostalBarCode();
        //Prints and tests the getZipCode method with the given Bar Code
        System.out.println("The zip code is " + newTrial.getZipCode("|:|:|::|::||:|::::|:|:::|||:|::|"));
        //Tests the showError method to determine if errors were done
        newTrial.showError();
        //Prints and tests the getBarCode method with the given ZIP code
        System.out.println();
        System.out.println("The bar code representation of the zip code is : " + newTrial.getBarCode(76531));
    }
}


// SAMPLE RUN # 1
//The zip code is 92395
//        Based on the checksum, the zipcode is valid
//
//        The bar code representation of the zip code is : ||:|:::::||::||::|::|:|:|:|::|:|
//
//        Process finished with exit code 0


// SAMPLE RUN # 2
//The zip code is 91295
//        Based on the checksum, the zipcode is valid
//
//        The bar code representation of the zip code is : |:|:|::||:::|::|::|:|:::||::|:||
//
//        Process finished with exit code 0

// SAMPLE RUN # 3
//The zip code is 73411
//        Based on the checksum, the zipcode is valid
//
//        The bar code representation of the zip code is : |:||:::|::|::|:||::|::|:|::|:|:|
//
//        Process finished with exit code 0


// SAMPLE RUN # 4
//The zip code is 73411
//        The zipcode is invalid because of an incorrect checksum
//
//        The bar code representation of the zip code is : ||:::|:||:::|:|:::||::::|||::|:|
//
//        Process finished with exit code 0

