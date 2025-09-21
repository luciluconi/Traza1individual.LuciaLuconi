package Entidades;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"domicilios", "provincia"})
@ToString(exclude = {"domicilios", "provincia"}) // Excluimos para evitar bucles
public class Localidad {
    private Long id;
    private String nombre;

    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();

    private Provincia provincia;
}
