public class PostalBarCodeTest {
    public static void main(String[] args) {
        PostalBarCode newTrial = new PostalBarCode();
        System.out.println("The zip code is " + newTrial.getZipCode("||:|::::|:|::||:|:|:::|:|:::|:||"));
        newTrial.showError();
        System.out.println(newTrial.getBarCode(92395));



    }
}
