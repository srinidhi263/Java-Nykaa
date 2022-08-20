package Utils;

import model.Category;
import model.Product;
import java.util.ArrayList;

public class CategoryUtils {
    private ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void load() {
        //eye
        Category eyeCategory = new Category();
        eyeCategory.setId(1);
        eyeCategory.setName("Eye");
        ArrayList<Product> eyeProducts = new ArrayList<>();
        eyeProducts.add(new Product(1, "Kajal", 250));
        eyeProducts.add(new Product(2, "Liner", 700));
        eyeProducts.add(new Product(3, "Eyeshadow", 300));
        eyeCategory.setProducts(eyeProducts);
        categories.add(eyeCategory);
        //skin
        Category skinCategory = new Category();
        skinCategory.setId(2);
        skinCategory.setName("Skin");
        ArrayList<Product> skinProducts = new ArrayList<>();
        skinProducts.add(new Product(1, "Toner", 450));
        skinProducts.add(new Product(2, "Serum", 550));
        skinProducts.add(new Product(3, "Moisturizer", 700));
        skinCategory.setProducts(skinProducts);
        categories.add(skinCategory);
        //lipCare
        Category lipCategory = new Category();
        lipCategory.setId(3);
        lipCategory.setName("LipCare");
        ArrayList<Product> lipCareProducts = new ArrayList<>();
        lipCareProducts.add(new Product(1, "LipBalm", 400));
        lipCareProducts.add(new Product(2, "Gloss", 500));
        lipCareProducts.add(new Product(3, "LipStick", 700));
        lipCategory.setProducts(lipCareProducts);
        categories.add(lipCategory);
        //makeover
        Category makeCategory = new Category();
        makeCategory.setId(4);
        makeCategory.setName("MakeOver");
        ArrayList<Product> makeOverProducts = new ArrayList<>();
        makeOverProducts.add(new Product(1, "Concealer", 700));
        makeOverProducts.add(new Product(2, "Primer", 800));
        makeOverProducts.add(new Product(3, "Blush", 700));
        makeCategory.setProducts(makeOverProducts);
        categories.add(makeCategory);
    }
}
