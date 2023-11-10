package SistemaEleitoral;

import java.text.DecimalFormat;
import java.util.Map;

public class GeraRelatorios {

    public static void geraRelatorioTodos(String tipo_deputado, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {
        int nr_tipo_cand = 0;
        if (tipo_deputado.equals("federal"))
            nr_tipo_cand = 6;
        else if (tipo_deputado.equals("estadual"))
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

    public static void geraRelatorio1(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {
        int nr_vagas = 0, i = 1;
        for (Candidato c : candidatos.values()) {
            if (c.getCd_cargo() == nr_tipo_cand
                    && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)
                    nr_vagas++;
            }
        }
        System.out.println("Número de vagas: " + nr_vagas + "\n");
        if (nr_tipo_cand == 6)
            System.out.println("Deputados federais eleitos: ");
        else if (nr_tipo_cand == 7)
            System.out.println("Deputados estaduais eleitos: ");

        for (Candidato c : candidatos.values()) {
            if (c.getCd_cargo() == nr_tipo_cand
                    && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3) {
                    System.out.println(i + " - " + c);
                    i++;
                }
            }
        }
    }

    public static void geraRelatorio2(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {

    }

    public static void geraRelatorio3(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {

    }

    public static void geraRelatorio4(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {

    }

    public static void geraRelatorio5(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {

    }

    public static void geraRelatorio6(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {

    }

    public static void geraRelatorio7(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {

    }

    public static void geraRelatorio8(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {
        int idade_menor_30 = 0;
        int idade_30_40 = 0;
        int idade_40_50 = 0;
        int idade_50_60 = 0;
        int idade_maior_60 = 0;
        double porcentagem_menor_30 = 0;
        double porcentagem_30_40 = 0;
        double porcentagem_40_50 = 0;
        double porcentagem_50_60 = 0;
        double porcentagem_maior_60 = 0;
        System.out.println("\nEleitos, por faixa etária (na data de eleição):");
        for (Candidato c : candidatos.values()) {
            if (c.getCd_cargo() == nr_tipo_cand && (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)) {
                if (c.getIdade() < 30)
                    idade_menor_30++;
                else if (c.getIdade() >= 30 && c.getIdade() < 40)
                    idade_30_40++;
                else if (c.getIdade() >= 40 && c.getIdade() < 50)
                    idade_40_50++;
                else if (c.getIdade() >= 50 && c.getIdade() < 60)
                    idade_50_60++;
                else if (c.getIdade() >= 60)
                    idade_maior_60++;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        porcentagem_menor_30 = ((double) idade_menor_30
                / (idade_menor_30 + idade_30_40 + idade_40_50 + idade_50_60 + idade_maior_60)) * 100;
        porcentagem_30_40 = ((double) idade_30_40
                / (idade_menor_30 + idade_30_40 + idade_40_50 + idade_50_60 + idade_maior_60)) * 100;
        porcentagem_40_50 = ((double) idade_40_50
                / (idade_menor_30 + idade_30_40 + idade_40_50 + idade_50_60 + idade_maior_60)) * 100;
        porcentagem_50_60 = ((double) idade_50_60
                / (idade_menor_30 + idade_30_40 + idade_40_50 + idade_50_60 + idade_maior_60)) * 100;
        porcentagem_maior_60 = ((double) idade_maior_60
                / (idade_menor_30 + idade_30_40 + idade_40_50 + idade_50_60 + idade_maior_60)) * 100;
        porcentagem_menor_30 = Double.parseDouble(df.format(porcentagem_menor_30).replace(",", ","));
        porcentagem_30_40 = Double.parseDouble(df.format(porcentagem_30_40).replace(",", ","));
        porcentagem_40_50 = Double.parseDouble(df.format(porcentagem_40_50).replace(",", ","));
        porcentagem_50_60 = Double.parseDouble(df.format(porcentagem_50_60).replace(",", ","));
        porcentagem_maior_60 = Double.parseDouble(df.format(porcentagem_maior_60).replace(",", ","));

        System.out.println("      Idade < 30: " + idade_menor_30 + " (" + porcentagem_menor_30 + "%)");
        System.out.println("30 <= Idade < 40: " + idade_30_40 + " (" + porcentagem_30_40 + "%)");
        System.out.println("40 <= Idade < 50: " + idade_40_50 + " (" + porcentagem_40_50 + "%)");
        System.out.println("50 <= Idade < 60: " + idade_50_60 + " (" + porcentagem_50_60 + "%)");
        System.out.println("60 <= Idade     : " + idade_maior_60 + " (" + porcentagem_maior_60 + "%)");
    }

    public static void geraRelatorio9(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {
        System.out.println("\nEleitos, por gênero:");
        int qtd_masculino = 0;
        int qtd_feminino = 0;
        double porcentagem_masculino = 0;
        double porcentagem_feminino = 0;

        for (Candidato c : candidatos.values()) {
            if ((c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3) && c.getCd_cargo() == nr_tipo_cand) {
                if (c.getCd_genero() == 2)
                    qtd_masculino++;
                else if (c.getCd_genero() == 4)
                    qtd_feminino++;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        porcentagem_masculino = ((double) qtd_masculino / (qtd_masculino + qtd_feminino)) * 100;
        porcentagem_feminino = ((double) qtd_feminino / (qtd_masculino + qtd_feminino)) * 100;
        porcentagem_masculino = Double.parseDouble(df.format(porcentagem_masculino).replace(",", ","));
        porcentagem_feminino = Double.parseDouble(df.format(porcentagem_feminino).replace(",", ","));

        System.out.println("Feminino: " + qtd_feminino + " (" + porcentagem_feminino + "%)");
        System.out.println("Masculino: " + qtd_masculino + " (" + porcentagem_masculino + "%)");
    }

    public static void geraRelatorio10(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {
        int total_votos_legenda = 0;
        int total_votos_nomimais = 0;
        int total_votos_validos = 0;
        double percentual_votos_legenda = 0;
        double percentual_votos_nomimais = 0;

        for (Partido p : partidos.values()) {
            total_votos_legenda += p.getVotosLegenda();
            for (Candidato c : p.getCandidatos().values()) {
                if (c.getCd_cargo() == nr_tipo_cand
                        && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16))
                    total_votos_nomimais += c.getQtd_votos();
            }
        }

        total_votos_validos = total_votos_legenda + total_votos_nomimais;
        percentual_votos_legenda = ((double) total_votos_legenda / total_votos_validos) * 100;
        percentual_votos_nomimais = ((double) total_votos_nomimais / total_votos_validos) * 100;

        DecimalFormat df = new DecimalFormat("0.00");
        percentual_votos_legenda = Double.parseDouble(df.format(percentual_votos_legenda).replace(",", ","));
        percentual_votos_nomimais = Double.parseDouble(df.format(percentual_votos_nomimais).replace(",", ","));

        System.out.println("\nTotal de votos válidos: " + total_votos_validos);
        System.out
                .println("Total de votos nominais: " + total_votos_nomimais + " (" + percentual_votos_nomimais + "%)");
        System.out
                .println("Total de votos de legenda: " + total_votos_legenda + " (" + percentual_votos_legenda + "%)");
    }
}
