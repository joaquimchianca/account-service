package ufrn.imd.accountservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ufrn.imd.accountservice.enums.StatusUsuario;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //info pessoais
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String nomeDaMae;

    //info de contato
    @OneToOne
    private Endereco endereco;
    private String telefone;
    private String email;

    //info financeira
    private String ocupacao;
    private BigDecimal rendaMensal;

    //status para soft delete
    private StatusUsuario status;

}
