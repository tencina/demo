package cl.tencina.demo.repository;

import cl.tencina.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByUsuario(String usuario);

}