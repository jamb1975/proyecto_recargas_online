package co.com.jamb.recragas.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Terceros {

    @Id
    private String id;
    @JsonProperty("nombre_tercero")
    private String nombreTercero;
}
