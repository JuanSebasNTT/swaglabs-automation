package com.swaglabs.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {
    public static final Target PRODUCTS_TITLE =
            Target.the("products title").located(By.className("title"));

    // USAR IDs ESPECIFICOS en lugar de XPath genericos
    public static final Target BACKPACK_ADD_TO_CART =
            Target.the("add backpack to cart").located(By.id("add-to-cart-sauce-labs-backpack"));
    public static final Target BOLT_TSHIRT_ADD_TO_CART =
            Target.the("add bolt tshirt to cart").located(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));

    public static final Target SHOPPING_CART =
            Target.the("shopping cart").located(By.className("shopping_cart_link"));

    // Metodo mejorado para agregar productos por nombre
    public static Target addToCartButton(String productName) {
        switch (productName) {
            case "Sauce Labs Backpack":
                return BACKPACK_ADD_TO_CART;
            case "Sauce Labs Bolt T-Shirt":
                return BOLT_TSHIRT_ADD_TO_CART;
            case "Sauce Labs Bike Light":
                return Target.the("add bike light to cart").located(By.id("add-to-cart-sauce-labs-bike-light"));
            case "Sauce Labs Fleece Jacket":
                return Target.the("add fleece jacket to cart").located(By.id("add-to-cart-sauce-labs-fleece-jacket"));
            case "Sauce Labs Onesie":
                return Target.the("add onesie to cart").located(By.id("add-to-cart-sauce-labs-onesie"));
            default:
                return BACKPACK_ADD_TO_CART; // fallback
        }
    }
}