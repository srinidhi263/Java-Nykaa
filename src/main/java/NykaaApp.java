import java.util.ArrayList;
import java.util.Scanner;

public class NykaaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        skinCategory.setProducts(eyeProducts);
        categories.add(eyeCategory);

        // Lip Care
        Category lipCategory = new Category(3, "LipCare");
        ArrayList<Product> lipProducts = new ArrayList<>();
        lipProducts.add(new Product(1, "LipBalm", 400));
        lipProducts.add(new Product(2, "Gloss", 500));
        lipProducts.add(new Product(3, "LipStick", 700));
        lipCategory.setProducts(lipProducts);
        categories.add(lipCategory);


        categories.forEach(category -> {
            System.out.println(category.getId() + "." + category.getName());
        });

        System.out.println("enter your choice: ");

        int catChoice = sc.nextInt();
        Category selectedCategory = categories.get(catChoice - 1);

        selectedCategory.getProducts().forEach(product -> {
            System.out.println(product.getId() + "." + product.getProductName());
        });

        System.out.println("enter your product: ");
        int productChoice = sc.nextInt();
        Product selectedProduct = skinProducts.get(productChoice - 1);

        int amount = selectedProduct.getPrice();


//////////////////////////--

        int a = sc.nextInt();
        if (a == 5) {
            System.out.println("Exit");
        }

        System.out.println(" Confirm purchase ?: ");
        String str = sc.next();
        System.out.println("Thank you for your purchase!");


    }

}