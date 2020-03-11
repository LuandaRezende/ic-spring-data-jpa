
package guru.springframework.converters;

import guru.springframework.commands.UsuarioForm;
import guru.springframework.domain.Usuario;
import javax.persistence.Convert;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsuarioToUsuarioForm implements Converter<Usuario, UsuarioForm>{
    @Override
    public UsuarioForm convert(Usuario usuario) {
        UsuarioForm usuarioForm = new UsuarioForm();
        usuarioForm.setId(usuario.getId());
        usuarioForm.setCpf(usuario.getCpf());
        usuarioForm.setNome(usuario.getNome());
        usuarioForm.setEmail(usuario.getEmail());
        usuarioForm.setCartaoCredito(usuario.getCartaoCredito());
        usuarioForm.setCelular(usuario.getCelular());
        usuarioForm.setSenha(usuario.getSenha());
        
        
        return usuarioForm;
    }
}
