package com.swaglabs.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    private WebElementFacade usuarioInput;

    @FindBy(id = "password")
    private WebElementFacade contraseñaInput;

    @FindBy(id = "login-button")
    private WebElementFacade loginButton;


    // ✅ MANTENER TODOS TUS MÉTODOS EXISTENTES
    public void ingresarUsuario(String usuario) {
        usuarioInput.type(usuario);
    }

    public void ingresarContraseña(String contraseña) {
        contraseñaInput.type(contraseña);
    }

    public void iniciarSesion() {
        loginButton.click();
    }

}