package prog.unidad05.json.ejercicio03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ProcesadorJson {

  /**
   * Procesa un archivo JSON y extrae la nomina de él
   * @param archivo Archivo JSON con la nómina
   * @return Nomina
   */
  public static Nomina procesaNomina(String archivo) {
    try {
      // Accedemos al archivo
      JsonElement fichero = JsonParser.parseReader(new FileReader(archivo));
      // El elemento debe ser un array de empleados
      if (!fichero.isJsonArray()) {
        throw new ProcesadorJsonException("El fichero no tiene el formato correcto");
      }
      
      // Creamos la nomina vacía
      Nomina nomina = new Nomina();
      
      // Para cada elemento
      JsonArray array = fichero.getAsJsonArray();
      for (JsonElement elemento: array) {
        // El elemento debe ser un objeto "empleado"
        if (!elemento.isJsonObject()) {
          throw new ProcesadorJsonException("Error de sintaxis en el archivo");
        }
        // Creamos el empleado a partir de los datos del objeto
        JsonObject empleadoJson = elemento.getAsJsonObject();
        Empleado empleado = new Empleado(empleadoJson.get("dni").getAsString(),
            empleadoJson.get("nombre").getAsString(),
            empleadoJson.get("apellido").getAsString(),
            empleadoJson.get("salario").getAsDouble());
        nomina.addEmpleado(empleado);
      }
      // Devolvemos la nomina
      return nomina;
    } catch (Exception e) {
      throw new ProcesadorJsonException("Error accediendo al archivo", e);
    }
  }

  public static Subida[] procesaSubidas(String archivo) {
    try {
      // Accedemos al archivo
      JsonElement fichero = JsonParser.parseReader(new FileReader(archivo));
      // El elemento debe ser un array de subidas
      if (!fichero.isJsonArray()) {
        throw new ProcesadorJsonException("El fichero no tiene el formato correcto");
      }

      // Extraemos el array
      JsonArray array = fichero.getAsJsonArray();
      // Creamos el array del tamaño adecuado
      Subida[] subidas = new Subida[array.size()];
      int indice = 0;
      
      for (JsonElement elemento: array) {
        // El elemento debe ser un objeto "subida"
        if (!elemento.isJsonObject()) {
          throw new ProcesadorJsonException("Error de sintaxis en el archivo");
        }
        // Creamos la subida a partir de los datos del objeto
        JsonObject empleadoJson = elemento.getAsJsonObject();
        subidas[indice++] = new Subida(empleadoJson.get("dni").getAsString(),
            empleadoJson.get("importe").getAsDouble());
      }
      // Devolvemos el resultado
      return subidas;
    } catch (Exception e) {
      throw new ProcesadorJsonException("Error accediendo al archivo", e);
    }
  }
  
  public static void generaSalida(Nomina nomina, String archivo) {
    // Obtenemos los empleados
    Empleado[] empleados = nomina.getAll();
    // Se crea el objeto Gson
    Gson gson = new Gson();
    // Se exporta el archivo
    try {
      gson.toJson(empleados, new FileWriter(archivo));
    } catch (Exception e) {
      throw new ProcesadorJsonException("Error accediendo al archivo");
    }
  }
}
