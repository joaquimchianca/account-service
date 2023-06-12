package ufrn.imd.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
