package jsonEjemplocolegio.procesador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jsonEjemplocolegio.Asignatura;
import jsonEjemplocolegio.Estudiante;
import jsonEjemplocolegio.Estudiantes;
import jsonEjemplocolegio.Nombre;

public class ProcesadorEstudiantes {

  private String nombreFichero;

  public ProcesadorEstudiantes(String nombreFichero) {
    this.nombreFichero = nombreFichero;
  }

  public Estudiantes procesaFichero() {
    // Abre y procesa el fichero
    try {
      JsonElement raiz = JsonParser.parseReader(new FileReader(nombreFichero));
      if (raiz.isJsonObject()) {
        // Lo proceso
        JsonObject objetoRaiz = raiz.getAsJsonObject();
        // Funciona como un mapa.
        JsonElement estudiantesJson = objetoRaiz.get("estudiantes");
        if (estudiantesJson != null) {
          Estudiantes estudiantes = procesaEstudiantes(estudiantesJson);
          return estudiantes;
        } else {
          throw new ProcesadorEstudiantesException("No esta el atributo estudiante");
        }

      } else {
        throw new ProcesadorEstudiantesException("El elemento raiz no es un objeto");
      }
    } catch (Exception e) {
      throw new ProcesadorEstudiantesException("Error procesando el fichero.");
    }

  }

  private Estudiantes procesaEstudiantes(JsonElement estudiantesJson) {
    if(estudiantesJson.isJsonArray()) {
      //Lo proceso
      //Lo adapto a un array
      JsonArray arrayEstudiantes = estudiantesJson.getAsJsonArray();
      //Json tiene metodos para recorrer un array
      //Creamos la salida
      Estudiantes estudiantes = new Estudiantes();
      
      //Si una  clase implementa un iterable se puede usar en un forEach. Se pueden hacer propios.
      //Para cada elemento
      for(JsonElement elemento : arrayEstudiantes) {
        Estudiante estudiante = procesaEstudiante(elemento);
        estudiantes.addEstudiante(estudiante);
      }
      return estudiantes;
      }else {
      throw new ProcesadorEstudiantesException("El elemento estudiantes no es un array.");
    }
  }

  private Estudiante procesaEstudiante(JsonElement elemento) {
  //Comprobar si es objeto
    if (elemento.isJsonObject()) {
      //Se procesa
      JsonObject objeto = elemento.getAsJsonObject();
      String nombreTitulacion = procesaCadena(objeto, "nombreTitulacion");
      String email = procesaCadena (objeto, "email");
      Boolean repite = procesaBoolean(objeto, "repite");
      JsonElement elementoNombre = objeto.get("nombreEstudiante");
      Nombre nombreEstudiante = procesaNombre(elementoNombre);
      JsonElement elementoAmigos = objeto.get("amigos");
      List<String> amigos = procesaAmigos(elementoAmigos);
      JsonElement elementoAsignatura = objeto.get("asignatura");
      Asignatura[] asignasturas = procesaAsignatura(elementoAsignatura);
      }else {
      throw new ProcesadorEstudiantesException("Se ha encontrado un elemento estudiante que no es un estudiante.");
    }
  }

  private Nombre procesaNombre(JsonElement elemento) {
    //Procesar la cadena si es un objeto
    if(elemento.isJsonObject()) {
      //Copiar de git
      JsonObject objeto = elemento.getAsJsonObject();
      
    }
  }

  private Asignatura[] procesaAsignatura(JsonElement elementoAsignatura) {
    
  }

  private List<String> procesaAmigos(JsonElement elemento) {
    //Connvertir un array una lista.
    if(elemento.isJsonArray()) {
      //Lo proceso
      //Lo adapto a un array
      JsonArray arrayAmigos = elemento.getAsJsonArray();
      //Json tiene metodos para recorrer un array
      //Creamos la salida
     List<String> salida = new ArrayList<>();
     for(JsonElement amigo : arrayAmigos) {
       salida.add(amigo.getAsString());
     }
      return salida;
      //Si una  clase implementa un iterable se puede usar en un forEach. Se pueden hacer propios.
      //Para cada elemento
      for(JsonElement elemento : arrayEstudiantes) {
        Estudiante estudiante = procesaEstudiante(elemento);
        estudiantes.addEstudiante(estudiante);
      }

      }else {
      throw new ProcesadorEstudiantesException("El elemento estudiantes no es un array.");
    }
  }

  private Boolean procesaBoolean(JsonObject objeto, String nombre) {
    //Accedemos al nombreTitulacion
    JsonElement elemento = objeto.get("nombreTitulacion");
    //Si no es null
    if(elemento != null) {
      return elemento.getAsBoolean();      
    }else {
      throw new ProcesadorEstudiantesException("ErrorSTring,");
    }
  }

  private String procesaCadena(JsonObject objeto, String nombre) {
    //Accedemos al nombreTitulacion
    JsonElement elemento = objeto.get("nombreTitulacion");
    //Si no es null
    if(elemento != null) {
      return elemento.toString();      
    }else {
      throw new ProcesadorEstudiantesException("ErrorSTring,");
    }
  }
}