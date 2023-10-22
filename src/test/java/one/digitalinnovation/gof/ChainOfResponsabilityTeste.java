/* Provavelmente essa tentativa de Chain of Responsability não está dando certo. */

public class ChainOfResponsibilityTest {

    private static AuthenticationCliente getChainOfAuthCliente() {
        AuthenticationCliente oAuthCliente = new OAuthCliente(null);
        return new UsernamePasswordCliente(oAuthCliente);
    }

    @Test
    public void givenOAuthProvider_whenCheckingAuthorized_thenSuccess() {
        AuthenticationCliente authClienteChain = getChainOfAuthCliente();
        assertTrue(authClienteChain.isAuthorized(new OAuthTokenProvider()));
    }

    @Test
    public void givenSamlProvider_whenCheckingAuthorized_thenSuccess() {
        AuthenticationCliente authClienteChain = getChainOfAuthCliente();
 
        assertFalse(authClienteChain.isAuthorized(new SamlTokenProvider()));
    }
}