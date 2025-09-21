package Repositorios;

import Entidades.Empresa;

import java.util.*;

public class EmpresaRepository {
    private Map<Long, Empresa> data = new HashMap<>();
    private long idCounter = 0;

    // Crear/Guardar
    public Empresa save(Empresa empresa) {
        idCounter++;
        empresa.setId(idCounter);
        data.put(idCounter, empresa);
        return empresa;
    }

    // Listar todas
    public List<Empresa> findAll() {
        return new ArrayList<>(data.values());
    }

    // Buscar por ID
    public Optional<Empresa> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    // Buscar por nombre
    public List<Empresa> findByNombre(String nombre) {
        List<Empresa> result = new ArrayList<>();
        for (Empresa e : data.values()) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                result.add(e);
            }
        }
        return result;
    }

    // Actualizar (ej: cambiar CUIL)
    public Optional<Empresa> update(Long id, Empresa empresaActualizada) {
        if (!data.containsKey(id)) {
            return Optional.empty();
        }
        empresaActualizada.setId(id); // mantengo el mismo ID
        data.put(id, empresaActualizada);
        return Optional.of(empresaActualizada);
    }

    // Eliminar
    public Optional<Empresa> delete(Long id) {
        return Optional.ofNullable(data.remove(id));
    }
}

