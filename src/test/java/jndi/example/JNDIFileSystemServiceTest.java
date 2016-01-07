package jndi.example;

import org.junit.Test;

public class JNDIFileSystemServiceTest {

    @Test
    public void test() {
        final JNDIFileSystemService service = new JNDIFileSystemService();
        service.run();
    }

}
