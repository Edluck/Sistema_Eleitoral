package SistemaEleitoral;

import java.util.HashMap;
import java.util.Map;

import CSVReader.CSVCandidatosReader;
import CSVReader.CSVVotacaoReader;

public class Acervo {
    private Map<Integer, Candidato> candidatos = new HashMap<Integer, Candidato>();
    private Map<Integer, Partido> partidos = new HashMap<Integer, Partido>();
    
    public Acervo(String tipo_deputado,String arq_cand, String arq_vot, String data_eleicao) {
        try {
            CSVCandidatosReader.candidatosReader(tipo_deputado,arq_cand, data_eleicao, candidatos, partidos);
            CSVVotacaoReader.votacaoReader(tipo_deputado,arq_vot, candidatos, partidos);
            //imprime_partidos();
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivos");
            e.printStackTrace();
        }
    }

    public void geraRelatorio(String tipo_deputado) {
        GeraRelatorios.geraRelatorioTodos(tipo_deputado, candidatos, partidos);
    }

}
