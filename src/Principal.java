import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ConvertidorMoneda convertidor = new ConvertidorMoneda();

        while (true) {
            try {
                System.out.println("""
                        ********************************************
                        Sea bienvenido/a al Convertidor de Moneda =D
                        
                        1) Dólar => Peso argentino
                        2) Peso argentino => Dólar
                        3) Dólar => Real brasileño
                        4) Real brasileño => Dólar
                        5) Dólar => Peso colombiano
                        6) Peso colombiano => Dólar
                        7) Salir
                        """);

                // Elige la opción
                System.out.print("Elegir opción válida: ");
                int opcion = leer.nextInt();

                if (opcion == 7) {
                    System.out.println("""
                            Saliendo del sistema...
                            ¡Gracias por usar el convertidor de moneda!
                            """);
                    break;
                }

                // Ingresa la cantidad de moneda
                System.out.print("Ingresar cantidad a convertir: ");
                double cantidad = leer.nextDouble();

                // Llamamos al convertidor
                double resultado = convertidor.realizarConversion(opcion, cantidad);
                System.out.printf("Resultado: %.2f%n", resultado);

            } catch (Exception e) {
                System.out.println("""
                        Ocurrió un error en el sistema.
                        Reiniciando...
                        """);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                leer.nextLine();
            }
        }
    }
}
