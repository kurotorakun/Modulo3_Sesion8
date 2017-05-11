import java.util.*;
import java.io.IOException;

/**
 * Created by mcarvajal on 08/05/2017.
 */


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
