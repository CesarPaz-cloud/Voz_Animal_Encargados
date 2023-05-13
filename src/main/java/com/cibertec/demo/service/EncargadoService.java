package com.cibertec.demo.service;



import com.cibertec.demo.model.Encargado;

import java.util.List;

public interface EncargadoService {
    List<Encargado> listarEncargados();
    void guardarEncargos(Encargado encargado);
    Encargado obtenerEncargados(long id);
    void eliminarEncargados (long id);
}
