package pe.edu.cibertec.javaarq.mod1lab2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;

public class JSONMarshall {

    public static void main(String[] args) {

        Programa programa = new Programa();

        programa.setCodigo(2452);
        programa.setNombre("Java Architect Application Developer");
        programa.setModulos(new ArrayList<String>() {
            {
                add("Fundamentos de Comunicación en sistemas distribuidos");
                add("Arquitectura de Web Services y estándares utilizados");
            }
        });
        programa.setFechaInicio(new GregorianCalendar(2013, 0, 22).getTime());
        programa.setFechaFin(new GregorianCalendar(2013, 2, 25).getTime());

        ObjectMapper mapper = new ObjectMapper();

        try {
            // output pretty printed
            mapper.configure(Feature.INDENT_OUTPUT, true);

            mapper.writeValue(new File("/home/tmp/programa.json"), programa);

            System.out.println(mapper.writeValueAsString(programa));

        } catch (JsonGenerationException e) {

            e.printStackTrace();

        } catch (JsonMappingException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
