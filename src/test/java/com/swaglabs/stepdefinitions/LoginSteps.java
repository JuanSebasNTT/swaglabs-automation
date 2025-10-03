package com.swaglabs.steps;

import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductosPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends ScenarioSteps {

    private LoginPage loginPage;
    private ProductosPage productosPage;

    // ✅ MANTENER TODOS TUS MÉTODOS EXISTENTES
    @Step("Inicia sesión con usuario {0} y contraseña {1}")
    public void iniciaSesionConCredenciales(String usuario, String contraseña) {
        loginPage.ingresarUsuario(usuario);
        loginPage.ingresarContraseña(contraseña);
        loginPage.iniciarSesion();
    }

    @Step("Verifica que el login fue exitoso")
    public void verificaLoginExitoso() {
        assertThat(productosPage.estaCargada()).isTrue();
    }

    @Step("Navega a la página de login")
    public void navegarAPaginaLogin() {
        loginPage.open();
    }
    
}