import java.util.*;
import java.io.IOException;

/**
 * Created by mcarvajal on 08/05/2017.
 */

/*
* Realiza un programa en Java que lea el contenido del fichero: Países del mundo y
* lo guarde en memoria en una lista en el mismo orden en que se encuentra en el fichero original.
* Solo ha de guardar el nombre del país en castellano (el primer campo), el nombre del país en
* inglés (el segundo campo) y el prefijo telefónico (el último campo).
*
* A continuación ha de permitir al usuario realizar consultas a partir del nombre de un país y
* mostrar por pantalla el prefijo del mismo. Se pueden realizar tantas consultas como se desee.
*
* Al finalizar la ejecución del programa, éste ha de escribir en un fichero de log (log_consultas.txt)
* el nombre de los países que se han consultado con su correspondiente prefijo telefónico. Los registros
* de éste fichero han de coincidir en el mismo orden en que se han realizado las consultas.
*
* Para cada ejecución del programa, se ha de crear siempre de nuevo el fichero log_consultas,
* perdiendo toda información que éste contenía en su ejecución anterior.
*
* */
public class main {
    public static void main(String[] args) {
        // FIRST QUESTION
        LecturaDatos p1 = new LecturaDatos();
        Map<String,String> countries = new HashMap<String,String>();
        try{
            countries = p1.showFileContent();
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

        // THIRD QUESTION
        Logger p3 = new Logger();
        p3.getFileReady(); // Delete all log file contents

        // SECOND QUESTION and THIRD QUESTION
        Boolean p2 = new Boolean(true);
        while(p2){
            try{
                p2 = p1.countrySearch(countries);
            } catch (IOException ioe){
                System.out.println(ioe.getMessage());
            }
        }
    }
}
