package ufrn.imd.userservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import ufrn.imd.userservice.enums.StatusUsuario;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
@SQLDelete(sql = "UPDATE usuario SET deletado = true WHERE id=?")
@Where(clause = "deletado=false")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //info pessoais
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String nomeDaMae;
    private String senha;

    //info de contato
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    private String telefone;
    private String email;

    //info financeira
    private String ocupacao;
    private BigDecimal rendaMensal;

    //status para soft delete
    private boolean deletado = Boolean.FALSE;

}
