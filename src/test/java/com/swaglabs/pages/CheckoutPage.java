package com.swaglabs.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {

    @FindBy(id = "first-name")
    private WebElementFacade firstNameInput;

    @FindBy(id = "last-name")
    private WebElementFacade lastNameInput;

    @FindBy(id = "postal-code")
    private WebElementFacade postalCodeInput;

    @FindBy(id = "continue")
    private WebElementFacade continueButton;

    public void completarInformacionPersonal(String nombre, String apellido, String codigoPostal) {
        firstNameInput.type(nombre);
        lastNameInput.type(apellido);
        postalCodeInput.type(codigoPostal);
    }

    public void continuar() {
        continueButton.click();
    }
}