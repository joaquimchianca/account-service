package ufrn.imd.userservice.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.imd.userservice.model.Usuario;
import ufrn.imd.userservice.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> cadastrar(
            @RequestBody Usuario form
    ) {
        Usuario usuario = usuarioService.cadastra(form);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> listaTodos(Pageable pageable) {
        Page<Usuario> usuarios = usuarioService.listaTodos(pageable);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listaUm(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(usuarioService.listaUm(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> atualizaInfo(
            @PathVariable Long id,
            @RequestBody Usuario form
    ) {
        Usuario usuario = usuarioService.atualizaInfo(id, form);
        if(usuario == null) {
            return new ResponseEntity<>(usuario, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleta(
            @PathVariable Long id
    ) {
        usuarioService.deleta(id);
    }

}
