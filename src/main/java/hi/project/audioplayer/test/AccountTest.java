package hi.project.audioplayer.test;

import hi.project.audioplayer.vinnsla.Account;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertNotNull;


public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws IOException, URISyntaxException {
        account = new Account("Dollaris");
    }

    @Test
    public void testGetters() {
        assert account.getName().equals("Dollaris");
    }

    @Test
    public void testNamePropertyNotNull() {
        Account account = new Account("Ivar");
        assertNotNull(account.nameProperty());
    }
}
