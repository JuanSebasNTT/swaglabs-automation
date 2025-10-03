package com.swaglabs.steps;

import com.swaglabs.pages.CarritoPage;
import com.swaglabs.pages.CheckoutPage;
import com.swaglabs.pages.ConfirmacionPage;
import com.swaglabs.pages.ProductosPage;
import com.swaglabs.pages.ResumenCompraPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class CompraSteps extends ScenarioSteps {

    private ProductosPage productosPage;
    private CarritoPage carritoPage;
    private CheckoutPage checkoutPage;
    private ResumenCompraPage resumenCompraPage;
    private ConfirmacionPage confirmacionPage;

    // ✅ MANTENER TODOS TUS MÉTODOS EXISTENTES
    @Step("Agrega dos productos al carrito")
    public void agregaDosProductosAlCarrito() {
        productosPage.agregarPrimerosDosProductos();
        waitFor(2).seconds();

        int cantidadEnCarrito = productosPage.obtenerCantidadEnCarrito();
        assertThat(cantidadEnCarrito).isEqualTo(2);
    }

    @Step("Visualiza el carrito")
    public void visualizaElCarrito() {
        productosPage.irAlCarrito();
        waitFor(2).seconds();

        int itemsEnCarrito = carritoPage.obtenerCantidadItems();
        assertThat(itemsEnCarrito).isEqualTo(2);
    }

    @Step("Completa el formulario de compra")
    public void completaElFormularioDeCompra() {
        carritoPage.procederAlCheckout();
        checkoutPage.completarInformacionPersonal("Juan", "Perez", "12345");
        checkoutPage.continuar();
    }

    // ✅ AGREGAR ESTE NUEVO MÉTODO (NO ELIMINAR EL ANTERIOR)
    @Step("Completa el formulario de compra con {0} {1}")
    public void completaElFormularioDeCompraCon(String nombre, String apellido, String codigoPostal) {
        carritoPage.procederAlCheckout();
        checkoutPage.completarInformacionPersonal(nombre, apellido, codigoPostal);
        checkoutPage.continuar();
    }

    @Step("Finaliza la compra")
    public void finalizaLaCompra() {
        resumenCompraPage.verificarResumen();
        resumenCompraPage.finalizarCompra();
    }

    @Step("Debe ver el mensaje de confirmación: {0}")
    public void debeVerMensajeConfirmacion(String mensajeEsperado) {
        confirmacionPage.verificarMensajeConfirmacion(mensajeEsperado);
        assertThat(confirmacionPage.mensajeConfirmacionEsVisible()).isTrue();
    }
}