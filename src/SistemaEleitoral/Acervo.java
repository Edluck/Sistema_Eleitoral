package SistemaEleitoral;

import java.util.HashMap;
import java.util.Map;

import CSVReader.CSVCandidatosReader;
import CSVReader.CSVVotacaoReader;

public class Acervo {
    private Map<Integer, Candidato> candidatos = new HashMap<Integer, Candidato>();
    private Map<Integer, Partido> partidos = new HashMap<Integer, Partido>();
    
    public Acervo(String arq_cand, String arq_vot, String data_eleicao) {
        try {
            CSVCandidatosReader.candidatosReader(arq_cand, data_eleicao, candidatos);
            cria_partidos(candidatos);
            CSVVotacaoReader.votacaoReader(arq_vot, candidatos, partidos);
            imprime_partidos();
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivos");
            e.printStackTrace();
        }
    }

    private void cria_partidos(Map<Integer, Candidato> candidatos) {
        for(Candidato c : candidatos.values()) {
            if(partidos.containsKey(c.getNr_partido())) {
                partidos.get(c.getNr_partido()).addCandidato(c);
            }
            else {
                Partido p = new Partido(c.getSg_partido(), c.getNr_partido());
                p.addCandidato(c);
                partidos.put(c.getNr_partido(), p);
            }
        }
    }

    private void imprime_partidos(){
        for(Partido p : partidos.values()) {
            System.out.println(p);
        }
    }

    public void geraRelatorio(String tipo_deputado) {
        GeraRelatorios.geraRelatorioTodos(tipo_deputado, candidatos, partidos);
    }

}
