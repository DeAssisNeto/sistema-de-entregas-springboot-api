package sistema.entregas.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Table(name = "costumer_tb")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String cpf;

    public CustomerModel(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public CustomerModel(UUID id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }
}
