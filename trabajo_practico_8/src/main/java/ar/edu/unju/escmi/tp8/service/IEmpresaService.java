
package ar.edu.unju.escmi.tp8.service;

import java.util.List;

import ar.edu.unju.escmi.tp8.model.Empresa;

public interface IEmpresaService {

    void guardarEmpresa(Empresa empresa);

    List<Empresa> obtenerEmpresas();

    Empresa buscarEmpresaId(int id);

    void modificarEmpresa(int id, Empresa empresa);

    void eliminarEmpresa(int id);
}
