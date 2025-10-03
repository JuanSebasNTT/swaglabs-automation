package com.swaglabs.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target CHECKOUT_BUTTON =
            Target.the("checkout button").located(By.id("checkout"));

    public static Target cartItem(String productName) {
        return Target.the("cart item " + productName)
                .located(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
    }

    // Verificar que hay items en el carrito
    public static final Target CART_ITEMS =
            Target.the("cart items").located(By.className("cart_item"));
}