package TaskManagerJsonReader;

import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LeerJson {

  private String nombreFichero;

  public LeerJson(String nombreFichero) {
    this.nombreFichero = nombreFichero;
  }

  public void procesaJson() {
    // Inicia el json y lo lee.
    try {
      JsonElement raiz = JsonParser.parseReader(new FileReader(nombreFichero));
      if (raiz.isJsonArray()) {
        // Si es un array de objetos. Debe extraer el objeto dentro del array

        JsonObject objetoRaiz = raiz.getAsJsonObject();

        // Obtien los objetos del array

      } else {

        throw new LeerJsonException("No es un json con un array inicial. #ERROR_ARRAY");
      }

    } catch (Exception e) {

      throw new LeerJsonException("El archivo es ilegible.#ERROR_RAIZ_N_PARSER+JSON");
    }
  }

}
