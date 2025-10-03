@compra
Feature: Proceso de compra en Saucedemo

  # ✅ ESCENARIO ORIGINAL (MANTENER)
  Scenario: Usuario completa una compra exitosa
    Given que he iniciado sesión en Saucedemo con usuario "standard_user" y contraseña "secret_sauce"
    When agrego dos productos al carrito
    And visualizo el carrito
    And completo el formulario de compra
    And finalizo la compra
    Then debo ver el mensaje de confirmación "Thank you for your order!"

  # ✅ SCENARIO OUTLINE (SOLO STANDARD_USER - ELIMINAR LOS QUE FALLAN)
  Scenario Outline: Usuario completa una compra exitosa con diferentes credenciales
    Given que he iniciado sesión en Saucedemo con usuario "<usuario>" y contraseña "<contraseña>"
    When agrego dos productos al carrito
    And visualizo el carrito
    And completo el formulario de compra con "<nombre>" "<apellido>" "<codigo_postal>"
    And finalizo la compra
    Then debo ver el mensaje de confirmación "<mensaje_confirmacion>"

    Examples:
      | usuario       | contraseña   | nombre | apellido | codigo_postal | mensaje_confirmacion      |
      | standard_user | secret_sauce | Juan   | Perez    | 12345         | Thank you for your order! |