import java.io.IOException;
import java.util.Scanner;

    public class ConversorMonedas {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            APIHandler apiHandler = new APIHandler();
            ConversionHandler conversionHandler = new ConversionHandler(apiHandler);

            while (true) {
                System.out.println("\n=== Conversor de Monedas ===");
                System.out.println("1. Actualizar tasas de cambio");
                System.out.println("2. Convertir moneda");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        try {
                            apiHandler.actualizarTasas();
                        } catch (IOException | InterruptedException e) {
                            System.out.println("Error al actualizar tasas: " + e.getMessage());
                        }
                        break;
                    case 2:
                        conversionHandler.realizarConversion(scanner);
                        break;
                    case 3:
                        System.out.println("Gracias por usar el conversor de monedas.");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
    }
