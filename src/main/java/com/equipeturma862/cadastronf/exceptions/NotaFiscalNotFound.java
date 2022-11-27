package com.equipeturma862.cadastronf.exceptions;

import com.equipeturma862.cadastronf.domain.*;
import com.equipeturma862.cadastronf.repository.*;
import com.equipeturma862.cadastronf.service.*;

public class NotaFiscalNotFound extends RuntimeException  {
	
	public NotaFiscalNotFound() {
		super("Por favor digitar o numero da nota fiscal");
		
	}

}
