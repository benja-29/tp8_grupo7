
package ar.edu.unju.escmi.tp8.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp8.model.Empresa;

public abstract class CollectionEmpresa {

    public static List<Empresa> empresas =
            new ArrayList<>();

    public static void precargarEmpresas() {

        if (empresas.isEmpty()) {

            empresas.add(new Empresa(
                    1, "Empresa Norte", 25,
                    "3884001111", "San Salvador de Jujuy"));

            empresas.add(new Empresa(
                    2, "Empresa Sur", 40,
                    "3884002222", "Palpala"));

            empresas.add(new Empresa(
                    3, "Empresa Andina", 15,
                    "3884003333", "Abra Pampa"));
        }
    }
}
