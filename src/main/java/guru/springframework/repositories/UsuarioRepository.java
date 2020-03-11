package guru.springframework.repositories;

import guru.springframework.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
