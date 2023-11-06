package SistemaEleitoral;

import java.util.HashMap;
import java.util.Map;

public class Partido {

    private String nome;
    private int numero;
    private int qtd_votos_nominais;
    private int qtd_votos_legenda;
    private Map<Integer, Candidato> candidatos = new HashMap<Integer, Candidato>();
    
    @Override
    public String toString() {
        return this.nome + " - " + this.numero + ", ";
    }

}
