package generator;

import objetos.Usuario;

import java.text.SimpleDateFormat;

/**
 * Created by maxi on 21/03/17.
 */
public class TextMaker {

    private Usuario[] usuarios;
    private String codigo;

    public TextMaker(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public TextMaker generateHtml() {
        codigo = "<head lang=\"en\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <style TYPE=\"text/css\">\n" +
                "        <!--\n" +
                "        body {\n" +
                "            font-size: 12px;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "        }\n" +
                "        div {\n" +
                "            display: block;\n" +
                "        }\n" +
                "        .gadget {\n" +
                "            padding: 5px;\n" +
                "            zoom: 1;\n" +
                "            position: relative;\n" +
                "            margin-bottom: 10px;\n" +
                "            display: table;\n" +
                "            border-collapse: separate;\n" +
                "            border-spacing: 2px;\n" +
                "            border-color: grey;\n" +
                "        }\n" +
                "        #layout {\n" +
                "            width: 100%;\n" +
                "            font-size: 90%;\n" +
                "            border-spacing: 2px;\n" +
                "            border-color: grey;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "            display: table;\n" +
                "            border-collapse: separate;\n" +
                "            zoom: 1;\n" +
                "        }\n" +
                "        .user-info {\n" +
                "            border: none;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "        }\n" +
                "        .user-info-nested {\n" +
                "            margin: 5px 0px;\n" +
                "            width: 100%;\n" +
                "            font-size: 90%;\n" +
                "            border-spacing: 2px;\n" +
                "            border-color: grey;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "            display: table;\n" +
                "            border-collapse: separate;\n" +
                "            zoom: 1;\n" +
                "        }\n" +
                "        .image {\n" +
                "            background-image: url(\"http://www.sinverrugasylunares.net/wp-content/uploads/2015/09/Tratamientos-Medicos-para-Eliminar-Verrugas-en-la-Cara.jpg\");\n" +
                "            float: left;\n" +
                "            height: 42px;\n" +
                "            width: 42px;\n" +
                "            border: solid 1px #C4C4C4;\n" +
                "            zoom: 1;\n" +
                "        }\n" +
                "        .date {\n" +
                "            color: #3083b8;\n" +
                "            font-size: 0.95em;\n" +
                "            letter-spacing: 0.1em;\n" +
                "            margin-bottom: 2px;\n" +
                "            margin-left: 60px;\n" +
                "            border-collapse: separate;\n" +
                "            border-spacing: 2px;\n" +
                "            border-color: grey;\n" +
                "            display: table;\n" +
                "        }\n" +
                "        .nombre {\n" +
                "            margin-bottom: 2px;\n" +
                "            margin-left: 60px;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "        }\n" +
                "        .delimiter{\n" +
                "            clear: both;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"gadget\">\n" +
                "\n" +
                "\n" +
                "        <div id=\"layout\">\n";

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        for (Usuario usuario : usuarios) {
            codigo = codigo + "<div class=\"user-info\">\n" +
                    "                <div class=\"user-info-nested\">\n" +
                    "                    <div class=\"image\">" + usuario.imagen + "</div>\n" +
                    "                    <div class=\"date\">" + formatter.format(usuario.nacimiento).substring(0, 5) +"</div>\n" +
                    "                    <div class=\"nombre\">" + usuario.nombre + "</div>\n" +
                    "                    <div class=\"delimiter\"></div>\n" +
                    "                </div>\n" +
                    "            </div>\n";
        }

        codigo = codigo + "        </div>\n" +
                "    </div>\n" +
                "</body>";

        return this;
    }

    public TextMaker generateSmallHtml() {
        codigo = "<head lang=\"en\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <style TYPE=\"text/css\">\n" +
                "        <!--\n" +
                "        body {\n" +
                "            font-size: 12px;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "        }\n" +
                "        div {\n" +
                "            display: block;\n" +
                "        }\n" +
                "        .gadget {\n" +
                "            padding: 5px;\n" +
                "            zoom: 1;\n" +
                "            position: relative;\n" +
                "            margin-bottom: 10px;\n" +
                "            display: table;\n" +
                "            border-collapse: separate;\n" +
                "            border-spacing: 2px;\n" +
                "            border-color: grey;\n" +
                "        }\n" +
                "        #layout {\n" +
                "            width: 100%;\n" +
                "            font-size: 90%;\n" +
                "            border-spacing: 2px;\n" +
                "            border-color: grey;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "            display: table;\n" +
                "            border-collapse: separate;\n" +
                "            zoom: 1;\n" +
                "        }\n" +
                "        .user-info {\n" +
                "            border: none;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "        }\n" +
                "        .user-info-nested {\n" +
                "            margin: 5px 0px;\n" +
                "            width: 100%;\n" +
                "            font-size: 90%;\n" +
                "            border-spacing: 2px;\n" +
                "            border-color: grey;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "            display: table;\n" +
                "            border-collapse: separate;\n" +
                "            zoom: 1;\n" +
                "        }\n" +
                "        .image {\n" +
                "            background-image: url(\"http://www.sinverrugasylunares.net/wp-content/uploads/2015/09/Tratamientos-Medicos-para-Eliminar-Verrugas-en-la-Cara.jpg\");\n" +
                "            float: left;\n" +
                "            height: 42px;\n" +
                "            width: 42px;\n" +
                "            border: solid 1px #C4C4C4;\n" +
                "            zoom: 1;\n" +
                "        }\n" +
                "        .date {\n" +
                "            color: #3083b8;\n" +
                "            font-size: 0.95em;\n" +
                "            letter-spacing: 0.1em;\n" +
                "            margin-bottom: 2px;\n" +
                "            margin-left: 60px;\n" +
                "            border-collapse: separate;\n" +
                "            border-spacing: 2px;\n" +
                "            border-color: grey;\n" +
                "            display: table;\n" +
                "        }\n" +
                "        .nombre {\n" +
                "            margin-bottom: 2px;\n" +
                "            margin-left: 60px;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "        }\n" +
                "        .delimiter{\n" +
                "            clear: both;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"gadget\">\n" +
                "\n" +
                "\n" +
                "        <div id=\"layout\">\n";

        int counter = 1;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        for (Usuario usuario : usuarios) {
            if (counter < 4) {

                codigo = codigo + "<div class=\"user-info\">\n" +
                        "                <div class=\"user-info-nested\">\n" +
                        "                    <div class=\"image\">" + usuario.imagen + "</div>\n" +
                        "                    <div class=\"date\">" + formatter.format(usuario.nacimiento).substring(0, 5) + "</div>\n" +
                        "                    <div class=\"nombre\">" + usuario.nombre + "</div>\n" +
                        "                    <div class=\"delimiter\"></div>\n" +
                        "                </div>\n" +
                        "            </div>\n";

                counter++;
            }
            else {
                break;
            }
        }

        codigo = codigo + "<div class=\"mas\">\n" +
                "            <a href=\"https://sites.google.com/a/edensa.com.ar/bkp23122016/cumpleanos\">Lista completa</a>\n" +
                "        </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>";

        return this;
    }

    public String build() {

        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n" +
                "<Module> \n" +
                "    <ModulePrefs title=\"EDENSAcomunica\"/>\n" +
                "    <Content type=\"html\">\n" +
                "        <![CDATA[\n";

        String footer = "        ]]>\n" +
                "    </Content>\n" +
                "</Module>";

        return header + codigo + footer;
    }
}
