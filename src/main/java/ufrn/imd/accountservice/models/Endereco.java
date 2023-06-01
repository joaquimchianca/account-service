package ufrn.imd.accountservice.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cidade;
    private String bairro;
    private String logradouro;
    private int numero;
    private String cep;
    private String complemento;
}
