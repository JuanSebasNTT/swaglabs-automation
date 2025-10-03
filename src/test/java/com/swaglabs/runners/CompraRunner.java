package com.swaglabs.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/compras/comprar_productos.feature", // ESPECÍFICO
        glue = {"com.swaglabs.steps.definitions", "com.swaglabs.hooks"},
        tags = "@compra"
)
public class CompraRunner {
}