import java.util.ArrayList;

public class Test extends Product{
    public Test(String productID, String productName, double productPrice) {
        super(productID, productName, productPrice);
    }

    public static void main(String[] args) {
        ArrayList<Product> band = new ArrayList<>();
        Test test1 = new Test("id1","name1",111);
        Test test2 = new Test("id2","name2",222);
        Test test3 = new Test("id3","name3",333);

        band.add (test1);
        band.add (test2);
        band.add (test3);

        System.out.println (band);

        band.remove (band.contains("id1"));

//
//        System.out.println (band);
//        System.out.println ("At index 1: " + band.get(1));
//
//        band.add (2, "Ringo");
//
//        System.out.println (band);
//        System.out.println ("Size : " + band.size());


    }
}
