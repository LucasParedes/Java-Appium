# Java + Appium - Android

Estoy llevando a cabo este proyecto como parte de mi aprendizaje en la automatización de pruebas móviles. Mi objetivo es
fortalecer mis conocimientos en herramientas como Appium y WebDriverIO, que son fundamentales para la automatización en
dispositivos Android.
A través de este proyecto, aprendo la configuración del entorno, la ejecución de pruebas en emuladores y dispositivos
físicos, así como la implementación de buenas prácticas en la automatización móvil.

# Requisitos Generales del Sistema para comenzar

#### Node JS

Necesitamos Node.js para descargar la versión de Appium y sus controladores.

- Descargar [ Node Js](https://nodejs.org/es) según tu sistema operativo.

#### Java JDK & JAVA_HOME

- [Open JDK](https://openjdk.org)
- [Configuración de JAVA_HOME en Windows](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)

## Configuración de Android

#### Android Studio y variable ANDROID_HOME

- [Android Studio](https://developer.android.com/studio?hl=es-419&gclsrc=aw.ds&gclid=Cj0KCQjwyOuYBhCGARIsAIdGQRNrDv20QvoOy_-I5E1LoZdOLu3nvhlwX_7EjPeHcE1kGQNNcIVOme0aAqckEALw_wcB)
- [Configuración de ANDROID_HOME en Windows](https://www.testingdocs.com/setting-android_home-environment-variable-on-windows/)

---

### Descargar Appium Inspector

Para encontrar los localizadores correctos y mapear elementos, necesitarás esta herramienta instalada en tu computadora.

- [Appium Inspector](https://github.com/appium/appium-inspector)

Para este proyecto, use la siguiente configuración:

| Server Key  | Server Value |
|-------------|--------------|
| Remote Host | 0.0.0.0      |
| Remote Port | 4723         |
| Remote Path | /            |

Capacidades deseadas de Android (ejemplo)
| Key | Value |
| ------------- | ------------- |
| platformName | Android |
| platformVersion | [OS VERSION / IMAGE] |
| deviceName | [EMULATED_DEVICE_NAME] |
| app | /[PROJECT_PATH]/[APP_NAME].apk |
| appium:automationName | UIAutomator2 |

## Instalar Appium

Appium es un framework de automatización de pruebas de código abierto para aplicaciones móviles nativas, híbridas y web.

- Instalar [Appium](https://appium.io) desde la documentación oficial.
- Instalar [Appium 2](https://appiumpro.com/editions/122-installing-appium-20-and-the-driver-and-plugins-cli) con
  Node.js (Beta):

```bash
    npm install -g appium@next
```

Comprobar la versión de Appium:

```bash
    appium -v
```

#### Appium Doctor

Para verificar si tu sistema cumple con los requisitos de Appium, instala este paquete de Node.js:

- [Appium Doctor Package](https://github.com/appium/appium-doctor)
  Instalar usando este comando:

```bash
npm install appium-doctor -g
```

Verifica si esta todo instalado todo OK::

```bash
appium-doctor
```

#### Drivers de Appium

Para que Appium funcione correctamente, necesitas los drivers de Android en tu sistema:

```bash
appium driver install xcuitest
appium driver install uiautomator2
```

Verifica los drivers instalados:

```bash
appium driver list
```

#### Aplicaciones de prueba

Aplicaciones de prueba que puedes utilizar:

[SauceDemo Hybrid App - React Native)](https://github.com/saucelabs/my-demo-app-rn)

[Sauce Labs Native Sample Application](https://github.com/saucelabs/sample-app-mobile)

## Configurar WebDriverIO

1- Ejecutar el comando para crear el package.json y seguir el proceso de configuración en WebDriverIO:

```bash
    npm init wdio .
```

2- Utilizando el Asistente de Configuración de WDIO, selecciona las opciones que prefieras. En mi caso, elegí:

- On my local machine
- Mocha
- No compiler
- Spect Location: Default
- Do you want WebDriverIO to generate some test files?: No
- Reporter: Spec
- No Plugin
- Service: Appium
- Base URL: Default
- NPM Install: Yes

3- Agrega tus pruebas en la siguiente ruta:

```bash
'./[yourProject]/specs/**/*.js'
```

4- Configura la ruta de la aplicación en wdio.conf.js

- Declara la ubicación de la aplicación:

```bash
const projectPath = require('path')
const androidAppPath = projectPath.join(process.cwd(), "app/android/Android-MyDemoAppRN.1.3.0.build-244.apk")
```

- Configura las capacidades para Android (Ejemplo con emulador):

```bash
capabilities: [{
        platformName: 'Android',
        "appium:device-name": 'Pixel 4 API 30',
        "appium:platformVersion": "11",
        "appium:automationName": "UIAutomator2",
        "appium:app": androidAppPath,
    }]
```

- Instala Appium en tu proyecto:

```bash
    npm install --save-dev appium@next
```

- Verifica si los controladores aún están disponibles, si no, instálalos nuevamente:

```bash
appium driver list
```

```bash
appium driver install xcuitest
appium driver install uiautomator2
```

- Ejecuta tus scripts usando:

```bash
npx wdio
```
