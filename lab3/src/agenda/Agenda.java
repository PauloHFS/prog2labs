package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}
	
	/**
	 * Acessa os dados de contatos com nome especifico.
	 * @param nome Nome do contato na agenda.
	 * @return Dados dos contatos.
	 */
	public String getContatos(String nome) {
		String dados = "";
		for (Contato c: this.contatos) {
			if (c.getNomeCompleto().contains(nome)) {
				dados += c + "\n\n";
			}
		}
		return dados;
	}

	/**
	 * Retorna o primeiro contato encontrado desejado.
	 * @param contato Contato desejado
	 * @return Primeiro contato igual encontrado
	 */
	public Contato getContato(Contato contato) {
		Contato contatoDesejado = null;
		for (Contato c: this.contatos) {
			if (c.equals(contato)) {
				contatoDesejado = c;
				break;
			}
		}
		return contatoDesejado;
	}
	
	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição. 
	 */
	public Contato getContato(int posicao) {
		Contato contato;
		try {
			contato = this.contatos[posicao-1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Index " + posicao + " não está dentro dos limites da Agenda! [1,100]");
		} 
		return contato;			
		
	}

	
	/**
	 * Gera uma String com os contatos e números prioritários.
	 * @return String contendo todos os contatos e seus respectivos números prioritários.
	 */
	public String getTelefonesPreferidos() {
		String telefonesPreferidos = "";
		for (Contato c: this.contatos) {
			if (c != null) {
				telefonesPreferidos += c.getNomeCompleto() + " - " + c.getTelefonePrioritario() + "\n";
			}
		}
		return telefonesPreferidos;
	}
	
	/**
	 * Gera uma String com os contatos e seus números do WhatsApp.
	 * @return String contendo todos os contatos e seus respectivos números do WhatsApp.
	 */
	public String getContatosWhatsApp() {
		String contatosWhatsApp = "";
		for (Contato c: this.contatos) {
			if (c != null) {
				contatosWhatsApp += c.getNomeCompleto() + " - " + c.getContatoWhatsApp() + "\n";
			}
		}
		return contatosWhatsApp;
	}
	
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param numerosTelefone Array dos números dos telefones.
	 * @param telefonePrioritario Identificador do número prioritário.
	 * @param contatoWhatsApp Identificador do número do contato do WhatsApp.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String[] numerosTelefone, int telefonePrioritario, int contatoWhatsApp) {
		try {
			this.contatos[posicao-1] = new Contato(nome, sobrenome, numerosTelefone, telefonePrioritario, contatoWhatsApp);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Index " + posicao + " não está dentro dos limites da Agenda! [1,"+Agenda.TAMANHO_AGENDA+"]");
		}
	}

}
