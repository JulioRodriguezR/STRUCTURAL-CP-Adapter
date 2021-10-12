package org.formacion;

public class InternalMoneyAdapter implements InternationalMoneyOrganization {

	// Current class as a wrapper of existing system (BancoNostrum)
	private BancoNostrum impl;
	
	public InternalMoneyAdapter(BancoNostrum impl) {
		this.impl = impl;
	}
	
	// Translates from API InternationalMoneyOrganization to API BancoNostrum
	
	@Override
	public void transfer(int cantidad, String cliente) {
		this.impl.movimiento(cliente, cantidad);
	}

	@Override
	public int state(String cliente) {
		Integer result = impl.estado(cliente);
		if (result == null) {
			return 0;
		}
		return result;
	}

}
