package ufrn.imd.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ufrn.imd.userservice.dto.UsuarioForm;
import ufrn.imd.userservice.model.Usuario;
import ufrn.imd.userservice.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastra( Usuario usuario ) {
        usuario.setDeletado(false);
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> listaTodos(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public Usuario listaUm(Long id) {
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

        return usuario;

    }

    public void deleta(Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.setDeletado(true);
    }

    public Page<Usuario> listaPorEmail(String email, Pageable pageable) {
        return usuarioRepository.findByEmail(email, pageable);
    }
}
