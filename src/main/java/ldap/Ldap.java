package ldap;

import objetos.Usuario;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by maxi on 03/02/17.
 */
public class Ldap {
    DirContext ctx;
    SearchControls searchCtls;

    public Ldap(String dominio, String usuario, String pass) {
        try
        {
            System.out.println("Conectando con " + dominio);

            Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);
            ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            ldapEnv.put(Context.PROVIDER_URL,  "ldap://" + dominio);
            ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
            ldapEnv.put(Context.SECURITY_PRINCIPAL, usuario);
            ldapEnv.put(Context.SECURITY_CREDENTIALS, pass);
            ctx = new InitialDirContext(ldapEnv);

            // Create the search controls
            searchCtls = new SearchControls();
        }
        catch (NamingException e)
        {
            System.out.println(" Search error: " + e);
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void getUsuariosDeGrupo(String grupo) {

    }

    public Usuario[] getUsuariosNacimiento(int month) {
        try {
            //Specify the attributes to return
            String returnedAtts[]={"sn","givenName", "samAccountName", "pager"};
            searchCtls.setReturningAttributes(returnedAtts);

            //Specify the search scope
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            //specify the LDAP search filter
            String searchFilter = "(&(objectClass=user))";

            //Specify the Base for the search
            String searchBase = "dc=edensa,dc=com,dc=ar";
            //initialize counter to total the results
            int totalResults = 0;

            // Search for objects using the filter
            NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter, searchCtls);

            ArrayList<Usuario> resultList = new ArrayList<Usuario>();
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            //Loop through the search results
            while (answer.hasMoreElements())
            {
                SearchResult sr = (SearchResult)answer.next();

                totalResults++;

                Attributes attrs = sr.getAttributes();

                if (attrs.get("pager") != null) {
                    String naciminetoString = attrs.get("pager").toString().replace("pager: ", "");
                    try {
                        Date nacimientoDate = format.parse(naciminetoString);
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(nacimientoDate);
                        if (cal.get(Calendar.MONTH) == month) {
                            resultList.add(new Usuario(attrs.get("givenName").toString().replace("givenName: ", "") + " " +
                                    attrs.get("sn").toString().replace("sn: ", ""), nacimientoDate));
                        }
                    }
                    catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("XXXXXX" + sr.getName());
                    }
                }
            }

            System.out.println("Total results: " + totalResults);
            ctx.close();

            Usuario[] usuarioArray = new Usuario[] {};

            usuarioArray = resultList.toArray(usuarioArray);

            Arrays.sort(usuarioArray);

            return usuarioArray;
        }
        catch (NamingException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
