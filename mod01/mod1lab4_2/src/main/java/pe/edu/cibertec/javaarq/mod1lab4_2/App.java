package pe.edu.cibertec.javaarq.mod1lab4_2;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        try { // Call Web Service Operation
            MiPrimerServicio_Service service = new MiPrimerServicio_Service();
            MiPrimerServicio port = service.getMiPrimerServicioPort();
            // TODO initialize WS operation arguments here
            java.lang.String nombre = "Carlos";
            // TODO process result here
            java.lang.String result = port.hola(nombre);
            System.out.println("Result = " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
