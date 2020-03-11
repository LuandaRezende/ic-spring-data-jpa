
package guru.springframework.services;

import guru.springframework.commands.UsuarioForm;
import guru.springframework.domain.Usuario;
import java.util.List;


public interface UsuarioService {
    List<Usuario> listAll();
    Usuario getById(Long id);
    Usuario saveOrUpdate(Usuario usuario);
    void delete(Long id);
    Usuario saveOrUpdateUsuarioForm(UsuarioForm usuarioForm);    
}
