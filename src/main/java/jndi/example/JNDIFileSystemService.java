package jndi.example;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import com.sun.jndi.fscontext.RefFSContext;

public class JNDIFileSystemService {

    private final Hashtable<String, String> env = new Hashtable<>();

    public JNDIFileSystemService() {

        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.fscontext.RefFSContextFactory");
    }

    public void run() {
        try {
            final Context initContext = new InitialContext(env);
            final RefFSContext context = (RefFSContext) initContext.lookup("/");
            System.out.println("/ is bound to: " + context);
            final NamingEnumeration<NameClassPair> list = initContext.list("/");

            while (list.hasMore()) {
                NameClassPair nc = list.next();
                System.out.println(nc);
            }

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

}
