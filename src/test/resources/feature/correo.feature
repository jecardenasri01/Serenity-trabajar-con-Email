@cucumber
Feature: Leer el primer correo de la bandeja de entrada

  @leer
  Scenario Outline: : El usuario lee el primer correo
    Given iniciar test
    When lectura correo <correo> y <clave>
    Examples:
      | correo               | clave     |
      | ***@outlook.es | *** |


  @enviar
  Scenario Outline: : El usuario envia un correo
    Given iniciar test
    When enviar correo <correo> , <clave> , <asunto> y <cuerpocorreo>
    Examples:
      | correo               | clave     | asunto               | cuerpocorreo         |
      | ***@outlook.es | *** | prueba automtizacion | hola envie un correo |