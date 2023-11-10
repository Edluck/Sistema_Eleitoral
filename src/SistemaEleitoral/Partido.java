package SistemaEleitoral;

import java.util.HashMap;
import java.util.Map;

public class Partido {

    private String sg_partido;
    private int nr_partido;
    private Map<Integer, Candidato> candidatos = new HashMap<Integer, Candidato>();
    private int votos_legenda;
    private int votos_nominais_total;
    private int votos_totais;
    
    public Partido(String nome, int nr_partido) {
        this.sg_partido = nome;
        this.nr_partido = nr_partido;
        this.votos_legenda = 0;
        this.votos_totais = 0;
    }

    public int getVotosTotais() {
        votos_nominais_total = getVotosNominaisTotal();
        votos_totais = votos_nominais_total + votos_legenda;
        return votos_totais;
    }
    public int getVotosNominaisTotal() {
        votos_nominais_total = 0;
        for(Candidato c : candidatos.values()) {
            if (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16) {   
                votos_nominais_total += c.getQtd_votos();   
            }
        }
        return votos_nominais_total;
    }   

    public void addVotosLegenda(int votos) {
        this.votos_legenda += votos;
    }

    public int getVotosLegenda() {
        return votos_legenda;
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

        saida += sg_partido + " - " + nr_partido + "," ;

        return saida;
    }
    

}
