package com.swaglabs.steps.definitions;

import com.swaglabs.steps.CompraSteps;
import com.swaglabs.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class CompraStepDefinitions {

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private CompraSteps compraSteps;

    // ✅ MANTENER TODOS TUS MÉTODOS EXISTENTES
    @Dado("^que he iniciado sesión en Saucedemo con usuario \"(.*)\" y contraseña \"(.*)\"$")
    public void queHeIniciadoSesion(String usuario, String contraseña) {
        loginSteps.navegarAPaginaLogin();
        loginSteps.iniciaSesionConCredenciales(usuario, contraseña);
        loginSteps.verificaLoginExitoso();
    }

    @Cuando("agrego dos productos al carrito")
    public void agregoDosProductosAlCarrito() {
        compraSteps.agregaDosProductosAlCarrito();
    }

    @Y("visualizo el carrito")
    public void visualizoElCarrito() {
        compraSteps.visualizaElCarrito();
    }

    @Y("completo el formulario de compra")
    public void completoElFormularioDeCompra() {
        compraSteps.completaElFormularioDeCompra();
    }

    // ✅ AGREGAR ESTE NUEVO MÉTODO (NO ELIMINAR EL ANTERIOR)
    @Y("completo el formulario de compra con {string} {string} {string}")
    public void completoElFormularioDeCompraCon(String nombre, String apellido, String codigoPostal) {
        compraSteps.completaElFormularioDeCompraCon(nombre, apellido, codigoPostal);
    }

    @Y("finalizo la compra")
    public void finalizoLaCompra() {
        compraSteps.finalizaLaCompra();
    }

    @Entonces("debo ver el mensaje de confirmación {string}")
    public void deboVerElMensajeDeConfirmacion(String mensaje) {
        compraSteps.debeVerMensajeConfirmacion(mensaje);
    }
}