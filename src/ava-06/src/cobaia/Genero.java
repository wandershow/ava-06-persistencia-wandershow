package cobaia;

public enum Genero {
	Feminino("f"), Masculino("m"), NaoBinario("n");
	
	public final String LETRA;

	Genero(String l) {
		this.LETRA = l;
			

}
	public static Genero fromString(String str) {
		if (str == null) return null;
		char c = str.toLowerCase().charAt(0); // f, m, n
		switch (c) {
		case 'f': return Genero.Feminino;
		case 'm': return Genero.Masculino;
		case 'n': return Genero.NaoBinario;
		}
		return null;
	}
}
	