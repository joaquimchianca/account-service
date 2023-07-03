package ufrn.imd.userservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufrn.imd.userservice.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
     Page<Usuario> findByEmail(String email, Pageable pageable);

}
