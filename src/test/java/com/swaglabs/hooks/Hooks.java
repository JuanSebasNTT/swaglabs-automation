package com.swaglabs.hooks;

import io.cucumber.java.Before;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Hooks {

    @Managed
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        // Configuración MUY agresiva para deshabilitar TODAS las ventanas emergentes
        options.addArguments(
                "--start-maximized",
                "--remote-allow-origins=*",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-gpu",
                "--disable-blink-features=AutomationControlled",
                "--disable-extensions",
                "--disable-popup-blocking",
                "--disable-notifications",
                "--disable-translate",
                "--disable-save-password-bubble",
                "--disable-autofill-keyboard-accessory-view",
                "--disable-features=TranslateUI",
                "--disable-ipc-flooding-protection",
                "--disable-renderer-backgrounding",
                "--disable-backgrounding-occluded-windows",
                "--disable-background-timer-throttling",
                "--disable-component-update",
                "--disable-default-apps",
                "--disable-password-manager-reauthentication",
                "--disable-features=PasswordLeakDetection",
                "--password-store=basic",
                "--disable-infobars",
                "--disable-web-security",
                "--allow-running-insecure-content",
                "--no-default-browser-check",
                "--no-first-run"
        );

        // Preferencias experimentales muy agresivas
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_setting_values.geolocation", 2);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
        prefs.put("autofill.password_enabled", false);
        prefs.put("password_manager_enabled", false);
        prefs.put("enable-autofill", false);

        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches",
                java.util.Arrays.asList("enable-automation", "enable-logging", "disable-popup-blocking"));
    }
}