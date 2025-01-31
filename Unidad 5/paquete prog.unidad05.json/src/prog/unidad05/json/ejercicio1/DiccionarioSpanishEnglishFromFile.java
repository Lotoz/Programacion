package prog.unidad05.json.ejercicio1;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Diccionario Español-inglés que toma la información de un archivo JSON
 */
public class DiccionarioSpanishEnglishFromFile {
  // Atributos
  // Diccionario
  private Map<String, String> diccionario;

  /**
   * Crea un nuevo diccionario tomando la información del archivo JSON proporcionado
   * @param archivo Archivo JSON con la información del diccionario
   * @throws DiccionarioSpanishEnglishException Si no se puede obtener la información
   *   desde el archivo
   */
  public DiccionarioSpanishEnglishFromFile(String archivo) {
    // Intenta inicializar el diccionario desde el fichero
    iniciaDesdeFicheroJSON(archivo);
  }
  
  /**
   * Obtiene la traducción de una palabra española
   * @param palabra Palabra en español (todo minúsculas)
   * @return Palabra correspondiente en inglés o null si no se encuentra la
   *   palabra en el diccionario
   */
  public String traducir(String palabra) {
    // Extrae la palabra desde el diccionario (o no, si no se encuentra)
    return diccionario.get(palabra);
  }
  
  /**
   * Inicia el diccionario desde el archivo JSON especificado
   * @param archivo Archivo JSON con la información del diccionario
   */
  private void iniciaDesdeFicheroJSON(String archivo) {
    try {
      // Intenta acceder al archivo
      JsonElement elemento = JsonParser.parseReader(new FileReader(archivo));
      // El elemento debe ser un array
      if (!elemento.isJsonArray()) {
        throw new DiccionarioSpanishEnglishException("Formato de archivo incorrecto", null);
      }
      // Creamos el diccionario
      diccionario = new HashMap<String, String>();
      // Para cada elemento del array
      JsonArray array = elemento.getAsJsonArray();
      for (JsonElement elementoArray: array) {
        // El elemento debe ser un objeto
        if (!elementoArray.isJsonObject()) {
          throw new DiccionarioSpanishEnglishException("Formato de archivo incorrecto", null);
        }
        // Obtenemos el objeto
        JsonObject objetoEntrada = elementoArray.getAsJsonObject();
        // Creamos la entrada de diccionario con el objeto
        diccionario.put(objetoEntrada.get("spanish").getAsString(), objetoEntrada.get("english").getAsString());
      }
    } catch (Exception e) {
      throw new DiccionarioSpanishEnglishException("Error accediendo al fichero", e);
    }
  }

}
