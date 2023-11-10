package SistemaEleitoral;

import java.text.DecimalFormat;
import java.util.Map;

public class GeraRelatorios {

    public static void geraRelatorioTodos(String tipo_deputado,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        int nr_tipo_cand = 0;
        if(tipo_deputado.equals("federal"))
            nr_tipo_cand = 6;
        else if(tipo_deputado.equals("estadual"))
            nr_tipo_cand = 7;
        
        geraRelatorio1(nr_tipo_cand, candidatos, partidos);
        geraRelatorio2(nr_tipo_cand, candidatos, partidos);
        geraRelatorio3(nr_tipo_cand, candidatos, partidos);
        geraRelatorio4(nr_tipo_cand, candidatos, partidos);
        geraRelatorio5(nr_tipo_cand, candidatos, partidos);
        geraRelatorio6(nr_tipo_cand, candidatos, partidos);
        geraRelatorio7(nr_tipo_cand, candidatos, partidos);
        geraRelatorio8(nr_tipo_cand, candidatos, partidos);
        geraRelatorio9(nr_tipo_cand, candidatos, partidos);
        geraRelatorio10(nr_tipo_cand, candidatos, partidos);
    }

    public static void geraRelatorio1(int nr_tipo_cand,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        int nr_vagas = 0, i = 1;
        for(Candidato c : candidatos.values()) {
            if(c.getCd_cargo() == nr_tipo_cand && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if(c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)
                nr_vagas++;
            }
        }
        System.out.println("Número de vagas: " + nr_vagas + "\n");
        if(nr_tipo_cand == 6)
            System.out.println("Deputados federais eleitos: ");
        else if(nr_tipo_cand == 7)
            System.out.println("Deputados estaduais eleitos: ");

        for(Candidato c: candidatos.values()) {
            if(c.getCd_cargo() == nr_tipo_cand && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if(c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3) {
                System.out.println(i + " - " + c);
                i++;
                }
            }
        }
    }
    public static void geraRelatorio2(int nr_tipo_cand,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio3(int nr_tipo_cand,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio4(int nr_tipo_cand,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio5(int nr_tipo_cand,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio6(int nr_tipo_cand,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio7(int nr_tipo_cand,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio8(int nr_tipo_cand,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        
    }
    public static void geraRelatorio9(int nr_tipo_cand,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        System.out.println("Eleitos, por gênero:");
        int qtd_masculino = 0;
        int qtd_feminino = 0;
        double porcentagem_masculino = 0;
        double porcentagem_feminino = 0;

        for(Candidato c : candidatos.values()) {
            if((c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3) && c.getCd_cargo() == nr_tipo_cand) {
                if(c.getCd_genero() == 2)
                    qtd_masculino++;
                else if(c.getCd_genero() == 4)
                    qtd_feminino++;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        porcentagem_masculino = ((double)qtd_masculino / (qtd_masculino + qtd_feminino))*100;
        porcentagem_feminino = ((double)qtd_feminino / (qtd_masculino + qtd_feminino))*100;
        porcentagem_masculino = Double.parseDouble(df.format(porcentagem_masculino).replace(",", ","));
        porcentagem_feminino = Double.parseDouble(df.format(porcentagem_feminino).replace(",", ","));

        System.out.println("Feminino: " + qtd_feminino + " (" + porcentagem_feminino + "%)");
        System.out.println("Masculino: " + qtd_masculino + " (" + porcentagem_masculino + "%)");
    }
    public static void geraRelatorio10(int nr_tipo_cand,Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos) {
        int total_votos_legenda = 0;
        int total_votos_nomimais = 0;
        int total_votos_validos = 0;
        double percentual_votos_legenda = 0;
        double percentual_votos_nomimais = 0;

        for(Partido p : partidos.values()) {
            total_votos_legenda += p.getVotosLegenda();
            for(Candidato c : p.getCandidatos().values()) {
                if(c.getCd_cargo() == nr_tipo_cand && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16))
                total_votos_nomimais += c.getQtd_votos();
            }
            }
        
        total_votos_validos = total_votos_legenda + total_votos_nomimais;
        percentual_votos_legenda = ((double)total_votos_legenda / total_votos_validos)*100;
        percentual_votos_nomimais = ((double)total_votos_nomimais / total_votos_validos)*100;

        DecimalFormat df = new DecimalFormat("0.00");
        percentual_votos_legenda = Double.parseDouble(df.format(percentual_votos_legenda).replace(",", ","));
        percentual_votos_nomimais = Double.parseDouble(df.format(percentual_votos_nomimais).replace(",", ","));

        System.out.println("Total de votos válidos: " + total_votos_validos);
        System.out.println("Total de votos nominais: " + total_votos_nomimais + " (" + percentual_votos_nomimais + "%)");
        System.out.println("Total de votos de legenda: " + total_votos_legenda + " (" + percentual_votos_legenda + "%)");
    }
}
