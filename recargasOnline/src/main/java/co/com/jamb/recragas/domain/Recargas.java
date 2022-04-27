package co.com.jamb.recragas.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;

@Document(collection = "mutantes")
@Data
public class Recargas {
    @Id
    private String id;

    @JsonProperty("id_persona")
    private String idPersona;
    @JsonProperty("id_operador")
    private String idOperador;
    @JsonProperty("valor")
    private long valor;
    @JsonProperty("numero_celular")
    private String numeroCelular;
    public Recargas() {

    }
}
