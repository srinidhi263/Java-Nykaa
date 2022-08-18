import java.util.ArrayList;
import java.util.Scanner;

public class NykaaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalAmount = 0;
        System.out.println("Nykaa");
        while (true) {
            ArrayList<Category> categories = new ArrayList<>();
            //skin

            Category skinCategory = new Category(1, "Skin");
            ArrayList<Product> skinProducts = new ArrayList<>();
            skinProducts.add(new Product(1, "Toner", 450));
            skinProducts.add(new Product(2, "Serum", 550));
            skinProducts.add(new Product(3, "Moisturizer", 700));
            skinCategory.setProducts(skinProducts);
            categories.add(skinCategory);

            //eye
            Category eyeCategory = new Category(2, "Eye");
            ArrayList<Product> eyeProducts = new ArrayList<>();
            eyeProducts.add(new Product(1, "Kajal", 250));
            eyeProducts.add(new Product(2, "Liner", 700));
            eyeProducts.add(new Product(3, "Eyeshadow", 300));
            eyeCategory.setProducts(eyeProducts);
            categories.add(eyeCategory);

            // Lip Care
            Category lipCategory = new Category(3, "LipCare");
            ArrayList<Product> lipProducts = new ArrayList<>();
            lipProducts.add(new Product(1, "LipBalm", 400));
            lipProducts.add(new Product(2, "Gloss", 500));
            lipProducts.add(new Product(3, "LipStick", 700));
            lipCategory.setProducts(lipProducts);
            categories.add(lipCategory);

            //Make Over
            Category makeCategory = new Category(4, "MakeOver");
            ArrayList<Product> makeProducts = new ArrayList<>();
            makeProducts.add(new Product(1, "Concealer", 700));
            makeProducts.add(new Product(2, "Primer", 800));
            makeProducts.add(new Product(3, "Blush", 700));
            makeCategory.setProducts(makeProducts);
            categories.add(makeCategory);


            System.out.println("Categories:" + " \n Press 5 to exit!");

            categories.forEach(category -> {
                System.out.println(category.getId() + "." + category.getName());
            });

            System.out.println("enter your choice: ");

            int catChoice = sc.nextInt();
            if (catChoice == 5) {

                System.out.println("Exit");
                break;

            }
            Category selectedCategory = categories.get(catChoice - 1);

            selectedCategory.getProducts().forEach(product -> {
                System.out.println(product.getId() + "." + product.getProductName());
            });

            System.out.println("enter your product: ");
            int productChoice = sc.nextInt();
            Product selectedProduct = selectedCategory.getProducts().get(productChoice - 1);
            System.out.println(selectedProduct.getProductName() + " - " + selectedProduct.getPrice());

            int amount = selectedProduct.getPrice();
        totalAmount = totalAmount + amount;
        }
        System.out.println("Total amount = " + totalAmount);
        System.out.println(" Confirm purchase ?: ");
        String str = sc.next();
        System.out.println("Thank you for your purchase!");


    }

}