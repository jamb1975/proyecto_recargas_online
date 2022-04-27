package co.com.jamb.recragas.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;

@Document(collection = "operador")
@Data
public class Operador {
    @Id
    private String id;
    @JsonProperty("nombre_operador")
    private String nombreOperador;
}

