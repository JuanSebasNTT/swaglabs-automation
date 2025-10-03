package com.swaglabs.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductosPage extends PageObject {

    @FindBy(className = "inventory_item")
    private List<WebElementFacade> productos;

    @FindBy(className = "shopping_cart_link")
    private WebElementFacade carritoIcon;

    @FindBy(className = "title")
    private WebElementFacade tituloPagina;

    public void agregarPrimerosDosProductos() {
        if (productos.size() > 0) {
            productos.get(0).findBy(".btn_inventory").click();
        }
        if (productos.size() > 1) {
            productos.get(1).findBy(".btn_inventory").click();
        }
    }

    public void irAlCarrito() {
        carritoIcon.click();
    }

    public int obtenerCantidadEnCarrito() {
        try {
            String texto = carritoIcon.getText();
            return texto.isEmpty() ? 0 : Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public boolean estaCargada() {
        return tituloPagina.isVisible() &&
                tituloPagina.getText().equals("Products");
    }

    public String obtenerTitulo() {
        return tituloPagina.getText();
    }
}