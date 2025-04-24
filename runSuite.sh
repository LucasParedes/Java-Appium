#!/bin/bash

echo "Eliminando carpeta allure-results..."
rm -rf allure-results

echo "Ejecutando pruebas del grupo 'regresion'..."

# 👇 Esta línea es la que desactiva los warnings:
export MAVEN_OPTS="--enable-native-access=ALL-UNNAMED"

./mvnw clean test -Dgroups="regresion"

echo "Abriendo reporte allure"
./mvnw allure:serve
