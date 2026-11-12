
package ar.edu.unju.escmi.tp8.service.imp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.unju.escmi.tp8.collections.CollectionEmpresa;
import ar.edu.unju.escmi.tp8.model.Empresa;
import ar.edu.unju.escmi.tp8.service.IEmpresaService;

@Service
public class EmpresaServiceImp implements IEmpresaService {

    @Override
    public void guardarEmpresa(Empresa empresa) {

        validarEmpresa(empresa);

        if (empresa.getId() <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "ID invalido");
        }

        for (Empresa e : CollectionEmpresa.empresas) {
            if (e.getId() == empresa.getId()) {
                throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe una empresa con ese ID");
            }
        }

        CollectionEmpresa.empresas.add(empresa);
    }

    @Override
    public List<Empresa> obtenerEmpresas() {
        return CollectionEmpresa.empresas;
    }

    @Override
    public Empresa buscarEmpresaId(int id) {

        for (Empresa empresa : CollectionEmpresa.empresas) {

            if (empresa.getId() == id) {
                return empresa;
            }
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Empresa no encontrada");
    }

    @Override
    public void modificarEmpresa(int id, Empresa empresa) {

        validarEmpresa(empresa);

        Empresa existente = buscarEmpresaId(id);

        existente.setNombre(empresa.getNombre());
        existente.setCantidadEmpleados(
            empresa.getCantidadEmpleados());
        existente.setTelefono(empresa.getTelefono());
        existente.setDireccion(empresa.getDireccion());
    }

    @Override
    public void eliminarEmpresa(int id) {

        Empresa empresa = buscarEmpresaId(id);

        CollectionEmpresa.empresas.remove(empresa);
    }

    private void validarEmpresa(Empresa empresa) {

        if (empresa == null
                || empresa.getNombre() == null
                || empresa.getNombre().isBlank()
                || empresa.getCantidadEmpleados() < 0
                || empresa.getTelefono() == null
                || empresa.getTelefono().isBlank()
                || empresa.getDireccion() == null
                || empresa.getDireccion().isBlank()) {

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Datos de empresa invalidos");
        }
    }
}
