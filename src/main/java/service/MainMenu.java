package service;

import Utils.CategoryUtils;
import Utils.UserUtils;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu implements MainMenuInterface {

    private UserUtils userUtils;
    private CategoryUtils categoryUtils;
    private Auth auth;

    public MainMenu(UserUtils userUtils, CategoryUtils categoryUtils, Auth auth) {
        this.auth = auth;
        this.userUtils = userUtils;
        this.categoryUtils = categoryUtils;
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select an option");

        System.out.println("1. Categories");
        System.out.println("2. Cart");
        System.out.println("3. Order History");
        System.out.println("4. Logout");

        int choice = sc.nextInt();

        if (choice == 1) {
            showCategories();
        } else if (choice == 2) {
            showCart();
        } else if (choice == 3) {
            showHistory();
        } else if (choice == 4) {
            auth.printAuthMenu();
        } else {
            System.out.println("Invalid choice");
        }
    }

    @Override
    public void showHistory() {
        ArrayList<OrderHistory> orderHistories = userUtils.getLoggedInUser().getOrderHistories();
        System.out.println("***HISTORY***");

        if (orderHistories.size() > 0) {
            orderHistories.forEach(orderHistory -> {
                orderHistory.getProducts().forEach(product -> {
                    System.out.println(product.getProductName() + " - Rs." + product.getPrice());
                });
                System.out.println("Total - " + orderHistory.getTotalPrice());
            });
        } else {
            System.out.println("No orders");
        }

    }


    @Override
    public void showCart() {
        Scanner sc = new Scanner(System.in);
        Cart cart = userUtils.getLoggedInUser().getCart();
        ArrayList<Product> products = cart.getProducts();
        System.out.println("***CART***");
        if (products.size() > 0) {
            products.forEach(product -> System.out.println(product.getProductName() + " - Rs." + product.getPrice()));
            System.out.println("Total: " + cart.getTotalAmount());

            System.out.println("Do You Want to Proceed Further?");
            System.out.println("1.Yes");
            System.out.println("2.No");
            int choice = sc.nextInt();
            if (choice == 1) {

                User loggedInUser = userUtils.getLoggedInUser();

                ArrayList<OrderHistory> orderHistories = loggedInUser.getOrderHistories();

                OrderHistory orderHistory = new OrderHistory();
                orderHistory.setId(orderHistories.size() + 1);
                orderHistory.setTotalPrice(cart.getTotalAmount());
                orderHistory.setProducts(cart.getProducts());

                orderHistories.add(orderHistory);

                loggedInUser.setCart(new Cart());

                System.out.println("order successful");
                mainMenu();

            } else if (choice == 2) {
                mainMenu();
            } else {
                System.out.println("Invalid choice");
                showCart();
            }


        } else {
            System.out.println("No items in the cart");
            mainMenu();
        }
    }


    @Override
    public void showCategories() {
        Scanner sc = new Scanner(System.in);

        ArrayList<Category> categories = categoryUtils.getCategories();

        System.out.println("Categories");
        System.out.println("----------");
        categories.forEach(category -> System.out.println(category.getId() + ". " + category.getName()));
        System.out.println("99. Back");

        System.out.println("Select an option");

        int catChoice = sc.nextInt();

        if (catChoice <= categories.size() || catChoice == 99) {
            if (catChoice != 99) {
                Category selectedCategory = categories.get(catChoice - 1);

                ArrayList<Product> products = selectedCategory.getProducts();

                System.out.println(selectedCategory.getName() + " Products");
                System.out.println("----------");
                products.forEach(product -> System.out.println(product.getId() + ". " + product.getProductName() + " - Rupees" + product.getPrice()));
                System.out.println("99. Back");

                System.out.println("Select a product");
                int productChoice = sc.nextInt();

                if (productChoice <= products.size() || productChoice == 99) {
                    if (productChoice != 99) {
                        Product selectedProduct = products.get(productChoice - 1);
                        User loggedInUser = userUtils.getLoggedInUser();
                        Cart cart = loggedInUser.getCart();
                        if (cart == null) {
                            cart = new Cart();
                        }

                        ArrayList<Product> cartProducts = cart.getProducts();
                        cartProducts.add(selectedProduct);

                        int amount = 0;
                        for (Product product : cartProducts) {
                            amount = amount + product.getPrice();
                        }
                        cart.setTotalAmount(amount);
                        loggedInUser.setCart(cart);
                        System.out.println("Product added to cart");
                    }
                    showCategories();
                }
            }
            mainMenu();
        } else {
            System.out.println("Invalid Choice!");
        }
    }
}
