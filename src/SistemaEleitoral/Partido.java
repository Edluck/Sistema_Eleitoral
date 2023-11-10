package SistemaEleitoral;

import java.util.HashMap;
import java.util.Map;

public class Partido {

    private String sg_partido;
    private int nr_partido;
    private Map<Integer, Candidato> candidatos = new HashMap<Integer, Candidato>();
    
    public Partido(String nome, int nr_partido) {
        this.sg_partido = nome;
        this.nr_partido = nr_partido;
    }

    public String getSg_partido() {
        return sg_partido;
    }

    public int getNr_partido() {
        return nr_partido;
    }

    void addCandidato(Candidato c) {
        candidatos.put(c.getNr_candidato(), c);
    }

    public Map<Integer, Candidato> getCandidatos() {
        return candidatos;
    }

    @Override
    public String toString() {
        String saida = "";

        saida += "Partido: " + sg_partido + " (" + nr_partido + ")\n";
        saida += "Candidatos:\n";
        for(Candidato c : candidatos.values()) {
            saida += c + "\n";
        }
        
        return saida;
    }
    

}
