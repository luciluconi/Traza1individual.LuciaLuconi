package Entidades;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Data // Genera getters, setters, toString, equals y hashCode automáticamente
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los atributos
@Builder // Permite usar el patrón Builder para crear objetos
@EqualsAndHashCode(exclude = "provincias") // Evita que "provincias" se use en equals/hashCode (para no generar ciclos infinitos)
public class Pais {
    private Long id;         // Identificador único del país
    private String nombre;   // Nombre del país

    @Builder.Default
    private Set<Provincia> provincias = new HashSet<>();
    // Un país puede tener muchas provincias → las guardamos en un HashSet
}
