
package ar.edu.unju.escmi.tp8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.unju.escmi.tp8.model.Empresa;
import ar.edu.unju.escmi.tp8.service.IEmpresaService;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private IEmpresaService empresaService;

    @GetMapping
    public List<Empresa> getEmpresas() {
        return empresaService.obtenerEmpresas();
    }

    @GetMapping("/{id}")
    public Empresa getEmpresaById(@PathVariable int id) {
        return empresaService.buscarEmpresaId(id);
    }

    @PostMapping
    public ResponseEntity<Empresa> addEmpresa(
            @RequestBody Empresa empresa) {

        empresaService.guardarEmpresa(empresa);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empresa);
    }

    @PutMapping("/{id}")
    public Empresa updateEmpresa(
            @PathVariable int id,
            @RequestBody Empresa empresa) {

        empresaService.modificarEmpresa(id, empresa);

        return empresaService.buscarEmpresaId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(
            @PathVariable int id) {

        empresaService.eliminarEmpresa(id);

        return ResponseEntity.noContent().build();
    }
}
