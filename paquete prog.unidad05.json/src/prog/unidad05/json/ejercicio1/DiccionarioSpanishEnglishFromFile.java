package prog.unidad05.json.ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DiccionarioSpanishEnglishFromFile {

  // Atributo del json
  private String archivo;
  // Atributo de la excepcion
  private Throwable e;
  // Diccionario
  private Map<String, String> diccionario;

  /**
   * Crea un nuevo diccionario tomando la información del archivo JSON
   * proporcionado
   * 
   * @param archivo - Archivo JSON con la información del diccionario
   * @throws DiccionarioSpanishEnglishException - Si no se puede obtener la
   *                                            información desde el archivo
   */
  public DiccionarioSpanishEnglishFromFile(String archivo) {
    // Debemos leer el archivo JSON
    this.archivo = archivo;
  }

  /**
   * Obtiene la traducción de una palabra española
   * 
   * @param palabra en minus spanish
   * @return Palabra correspondiente en inglés o null si no se encuentra la
   *         palabra en el diccionario
   */
  public String traducir(String palabra) {
    // Se debe devolver la palabra en ingles o null.
    if (palabra != null) {
      return diccionario.get(palabra);
    } else {
      return null;
    }
  }
  /**
   * Obtiene las palabras que contiene el diccionario
   * @return Palabras que contiene el diccionario
   */
  private Set<String> getPalabrasSpanish() {
    return diccionario.keySet();
  }
/**
 * Crea el diccionario
 * @return 
 */
  private Map<String, String> DiccionarioFromFile(String archivo) {
    try {
      JsonElement raiz = JsonParser.parseReader(new FileReader(archivo));
      // Analizo si es un objeto
      if (raiz.isJsonObject()) {
        JsonObject objetoRaiz = raiz.getAsJsonObject();
        // Agregamos las palabras al diccionario
        this.diccionario.put(procesaPalabrasSpanish(objetoRaiz), procesaPalabrasEnglish(objetoRaiz));
        return diccionario;
      } else {
        // Si no, devuelvo excepcion
        throw new DiccionarioSpanishEnglishException("No es objeto", e);
      }
    } catch (Exception e) {
      throw new DiccionarioSpanishEnglishException("Error procesando el fichero", e);
    }
  }
/**
 * Extrae palabra en spanish
 * @param objetoRaiz
 * @return
 */
  private String procesaPalabrasSpanish(JsonObject objetoRaiz) {
    JsonElement palabraJson = objetoRaiz.get("spanish");
    // Si no es null
    if (palabraJson != null) {
      return palabraJson.getAsString();
    } else {
      throw new DiccionarioSpanishEnglishException(String.format("El campo %s no es una cadena", palabraJson), e);
    }

  }
/**
 * Extrae palabra en ingles
 * @param objetoRaiz
 * @return
 */
  private String procesaPalabrasEnglish(JsonObject objetoRaiz) {
    JsonElement wordJson = objetoRaiz.get("english");
    // Si no es null
    if (wordJson != null) {
      return wordJson.getAsString();
    } else {
      throw new DiccionarioSpanishEnglishException(String.format("El campo %s no es una cadena", wordJson), e);
    }
  }
}