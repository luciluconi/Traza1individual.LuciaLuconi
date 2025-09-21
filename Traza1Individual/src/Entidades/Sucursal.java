package Entidades;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"domicilio", "empresa"})
@ToString(exclude = {"domicilio", "empresa"})
public class Sucursal {
    private Long id;          // Identificador único
    private String nombre;    // Nombre de la sucursal
    private Domicilio domicilio; // Relación: una sucursal tiene un domicilio
    private Empresa empresa;     // Relación: una sucursal pertenece a una empresa
}
