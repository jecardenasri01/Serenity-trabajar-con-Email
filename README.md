# Serenity-trabajar-con-Email
# Proyecto de Envío y Lectura de Correos con Serenity Screenplay

Este proyecto utiliza la biblioteca `Serenity Screenplay` para enviar y leer correos electrónicos de cuentas "@outlook.es". A continuación, se detallan los pasos necesarios para configurar y ejecutar este proyecto.

## Requisitos Previos

- Java 17 o superior.
- Maven 3.6.3 o superior.
- Una cuenta de correo electrónico "@outlook.es" con las configuraciones de POP e IMAP activadas.

## Instalación

1. Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. Instala las dependencias necesarias:
    ```bash
    mvn clean install
    ```

## Configuración

Antes de ejecutar el proyecto, debes modificar la configuración con tu propia dirección de correo y tus credenciales.

1. Abre el archivo `src/test/resources/resources/feature/correo.feature` en un editor de texto.
2. Reemplaza las siguientes propiedades con la información de tu cuenta:

    ```feature example
    correo=tu-correo@outlook.es
    clave=tu-contraseña
    ```

## Activación de Configuraciones POP e IMAP

Para que el proyecto funcione correctamente, asegúrate de tener activadas las configuraciones POP e IMAP en tu cuenta de Outlook.

1. Inicia sesión en tu cuenta de Outlook.
2. Ve a la configuración de tu cuenta (engrane parte superior derecha).
3. seleccionar "correo"
4. seleccionar "Sincronizar correo electrónico"
5. Busca y habilita las opciones de "POP e IMAP".
6. Busca y habilita las opciones de "Permitir que las aplicaciones y dispositivos eliminen los mensajes de outlook"


