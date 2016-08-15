package br.edu.ifpb.collegialis.type;

public enum TipoPerfil {
	ADMIN("Admin"),
	MEMBRO("Membro"),
	COORDENADOR("Coordenador"),
	SECRETARIO("Secret�rio");
	
	private String texto;
	
	private TipoPerfil(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

}
