package com.equipeturma862.cadastronf.exceptions;

import com.equipeturma862.cadastronf.domain.*;
import com.equipeturma862.cadastronf.repository.*;
import com.equipeturma862.cadastronf.service.*;

public class FuncionarioNotFound extends RuntimeException {
	
	public FuncionarioNotFound () {
		super ("Por favor digitar o codigo funcional do funcionario");
	}
}
