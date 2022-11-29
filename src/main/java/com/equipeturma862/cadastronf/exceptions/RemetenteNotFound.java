package com.equipeturma862.cadastronf.exceptions;

import com.equipeturma862.cadastronf.domain.*;
import com.equipeturma862.cadastronf.repository.*;
import com.equipeturma862.cadastronf.service.*;

public class RemetenteNotFound extends RuntimeException{
	
	public RemetenteNotFound () {
		super ("Remetente não localizado");
	}
}
