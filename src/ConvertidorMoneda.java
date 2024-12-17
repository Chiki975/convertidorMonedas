import java.util.List;

public class ConvertidorMoneda {

    private MonedaOmdb monedaOmdb = new MonedaOmdb();

    // Metodo para realizar la conversión
    public double realizarConversion(int opcion, double cantidad) {
        List<Moneda> listaMonedas = monedaOmdb.listaMonedas();
        double tasaOrigen = 1, tasaDestino = 1;

        switch (opcion) {
            case 1 -> { // Dólar a peso argentino
                tasaDestino = getTasa("ARS", listaMonedas);
            }
            case 2 -> { // Peso argentino a dólar
                tasaOrigen = getTasa("ARS", listaMonedas);
            }
            case 3 -> { // Dólar a real brasileño
                tasaDestino = getTasa("BRL", listaMonedas);
            }
            case 4 -> { // Real brasileño a dólar
                tasaOrigen = getTasa("BRL", listaMonedas);
            }
            case 5 -> { // Dólar a peso colombiano
                tasaDestino = getTasa("COP", listaMonedas);
            }
            case 6 -> { // Peso colombiano a dólar
                tasaOrigen = getTasa("COP", listaMonedas);
            }
            default -> {
                System.out.println("Opción no válida.");
                return 0;
            }
        }

        return convertir(cantidad, tasaOrigen, tasaDestino);
    }

    // Metodo para obtener la tasa de una moneda específica
    private double getTasa(String moneda, List<Moneda> listaMonedas) {
        for (Moneda m : listaMonedas) {
            if (m.getPais().equalsIgnoreCase(moneda)) {
                return m.getCantidad();
            }
        }
        return 1; // Si no encuentra la moneda, retorna 1
    }

    // Metodo para convertir
    private double convertir(double cantidad, double tasaOrigen, double tasaDestino) {
        return cantidad * (tasaDestino / tasaOrigen);
    }
}
