package pe.edu.cibertec.javaarq.mod1lab2;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JASONUnMarshall {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Programa programa = mapper.readValue(new File("run/programa.json"), Programa.class);

            System.out.println("Datos del programa");
            System.out.println("Codigo: " + programa.getCodigo());
            System.out.println("Nombre: " + programa.getNombre());
            System.out.println("Modulos: " + programa.getModulos());
            System.out.println("FechaInicio: " + programa.getFechaInicio());
            System.out.println("FechaFin: " + programa.getFechaFin());

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
