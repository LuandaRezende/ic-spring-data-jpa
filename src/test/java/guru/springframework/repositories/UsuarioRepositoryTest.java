package guru.springframework.repositories;

import guru.springframework.domain.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UsuarioRepositoryTest {

    private static final String CPF = "a cool product";
    private static final String NOME = "a cool product";
    private static final String EMAIL = "a cool product";
    private static final String CARTAOCREDITO = "a cool product";
    private static final String CELULAR = "a cool product";
    private static final String SENHA = "a cool product";
 

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
        Usuario usuario = new Usuario();
        usuario.setCpf(CPF);
        usuario.setCartaoCredito(CARTAOCREDITO);
        usuario.setCelular(CELULAR);
        usuario.setEmail(EMAIL);
        usuario.setNome(NOME);
        usuario.setSenha(SENHA);
      

        //when
        usuarioRepository.save(usuario);

        //then
        Assert.assertNotNull(usuario.getId());
        Usuario newUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);
        Assert.assertEquals((Long) 1L, newUsuario.getId());
        Assert.assertEquals(CPF, newUsuario.getCpf());
        Assert.assertEquals(NOME, newUsuario.getNome());
        Assert.assertEquals(CARTAOCREDITO, newUsuario.getCartaoCredito());
        Assert.assertEquals(CELULAR, newUsuario.getCelular());
        Assert.assertEquals(EMAIL, newUsuario.getEmail());
        Assert.assertEquals(SENHA, newUsuario.getSenha());
        
        
       
    }
}