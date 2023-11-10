package SistemaEleitoral;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
                int nr_vagas = 0;
        for (Candidato c : candidatos.values()) {
            if (c.getCd_cargo() == nr_tipo_cand
                    && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)
                    nr_vagas++;
            }
        }
        System.out.println("Número de vagas: " + nr_vagas + "\n");
    }

    public static void geraRelatorio2(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {
        int nr_vagas = 0, i = 1;
        for (Candidato c : candidatos.values()) {
            if (c.getCd_cargo() == nr_tipo_cand
                    && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)
                    nr_vagas++;
            }
        }
        if (nr_tipo_cand == 6)
            System.out.println("Deputados federais eleitos: ");
        else if (nr_tipo_cand == 7)
            System.out.println("Deputados estaduais eleitos: ");

        List<Candidato> order = new ArrayList<Candidato>(candidatos.values());
        Comparator<Candidato> comparator = (c1, c2) -> c2.getQtd_votos() - c1.getQtd_votos();
        order.sort(comparator);

        Iterator<Candidato> it = order.iterator();

        while (it.hasNext() == true) {
            Candidato c = it.next();
            if (c.getCd_cargo() == nr_tipo_cand &&
                    (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3) {
                    System.out.println(i + " - " + c);
                    i++;
                }
            }
        }
    }

    public static void geraRelatorio3(int nr_tipo_cand, Map<Integer, Candidato> candidatos,Map<Integer, Partido> partidos) {
        int nr_vagas = 0, i = 1;
        for (Candidato c : candidatos.values()) {
            if (c.getCd_cargo() == nr_tipo_cand
                    && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)
                    nr_vagas++;
            }
        }
        System.out.println("\nCandidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):");
        List<Candidato> order = new ArrayList<Candidato>(candidatos.values());
        Comparator<Candidato> comparator = (c1, c2) -> c2.getQtd_votos() - c1.getQtd_votos();
        order.sort(comparator);

        Iterator<Candidato> it = order.iterator();

        while (it.hasNext() == true && nr_vagas >= i) {
            Candidato c = it.next();
            if (c.getCd_cargo() == nr_tipo_cand && 
            (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) 
            {

                System.out.println(i + " - " + c);
                i++;

            }
        }

    }

    public static void geraRelatorio4(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {
               int nr_vagas = 0, i = 1;
        for (Candidato c : candidatos.values()) {
            if (c.getCd_cargo() == nr_tipo_cand
                    && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)
                    nr_vagas++;
            }
        }
        System.out.println("\nTeriam sido eleitos se a votação fosse majoritária, e não foram eleitos:\n(com sua posição no ranking de mais votados)");
        List<Candidato> order = new ArrayList<Candidato>(candidatos.values());
        Comparator<Candidato> comparator = (c1, c2) -> c2.getQtd_votos() - c1.getQtd_votos();
        order.sort(comparator);

        Iterator<Candidato> it = order.iterator();

        while (it.hasNext() == true && nr_vagas >= i) {
            Candidato c = it.next();
            if (c.getCd_cargo() == nr_tipo_cand && 
            (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) 
            {
                if(!(c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3))
                System.out.println(i + " - " + c);
                i++;

            }
        } 
    }

    public static void geraRelatorio5(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {

                int nr_vagas = 0, i = 1;
        for (Candidato c : candidatos.values()) {
            if (c.getCd_cargo() == nr_tipo_cand
                    && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)
                    nr_vagas++;
            }
        }
        System.out.println("\nEleitos, que se beneficiaram do sistema proporcional:\n(com sua posição no ranking de mais votados)");
        List<Candidato> order = new ArrayList<Candidato>(candidatos.values());
        Comparator<Candidato> comparator = (c1, c2) -> c2.getQtd_votos() - c1.getQtd_votos();
        order.sort(comparator);

        Iterator<Candidato> it = order.iterator();

        while (it.hasNext() == true) {
            Candidato c = it.next();
            if (c.getCd_cargo() == nr_tipo_cand && 
            (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) 
            {
                if((c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3) && i > nr_vagas)
                System.out.println(i + " - " + c);
                i++;

            }
        } 
    }

    public static void geraRelatorio6(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {
                
            System.out.println("\nVotação dos partidos e número de candidatos eleitos:");
                // 12 - PSC - 20, 73.749 votos (71.098 nominais e 2.651 de legenda), 1 candidato eleito
        List<Partido> order = new ArrayList<Partido>(partidos.values());
        Comparator<Partido> comparator = (p1, p2) -> p2.getVotosTotais() - p1.getVotosTotais();
        order.sort(comparator);
        int i = 1;
        Iterator<Partido> it = order.iterator();
        while (it.hasNext() == true) {
            Partido p = it.next();
            int qtd_eleitos_partido = 0;
            for(Candidato c : p.getCandidatos().values()) {
                if(c.getCd_cargo() == nr_tipo_cand && (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)) {
                    qtd_eleitos_partido++;
                }
                
            }
            System.out.println(i + " - " + p + " " + p.getVotosTotais() + " (" + p.getVotosNominaisTotal() + " nominais e " + p.getVotosLegenda() + " de legenda), " + qtd_eleitos_partido + " candidatos eleitos");

            i++;
        } 
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
        DecimalFormat format = new DecimalFormat("#,##0.00");
        DecimalFormat format2 = new DecimalFormat("#,###");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        DecimalFormatSymbols symbols2 = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols2.setGroupingSeparator('.');
        format2.setDecimalFormatSymbols(symbols2);
        format.setDecimalFormatSymbols(symbols);

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

        System.out.println("      Idade < 30: " + idade_menor_30 + " (" + format.format(porcentagem_menor_30) + "%)");
        System.out.println("30 <= Idade < 40: " + idade_30_40 + " (" + format.format(porcentagem_30_40) + "%)");
        System.out.println("40 <= Idade < 50: " + idade_40_50 + " (" + format.format(porcentagem_40_50) + "%)");
        System.out.println("50 <= Idade < 60: " + idade_50_60 + " (" + format.format(porcentagem_50_60) + "%)");
        System.out.println("60 <= Idade     : " + idade_maior_60 + " (" + format.format(porcentagem_maior_60) + "%)");
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
        DecimalFormat format = new DecimalFormat("#,###.00");
        DecimalFormat format2 = new DecimalFormat("#,###");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        DecimalFormatSymbols symbols2 = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols2.setGroupingSeparator('.');
        format2.setDecimalFormatSymbols(symbols2);
        format.setDecimalFormatSymbols(symbols);

        porcentagem_masculino = ((double) qtd_masculino / (qtd_masculino + qtd_feminino)) * 100;
        porcentagem_feminino = ((double) qtd_feminino / (qtd_masculino + qtd_feminino)) * 100;

        System.out.println(
                "Feminino:  " + format2.format(qtd_feminino) + " (" + format.format(porcentagem_feminino) + "%)");
        System.out.println(
                "Masculino: " + format2.format(qtd_masculino) + " (" + format.format(porcentagem_masculino) + "%)");
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

        DecimalFormat format = new DecimalFormat("#,###.00");
        DecimalFormat format2 = new DecimalFormat("#,###");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        DecimalFormatSymbols symbols2 = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols2.setGroupingSeparator('.');
        format2.setDecimalFormatSymbols(symbols2);
        format.setDecimalFormatSymbols(symbols);

        System.out.println("\nTotal de votos válidos:    " + format2.format(total_votos_validos));
        System.out.println("Total de votos nominais:   " + format2.format(total_votos_nomimais) + " ("
                + format.format(percentual_votos_nomimais) + "%)");
        System.out.println("Total de votos de legenda: " + format2.format(total_votos_legenda) + " ("
                + format.format(percentual_votos_legenda) + "%)");
    }
}
