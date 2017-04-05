package objetos;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by maxi on 20/03/17.
 */
public class Usuario implements Comparable<Usuario> {


    public String nombre;
    public Date nacimiento;
    public String imagen;

    public Usuario(String nombre, Date nacimiento) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
    }

    public int compareTo(Usuario usuario) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(nacimiento);
        int day1 = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(usuario.nacimiento);
        int day2 = cal.get(Calendar.DAY_OF_MONTH);

        if (day1 < day2) {
            return -1;
        }
        if (day1 > day2) {
            return 1;
        }
        return 0;
    }
}
