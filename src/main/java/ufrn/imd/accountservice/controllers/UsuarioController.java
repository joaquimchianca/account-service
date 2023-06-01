package ufrn.imd.accountservice.controllers;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.imd.accountservice.models.Usuario;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> cadastrar(
            @RequestBody Usuario form
    ) {
        //chamada para service
        //criacao da uri
        //retorno da response entity com a uri
        return ResponseEntity.ok(form);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario procuraPorId(
            @PathVariable Long id
    ){
        //chamada service
        return new Usuario();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizaUsuario(
            @PathVariable Long id
    ) {
        //chamada service
        return new Usuario();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleta(
            @PathVariable Long id
    ) {
        //chamada do service
    }

}
