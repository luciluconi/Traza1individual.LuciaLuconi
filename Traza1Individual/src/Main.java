import Entidades.*;
import Repositorios.EmpresaRepository;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmpresaRepository empresaRepository = new EmpresaRepository();

        System.out.println(" ----------- PROBAMOS EL SISTEMA ----------");

        // --------------------
        // Provincias y Localidades
        // --------------------
        Provincia buenosAires = Provincia.builder().id(1L).nombre("Buenos Aires").build();
        Localidad caba = Localidad.builder().id(1L).nombre("CABA").provincia(buenosAires).build();
        Localidad laPlata = Localidad.builder().id(2L).nombre("La Plata").provincia(buenosAires).build();

        Provincia cordoba = Provincia.builder().id(2L).nombre("Córdoba").build();
        Localidad cordobaCapital = Localidad.builder().id(3L).nombre("Córdoba Capital").provincia(cordoba).build();
        Localidad villaCarlosPaz = Localidad.builder().id(4L).nombre("Villa Carlos Paz").provincia(cordoba).build();

        // --------------------
        // Domicilios
        // --------------------
        Domicilio domCaba = Domicilio.builder().id(1L).calle("Av. Corrientes").numero("1234").localidad(caba).build();
        Domicilio domLaPlata = Domicilio.builder().id(2L).calle("Calle 50").numero("500").localidad(laPlata).build();
        Domicilio domCordoba = Domicilio.builder().id(3L).calle("San Martín").numero("200").localidad(cordobaCapital).build();
        Domicilio domVilla = Domicilio.builder().id(4L).calle("Av. Libertad").numero("50").localidad(villaCarlosPaz).build();

        // --------------------
        // Sucursales
        // --------------------
        Sucursal sucursal1 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal Central CABA")
                .domicilio(domCaba)
                .build();

        Sucursal sucursal2 = Sucursal.builder()
                .id(2L)
                .nombre("Sucursal La Plata")
                .domicilio(domLaPlata)
                .build();

        Sucursal sucursal3 = Sucursal.builder()
                .id(3L)
                .nombre("Sucursal Córdoba Capital")
                .domicilio(domCordoba)
                .build();

        Sucursal sucursal4 = Sucursal.builder()
                .id(4L)
                .nombre("Sucursal Villa Carlos Paz")
                .domicilio(domVilla)
                .build();

        // --------------------
        // Empresas
        // --------------------
        Empresa empresa1 = Empresa.builder()
                .id(1L)
                .nombre("Empresa de Comestibles")
                .cuil("30-12345678-9")
                .sucursales(new HashSet<>(Arrays.asList(sucursal1, sucursal2)))
                .build();

        Empresa empresa2 = Empresa.builder()
                .id(2L)
                .nombre("Empresa de Joyería")
                .cuil("30-98765432-1")
                .sucursales(new HashSet<>(Arrays.asList(sucursal3, sucursal4)))
                .build();

        // Relacionamos sucursales con sus empresas
        sucursal1.setEmpresa(empresa1);
        sucursal2.setEmpresa(empresa1);
        sucursal3.setEmpresa(empresa2);
        sucursal4.setEmpresa(empresa2);

        // --------------------
        // Guardar en repositorio
        // --------------------
        empresaRepository.save(empresa1);
        empresaRepository.save(empresa2);

        // --------------------
        // PROBAR CRUD
        // --------------------
        System.out.println("\n--- Todas las empresas ---");
        empresaRepository.findAll().forEach(System.out::println);

        System.out.println("\n--- Buscar por ID 1 ---");
        empresaRepository.findById(1L).ifPresent(System.out::println);

        System.out.println("\n--- Buscar por nombre 'Empresa de Joyería' ---");
        empresaRepository.findByNombre("Empresa de Joyería").forEach(System.out::println);

        System.out.println("\n--- Actualizar Empresa de Comestibles (cuil) ---");
        Empresa empresa1Actualizada = Empresa.builder()
                .id(1L)
                .nombre("Empresa de Comestibles")
                .cuil("30-11111111-1") // cuil actualizado
                .sucursales(empresa1.getSucursales()) // mantiene las sucursales
                .build();
        empresaRepository.update(1L, empresa1Actualizada);
        empresaRepository.findById(1L).ifPresent(System.out::println);

        System.out.println("\n--- Eliminar Empresa de Joyería ---");
        empresaRepository.delete(2L);
        empresaRepository.findAll().forEach(System.out::println);

        System.out.println("\n--- Mostrar las sucursales de la Empresa de Comestibles ---");
        empresaRepository.findById(1L).ifPresent(e ->
                e.getSucursales().forEach(System.out::println)
        );
    }
}
