package jndi.example;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIFileSystemService {

    private final Hashtable<String, String> env = new Hashtable<>();

    public JNDIFileSystemService() {

        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.fscontext.RefFSContextFactory");
    }

    public void run() {
        try {
            final Context ctx = new InitialContext(env);
            final Object obj = ctx.lookup("/");
            System.out.println("/ is bound to: " + obj);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
