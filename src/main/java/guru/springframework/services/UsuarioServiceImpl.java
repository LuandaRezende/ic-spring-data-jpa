package guru.springframework.services;

import guru.springframework.commands.UsuarioForm;
import guru.springframework.converters.UsuarioFormToUsuario;
import guru.springframework.domain.Usuario;
import guru.springframework.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

  private UsuarioRepository usuarioRepository;
  private UsuarioFormToUsuario usuarioFormToUsuario;


    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioFormToUsuario = usuarioFormToUsuario;
    }    

    @Override
    public List<Usuario> listAll() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuarios::add); //fun with Java 8
        return usuarios;
    }

    @Override
   public Usuario getById(Long id) {
      return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario saveOrUpdate(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public void delete(Long id) {
       usuarioRepository.deleteById(id);

    }

    

    @Override
    public Usuario saveOrUpdateUsuarioForm(UsuarioForm usuarioForm) {
       Usuario savedUsuario = saveOrUpdate(usuarioFormToUsuario.convert(usuarioForm));

        System.out.println("Saved Product Id: " + savedUsuario.getId());
        return savedUsuario;
    }

    
}
