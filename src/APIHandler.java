import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APIHandler {
    //private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD"; // URL SIN CUENTA/APIkey
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/b01749ca7a248fa8f75fca69/latest/USD"; // URL CON CUENTA/APIkey
    private JsonObject tasasCambio;

    // Metodo para actualizar las tasas de cambio desde la API
    public void actualizarTasas() throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder().uri(URI.create(API_URL)).build();
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        if (respuesta.statusCode() == 200) {
            tasasCambio = JsonParser.parseString(respuesta.body()).getAsJsonObject();
            System.out.println("Tasas de cambio actualizadas correctamente.");
        } else {
            System.out.println("Error al obtener tasas de cambio: Código " + respuesta.statusCode());
        }
    }

    // Metodo para obtener las tasas de cambio almacenadas
    public JsonObject getTasasCambio() {
        return tasasCambio;
    }
}
