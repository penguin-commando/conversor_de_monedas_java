import java.util.Scanner;
import com.google.gson.JsonObject;

public class ConversionHandler {
    private APIHandler apiHandler;

    public ConversionHandler(APIHandler apiHandler) {
        this.apiHandler = apiHandler;
    }

    // Metodo para realizar la conversión de monedas
    public void realizarConversion(Scanner scanner) {
        JsonObject tasasCambio = apiHandler.getTasasCambio();

        if (tasasCambio == null) {
            System.out.println("Por favor, actualice las tasas de cambio antes de realizar una conversión.");
            return;
        }

        System.out.print("Ingrese la moneda de origen (e.g., USD): ");
        String monedaOrigen = scanner.next().toUpperCase();
        System.out.print("Ingrese la moneda de destino (e.g., COP): ");
        String monedaDestino = scanner.next().toUpperCase();
        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        // El objeto CON cuenta/APIkey: conversion_rates
        // El objeto SIN cuenta: rates
        if (tasasCambio.getAsJsonObject("conversion_rates").has(monedaOrigen) && tasasCambio.getAsJsonObject("conversion_rates").has(monedaDestino)) {
            double tasaOrigen = tasasCambio.getAsJsonObject("conversion_rates").get(monedaOrigen).getAsDouble();
            double tasaDestino = tasasCambio.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();
            double resultado = (cantidad / tasaOrigen) * tasaDestino;

            System.out.printf("%.2f %s equivale a %.2f %s\n", cantidad, monedaOrigen, resultado, monedaDestino);
        } else {
            System.out.println("Una o ambas monedas no están disponibles en las tasas de cambio actuales.");
        }
    }
}
