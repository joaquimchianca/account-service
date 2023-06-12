package ufrn.imd.userservice.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ufrn.imd.userservice.model.Endereco;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioForm {
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String nomeDaMae;
    private String senha;

    //info de contato
    private Endereco endereco;
    private String telefone;
    private String email;

    //info financeira
    private BigDecimal rendaMensal;

}
