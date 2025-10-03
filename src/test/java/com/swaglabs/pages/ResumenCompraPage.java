package com.swaglabs.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class ResumenCompraPage extends PageObject {

    @FindBy(id = "finish")
    private WebElementFacade finishButton;

    @FindBy(className = "summary_subtotal_label")
    private WebElementFacade subtotalLabel;

    public void finalizarCompra() {
        finishButton.click();
    }

    public void verificarResumen() {
        assertThat(subtotalLabel.isVisible()).isTrue();
    }
}