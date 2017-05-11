/**
 * Created by Javier on 06/05/2017.
 */

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class LecturaDatos {
    public static Map showFileContent() throws IOException{
        Map<String,String> countries = new HashMap<String,String>();
        Scanner s =null;
        try {
            // NEXT LINES can be helpful to improve.
            //String current = new java.io.File( "." ).getCanonicalPath();
            //System.out.println("Current dir: "+current);
            //File file=new File("./paises_del_mundo[S8].txt");
            //System.out.println("- "+ file.getAbsolutePath()+ "| "+ file.exists());

            s = new Scanner(new BufferedReader(new FileReader("./paises_del_mundo_[S8].txt")));
            s.useDelimiter("\r\n");
            while (s.hasNext()) {
                String formattedText = s.next();
                formattedText = formattedText.toLowerCase(); // Error control
                //System.out.println(formattedText);
                String[] elements = formattedText.split(",");
                String countryKey = elements[0].replace("\"","");
                countries.put(countryKey,elements[1].replace("\"","") +","+ elements[5].replace("\"",""));
                System.out.println(countryKey+", "+countries.get(countryKey));
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
        return countries;
    }
    public static boolean countrySearch(Map<String,String> countries) throws IOException{
        java.util.Scanner scanner = new Scanner(System.in);
        Logger p3 = new Logger();
        System.out.println("Write your search term. \n\tUse [exit] to finalize the program:\n");
        String request = scanner.next();
        request= request.toLowerCase();
        if(request.contentEquals("exit")){
            return false;
        } else{
            if(countries.containsKey(request)){
                String countryInfo = countries.get(request);
                String[] info = countryInfo.split(",");
                System.out.println(request +" phone code is "+ info[1]);
                p3.writeLine(request +"-"+ info[1]);
            } else {
                System.out.println(request +" is not listed.");
                p3.writeLine("Country "+ request +" not listed");
            }
        }
        return true;
    }
}
