import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
        public static Moneda buscaMoneda(String monedaAConvertir){
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/61f9154a8717fed5ce0d5c1d/latest/"+monedaAConvertir);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String responseBody = response.body();
                Gson gson = new Gson();
                Moneda moneda = gson.fromJson(responseBody, Moneda.class); //convirtiendo para que pueda ser de Moneda.class
                return moneda;
            } catch (Exception e) {
                throw new RuntimeException("Error al consultar la moneda: Elija una moneda de la lista" + e.getMessage());
            }
        }
}