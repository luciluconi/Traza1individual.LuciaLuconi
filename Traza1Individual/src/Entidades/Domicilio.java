package Entidades;

import lombok.*;

// Lombok genera automáticamente getters, setters, constructor vacío, constructor con todos los parámetros,
// equals y hashCode (excluyendo localidad para evitar ciclos infinitos), y un toString (también excluyendo localidad).
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "localidad") // evitamos ciclos infinitos en equals/hashCode
@ToString(exclude = "localidad")          // evitamos ciclos infinitos en toString
public class Domicilio {
    private Long id;           // Identificador único del domicilio
    private String calle;      // Nombre de la calle
    private String numero;     // Número de la dirección

    private Localidad localidad; // Relación: cada domicilio pertenece a una localidad
}
