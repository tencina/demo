package cl.tencina.demo.controller;

import cl.tencina.demo.exception.Response;
import cl.tencina.demo.model.Usuario;
import cl.tencina.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class DemoController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String home(@RequestParam(value="name") String name) {

        return "Bienvenido "+name+"!!";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody Usuario usuario) {
        boolean bResultado = false;
        try {
            boolean bExiste = (usuarioService.getUsuarioByUsuario(usuario.getUsuario()) instanceof Usuario);
            if(bExiste){
                return ResponseEntity.ok(new Response("Error","El usuario ingresado ya existe"));
            }else{
                bResultado = usuarioService.insert(usuario);
            }
        }catch (Exception e){
            return ResponseEntity.ok(new Response("Error","Error en los datos ingresados"));
        }

        if(bResultado){
            return ResponseEntity.ok().body(new Response("Información","Usuario creado con éxito"));
        }else{
            return ResponseEntity.ok(new Response("Error","Error en la solicitud"));
        }
    }

}
