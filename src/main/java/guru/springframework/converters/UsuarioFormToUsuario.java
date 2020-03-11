package guru.springframework.converters;

import guru.springframework.commands.UsuarioForm;
import guru.springframework.domain.Usuario;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class UsuarioFormToUsuario implements Converter<UsuarioForm, Usuario> {

  
    @Override
    public Usuario convert(UsuarioForm usuarioForm) {
        Usuario usuario = new Usuario();
        if (usuarioForm.getId() != null  && !StringUtils.isEmpty(usuarioForm.getId())) {
            usuario.setId(new Long(usuarioForm.getId()));
        }
        
        usuarioForm.setId(usuario.getId());
        usuarioForm.setCpf(usuarioForm.getCpf());
        usuarioForm.setNome(usuarioForm.getNome());
        usuarioForm.setEmail(usuarioForm.getEmail());
        usuarioForm.setCartaoCredito(usuarioForm.getCartaoCredito());
        usuarioForm.setCelular(usuarioForm.getCelular());
        usuarioForm.setSenha(usuarioForm.getSenha());
        
        return usuario;
        
    }
}
