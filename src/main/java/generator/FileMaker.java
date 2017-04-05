package generator;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by maxi on 21/03/17.
 */
public class FileMaker {

    private String code;

    public FileMaker(String code) {
        this.code = code;
    }

    public String generateFile(String name) {
        String path = "";

        try {
            File archivo = new File(name + ".xml");
            FileWriter escribir = new FileWriter(archivo,true);

            escribir.write(code);

            escribir.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}
