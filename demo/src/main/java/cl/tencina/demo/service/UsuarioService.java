package cl.tencina.demo.service;

import cl.tencina.demo.model.Usuario;
import cl.tencina.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    public boolean insert(Usuario usuario){
        boolean result = false;
        usuario.setContrasena(bCrypt.encode(usuario.getContrasena()));
        usuario = usuarioRepository.save(usuario);
        if(usuario.getId()>0){
            result = true;
        }
        return result;
    }

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario getUsuarioByUsuario(String usuario){
        return usuarioRepository.findByUsuario(usuario);
    }
}
