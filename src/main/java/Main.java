import generator.FileMaker;
import generator.TextMaker;
import ldap.Ldap;
import objetos.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by maxi on 03/02/17.
 */
public class Main {


    public static void main(String[] args) throws ParseException {
        System.out.println("Bienvenido a LdapSync!");

        Ldap ldap = new Ldap("edensa.com.ar", "ltosso.admin@edensa.com.ar", "analisis.1");

        int month = Calendar.getInstance().get(Calendar.MONTH);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Usuario[] usuarios = ldap.getUsuariosNacimiento(month);

        for (Usuario user : usuarios) {
            System.out.println("Usuario: " + user.nombre);
            System.out.println("Nacimiento: " + format.format(user.nacimiento).substring(0, 5));
            System.out.println("--------------------------------------------");
        }

        String htmlGadget = new TextMaker(usuarios).generateSmallHtml().build();
        String htmlPage = new TextMaker(usuarios).generateHtml().build();

        FileMaker gadgetMaker = new FileMaker(htmlGadget);
        String gadgetCodePath = gadgetMaker.generateFile("gadget");

        FileMaker pageMaker = new FileMaker(htmlPage);
        String pageCodePath = pageMaker.generateFile("page");


    }

}
