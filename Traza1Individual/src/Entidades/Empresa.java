package Entidades;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "sucursales")
@ToString(exclude = "sucursales") // Lombok no muestra las sucursales, hacemos un toString manual
public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private String cuil;

    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa {")
                .append("id=").append(id)
                .append(", nombre='").append(nombre).append('\'')
                .append(", cuil=").append(cuil)
                .append(", sucursales=[");
        sucursales.forEach(s -> sb.append("\n   ").append(s.getNombre())
                .append(" (").append(s.getDomicilio().getCalle())
                .append(" ").append(s.getDomicilio().getNumero())
                .append(")"));
        sb.append("\n]}");
        return sb.toString();
    }
}
