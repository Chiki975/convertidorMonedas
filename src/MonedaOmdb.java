import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class MonedaOmdb {

    public List<Moneda> listaMonedas() {
        Gson gson = new Gson();
        List<Moneda> monedas = new ArrayList<>();

        String direccion = "https://v6.exchangerate-api.com/v6/522af7acab6f376e3da22d3d/latest/USD";

        try {
            // Realizar la solicitud HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Parsear JSON
            String json = response.body();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

            // Obtener las tasas de cambio
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

            // Agregar las monedas a la lista
            monedas.add(new Moneda("USD", rates.get("USD").getAsDouble()));
            monedas.add(new Moneda("ARS", rates.get("ARS").getAsDouble()));
            monedas.add(new Moneda("BRL", rates.get("BRL").getAsDouble()));
            monedas.add(new Moneda("COP", rates.get("COP").getAsDouble()));

        } catch (Exception e) {
            System.out.println("Error al consultar las tasas de cambio: " + e.getMessage());
        }

        return monedas;
    }
}
