package com.swaglabs.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfirmacionPage extends PageObject {

    @FindBy(className = "complete-header")
    private WebElementFacade mensajeConfirmacion;

    public void verificarMensajeConfirmacion(String mensajeEsperado) {
        assertThat(mensajeConfirmacion.getText()).isEqualTo(mensajeEsperado);
    }

    public boolean mensajeConfirmacionEsVisible() {
        return mensajeConfirmacion.isVisible();
    }
}