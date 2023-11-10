package SistemaEleitoral;

import java.text.DecimalFormat;
import java.util.Map;

public class GeraRelatorios {

    public static void geraRelatorioTodos(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        geraRelatorio10(tipo_deputado, candidatos, partidos);
    }

    public static void geraRelatorio1(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio2(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio3(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio4(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio5(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio6(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio7(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio8(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio9(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio10(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        int total_votos_legenda = 0;
        int total_votos_nomimais = 0;
        int total_votos_validos = 0;
        double percentual_votos_legenda = 0;
        double percentual_votos_nomimais = 0;

        int tipo_cand = 0;
        if(tipo_deputado.equals("federal"))
            tipo_cand = 6;
        else if(tipo_deputado.equals("estadual"))
            tipo_cand = 7;

        for(Partido p : partidos.values()) {
            total_votos_legenda += p.getVotosLegenda();
            for(Candidato c : p.getCandidatos().values()) {
                if(c.getCd_cargo() == tipo_cand && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16))
                total_votos_nomimais += c.getQtd_votos();
            }
            }
        
        total_votos_validos = total_votos_legenda + total_votos_nomimais;
        percentual_votos_legenda = ((double)total_votos_legenda / total_votos_validos)*100;
        percentual_votos_nomimais = ((double)total_votos_nomimais / total_votos_validos)*100;

        DecimalFormat df = new DecimalFormat("0.00");
        percentual_votos_legenda = Double.parseDouble(df.format(percentual_votos_legenda).replace(",", "."));
        percentual_votos_nomimais = Double.parseDouble(df.format(percentual_votos_nomimais).replace(",", "."));

        System.out.println("Total de votos válidos: " + total_votos_validos);
        System.out.println("Total de votos nominais: " + total_votos_nomimais + " (" + percentual_votos_nomimais + "%)");
        System.out.println("Total de votos de legenda: " + total_votos_legenda + " (" + percentual_votos_legenda + "%)");
    }
}
