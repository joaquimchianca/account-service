package ufrn.imd.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ufrn.imd.userservice.dto.UsuarioForm;
import ufrn.imd.userservice.model.Log;
import ufrn.imd.userservice.model.Usuario;
import ufrn.imd.userservice.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final LogService logger;

    @Autowired
    public UsuarioService(LogService logger, UsuarioRepository repository) {
        this.logger = logger;
        this.usuarioRepository = repository;
    }


    public Usuario cadastra( Usuario usuario ) {
        usuario.setDeletado(false);

        logger.send( Log.builder()
                        .className(this.getClass().getName())
                        .method("cadastro")
                        .context("main")
                        .level(LogLevel.INFO)
                        .message("saved new user " + usuario.getId())
                .build());
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> listaTodos(Pageable pageable) {
        logger.send( Log.builder()
                .className(this.getClass().getName())
                .method("listaTodos")
                .context("main")
                .level(LogLevel.INFO)
                .message("searched all users")
                .build());
        return usuarioRepository.findAll(pageable);
    }

    public Usuario listaUm(Long id) {
        logger.send( Log.builder()
                .className(this.getClass().getName())
                .method("listaUm")
                .context("main")
                .level(LogLevel.INFO)
                .message("searched user " + id)
                .build());
        return usuarioRepository.getReferenceById(id);
    }

    public Usuario atualizaInfo(Long id, UsuarioForm form) {
        Usuario usuario = usuarioRepository.getReferenceById(id);

        if(form.getNome() != null) {
            usuario.setNome(form.getNome());
        }

        if(form.getSobrenome() != null) {
            usuario.setSobrenome(form.getSobrenome());
        }

        if(form.getDataNascimento() != null) {
            usuario.setDataNascimento(form.getDataNascimento());
        }

        if(form.getCpf() != null) {
            usuario.setCpf(form.getCpf());
        }

        if(form.getRg() != null) {
            usuario.setRg(form.getRg());
        }

        if(form.getNomeDaMae() != null) {
            usuario.setNomeDaMae(form.getNomeDaMae());
        }

        if(form.getSenha() != null) {
            usuario.setSenha(form.getSenha());
        }

        if(form.getEndereco() != null) {
            usuario.setEndereco(form.getEndereco());
        }

        if(form.getTelefone() != null) {
            usuario.setTelefone(form.getTelefone());
        }

        if(form.getEmail() != null) {
            usuario.setEmail(form.getEmail());
        }

        if(form.getRendaMensal() != null) {
            usuario.setRendaMensal(form.getRendaMensal());
        }

        logger.send( Log.builder()
                .className(this.getClass().getName())
                .method("atualiza")
                .context("main")
                .level(LogLevel.INFO)
                .message("saved new changes in user " + usuario.getId())
                .build());

        return usuario;

    }

    public void deleta(Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.setDeletado(true);

        logger.send( Log.builder()
                .className(this.getClass().getName())
                .method("deleta")
                .context("main")
                .level(LogLevel.INFO)
                .message("deleted user " + id)
                .build());
    }

    public Page<Usuario> listaPorEmail(String email, Pageable pageable) {
        logger.send( Log.builder()
                .className(this.getClass().getName())
                .method("listaPorEmail")
                .context("main")
                .level(LogLevel.INFO)
                .message("searched user by email " + email)
                .build());
        return usuarioRepository.findByEmail(email, pageable);
    }
}
