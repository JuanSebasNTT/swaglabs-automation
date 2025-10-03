package com.swaglabs.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarritoPage extends PageObject {

    @FindBy(id = "checkout")
    private WebElementFacade checkoutButton;

    @FindBy(className = "cart_item")
    private List<WebElementFacade> itemsEnCarrito;

    @FindBy(className = "title")
    private WebElementFacade tituloPagina;

    public void procederAlCheckout() {
        checkoutButton.click();
    }

    public int obtenerCantidadItems() {
        return itemsEnCarrito.size();
    }

    public boolean estaEnCarrito() {
        return tituloPagina.isVisible() &&
                tituloPagina.getText().equals("Your Cart");
    }
}