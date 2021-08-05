package cl.tencina.demo.controller;

import cl.tencina.demo.exception.Response;
import cl.tencina.demo.model.Resultado;
import cl.tencina.demo.service.HistorialService;
import cl.tencina.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private HistorialService historialService;

    @GetMapping(value = "/sumar")
    public ResponseEntity<?> sumar(@RequestParam(name = "primero") double a, @RequestParam(name = "segundo") double b) {
        try {
            Resultado r = new Resultado();
            r.setResultado(a + b);
            return ResponseEntity.ok(r);
        }catch (Exception e){
            return ResponseEntity.ok(new Response("Error","Error en la solicitud"));
        }
    }

    @GetMapping("/historial")
    public ResponseEntity<?> getHistorial(@RequestParam(name = "inicio") Integer inicio, @RequestParam(name = "cantidad") Integer cantidad){
        try {
        return ResponseEntity.ok(historialService.findAll(inicio,cantidad));
        }catch (Exception e){
            return ResponseEntity.ok(new Response("Error","Error en la solicitud"));
        }
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session= request.getSession(false);
        SecurityContextHolder.clearContext();
        session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

        return "/home/";
    }

}
