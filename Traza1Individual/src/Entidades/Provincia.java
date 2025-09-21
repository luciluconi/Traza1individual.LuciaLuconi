package Entidades;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"localidades", "pais"})
// Excluimos "localidades" y "pais" para evitar ciclos en equals/hashCode
public class Provincia {
    private Long id;
    private String nombre;

    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();
    // Una provincia puede tener muchas localidades

    private Pais pais; // Cada provincia pertenece a un país
}

