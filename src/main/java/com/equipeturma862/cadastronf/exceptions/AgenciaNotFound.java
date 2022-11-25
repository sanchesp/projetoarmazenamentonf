package com.equipeturma862.cadastronf.exceptions;

import com.equipeturma862.cadastronf.domain.Agencia;
import com.equipeturma862.cadastronf.repository.AgenciaRepository;
import com.equipeturma862.cadastronf.service.AgenciaService;
import com.equipeturma862.cadastronf.service.AgenciaServiceImpl;

public class AgenciaNotFound extends RuntimeException  {

    public AgenciaNotFound () {
        super("Gentileza digitar numero de identificacao da agencia.");

    }
}
