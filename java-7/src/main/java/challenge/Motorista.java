package challenge;

import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
    	this.nome = verificarNome(nome);
        this.idade = verificarIdade(idade);
        this.pontos = verificarPontos(pontos);
        this.habilitacao = verificarHabilitacao(habilitacao);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
       		this.nome = verificarNome(nome);
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
       			this.idade = verificarIdade(idade);
       			return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
           	this.pontos = verificarPontos(pontos);
           	return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
           	this.habilitacao = verificarHabilitacao (habilitacao);
           	return this;
        }

        public Motorista build() {
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }
 
    private static String verificarNome(String nome ) {
    	if (nome == null || nome.isEmpty()) {
    		throw new NullPointerException("Motorista deve conter nome.");
    	}else{
    	   	return nome;
    	}
    }
    
    private static int verificarIdade(int idade) {
    	if (idade < 0) {
    		throw new IllegalArgumentException("Motorista deve conter idade.");
    	}else {
    		return idade;
    	}
    }

    private static int verificarPontos(int pontos) {
    	if (pontos < 0) {
    		throw new IllegalArgumentException("Motorista deve conter pontos maior que 0.");
    	}else {
    		return pontos;
    	}
    }

    private static String verificarHabilitacao(String habilitacao ) {
    	if (habilitacao == null || habilitacao.isEmpty()) {
    		throw new NullPointerException("Motorista deve conter habilitacao.");
    	}else{
    	   	return habilitacao;
    	}
    }
}
