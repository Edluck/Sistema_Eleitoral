package SistemaEleitoral;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
        int i = 1;
  
        if (nr_tipo_cand == 6)
            System.out.println("Deputados federais eleitos: ");
        else if (nr_tipo_cand == 7)
            System.out.println("Deputados estaduais eleitos: ");

        List<Candidato> order = new ArrayList<Candidato>(candidatos.values());

        Comparator<Candidato> comparator = (c1, c2) -> {
            int res = 0;
            res = c2.getQtd_votos() - c1.getQtd_votos();
            if (res == 0) {
                res = c2.getIdade() - c1.getIdade();
            }
            return res;
        };
        order.sort(comparator);

        Iterator<Candidato> it = order.iterator();

        while (it.hasNext() == true) {
            Candidato c = it.next();
            String eh_fed = "";
            if (c.getNr_federacao() != -1) {
                eh_fed = "*";
            }
            if (c.getCd_cargo() == nr_tipo_cand &&
                    (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3) {
                    System.out.println(i + " - " + eh_fed + c);
                    i++;
                }
            }
        }
    }

    public static void geraRelatorio3(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {
        int nr_vagas = 0, i = 1;
        for (Candidato c : candidatos.values()) {
            if (c.getCd_cargo() == nr_tipo_cand
                    && (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)
                    nr_vagas++;
            }
        }
        System.out
                .println("\nCandidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):");
        List<Candidato> order = new ArrayList<Candidato>(candidatos.values());
        Comparator<Candidato> comparator = (c1, c2) -> {
            int res = 0;
            res = c2.getQtd_votos() - c1.getQtd_votos();
            if (res == 0) {
                res = c2.getIdade() - c1.getIdade();
            }
            return res;
        };
        order.sort(comparator);

        Iterator<Candidato> it = order.iterator();

        while (it.hasNext() == true && nr_vagas >= i) {
            Candidato c = it.next();
            String eh_fed = "";
            if (c.getNr_federacao() != -1) {
                eh_fed = "*";
            }
            if (c.getCd_cargo() == nr_tipo_cand &&
                    (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {

                System.out.println(i + " - " + eh_fed + c);
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
        System.out.println(
                "\nTeriam sido eleitos se a votação fosse majoritária, e não foram eleitos:\n(com sua posição no ranking de mais votados)");
        List<Candidato> order = new ArrayList<Candidato>(candidatos.values());
        Comparator<Candidato> comparator = (c1, c2) -> {
            int res = 0;
            res = c2.getQtd_votos() - c1.getQtd_votos();
            if (res == 0) {
                res = c2.getIdade() - c1.getIdade();
            }
            return res;
        };
        order.sort(comparator);

        Iterator<Candidato> it = order.iterator();

        while (it.hasNext() == true && nr_vagas >= i) {
            Candidato c = it.next();
            String eh_fed = "";
            if (c.getNr_federacao() != -1) {
                eh_fed = "*";
            }
            if (c.getCd_cargo() == nr_tipo_cand &&
                    (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if (!(c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3))
                    System.out.println(i + " - " + eh_fed + c);
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
        System.out.println(
                "\nEleitos, que se beneficiaram do sistema proporcional:\n(com sua posição no ranking de mais votados)");
        List<Candidato> order = new ArrayList<Candidato>(candidatos.values());
        Comparator<Candidato> comparator = (c1, c2) -> {
            int res = 0;
            res = c2.getQtd_votos() - c1.getQtd_votos();
            if (res == 0) {
                res = c2.getIdade() - c1.getIdade();
            }
            return res;
        };
        order.sort(comparator);

        Iterator<Candidato> it = order.iterator();

        while (it.hasNext() == true) {
            Candidato c = it.next();
            String eh_fed = "";
            if (c.getNr_federacao() != -1) {
                eh_fed = "*";
            }
            if (c.getCd_cargo() == nr_tipo_cand &&
                    (c.getCd_situacao_candidato_tot() == 2 || c.getCd_situacao_candidato_tot() == 16)) {
                if ((c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3) && i > nr_vagas)
                    System.out.println(i + " - " + eh_fed + c);
                i++;

            }
        }
    }

    public static void geraRelatorio6(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {

        System.out.println("\nVotação dos partidos e número de candidatos eleitos:");
        List<Partido> order = new ArrayList<Partido>(partidos.values());
        Comparator<Partido> comparator = (p1, p2) -> {
            int res = 0;
            res = p2.getVotosTotais() - p1.getVotosTotais();
            if (res == 0) {
                res = p1.getNr_partido() - p2.getNr_partido();
            }
            return res;
        };
        order.sort(comparator);
        int i = 1;
        Iterator<Partido> it = order.iterator();
        while (it.hasNext() == true) {
            Partido p = it.next();
            int qtd_eleitos_partido = 0;
            for (Candidato c : p.getCandidatos().values()) {
                if (c.getCd_cargo() == nr_tipo_cand && (c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)) {
                    qtd_eleitos_partido++;
                }
            }

            String plural_vtsNomTot = "l";
            if (p.getVotosNominaisTotal() > 1) {
                plural_vtsNomTot = "is";
            }

            String plural_eleito = "";
            if (qtd_eleitos_partido > 1) {
                plural_eleito = "s";
            }

            String plural_voto = " voto";
            if (p.getVotosTotais() > 1) {
                plural_voto = " votos";
            }
            DecimalFormat format2 = new DecimalFormat("#,###");
            DecimalFormatSymbols symbols2 = new DecimalFormatSymbols();
            symbols2.setGroupingSeparator('.');
            format2.setDecimalFormatSymbols(symbols2);

            System.out.println(i + " - " + p + " " + format2.format(p.getVotosTotais()) + plural_voto + " ("
                    + format2.format(p.getVotosNominaisTotal())
                    + " nomina"
                    + plural_vtsNomTot + " e " + format2.format(p.getVotosLegenda()) + " de legenda), "
                    + qtd_eleitos_partido
                    + " candidato" + plural_eleito + " eleito" + plural_eleito);

            i++;
        }
    }

    public static void geraRelatorio7(int nr_tipo_cand, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos) {
        System.out.println("\nPrimeiro e último colocados de cada partido:");

        Comparator<Candidato> comparator_c = (c1, c2) -> {
            int res_c = 0;
            

            if(c1.getNm_tipo_destinacao_votos().contains("legenda") && c2.getNm_tipo_destinacao_votos().contains("legenda")) {
                return 0;
            }
            else if(c1.getNm_tipo_destinacao_votos().contains("legenda")) {
                return 1;
            }
            else if(c2.getNm_tipo_destinacao_votos().contains("legenda")) {
                return -1;
            }

            res_c = c2.getQtd_votos() - c1.getQtd_votos();
            if (res_c == 0) {
                res_c = c2.getIdade() - c1.getIdade();
            }
            return res_c;
        };

        Comparator<Partido> comparator_p = (p1, p2) -> {
            int res_p = 0;
            if (p1.getCandidatos().size() == 0 && p2.getCandidatos().size() == 0) {
                return 0;
            } else if (p1.getCandidatos().size() == 0) {
                return 1;
            } else if (p2.getCandidatos().size() == 0) {
                return -1;
            }

            List<Candidato> lista_c1 = new ArrayList<Candidato>(p1.getCandidatos().values());
            List<Candidato> lista_c2 = new ArrayList<Candidato>(p2.getCandidatos().values());

            lista_c1.sort(comparator_c);
            lista_c2.sort(comparator_c);

            res_p = lista_c2.get(0).getQtd_votos() - lista_c1.get(0).getQtd_votos();

            if (res_p == 0) {
                res_p = p1.getNr_partido() - p2.getNr_partido();
            }

            return res_p;
        };

        List<Partido> order_p = new ArrayList<Partido>(partidos.values());

        order_p.sort(comparator_p);
        

        int i = 1;
        Iterator<Partido> it_p = order_p.iterator();
        while (it_p.hasNext() == true) {
            int ind_r = 1;

            Partido p = it_p.next();
            if (p.getCandidatos().size() == 0) {
                continue;
            }

            

            List<Candidato> order_c = new ArrayList<Candidato>(p.getCandidatos().values());

            order_c.sort(comparator_c);

            Candidato c_melhor = order_c.get(0);

            if (c_melhor.getQtd_votos() < 0) {
                continue;
            }

            Candidato c_pior = order_c.get(p.getCandidatos().size() - ind_r);
            while(c_pior.getNm_tipo_destinacao_votos().contains("legenda")) {
                ind_r++;
                c_pior = order_c.get(p.getCandidatos().size() - ind_r);
            }
            DecimalFormat format2 = new DecimalFormat("#,###");
            DecimalFormatSymbols symbols2 = new DecimalFormatSymbols();
            symbols2.setGroupingSeparator('.');
            format2.setDecimalFormatSymbols(symbols2);

            String plural_voto = " voto";
            if (c_pior.getQtd_votos() > 1) {
                plural_voto = " votos";
            }

            System.out.println(i + " - " + p + " " + c_melhor.getNm_urna_candidato() + " (" + c_melhor.getNr_candidato()
                    + ", " + format2.format(c_melhor.getQtd_votos()) + " votos"
                    + ")" + " / " + c_pior.getNm_urna_candidato() + "" + " (" + c_pior.getNr_candidato() + ", "
                    + format2.format(c_pior.getQtd_votos()) + plural_voto + ")");
            i++;
        }

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
        System.out.println("\nEleitos, por faixa etária (na data da eleição):");
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
        DecimalFormat format = new DecimalFormat("#,##0.00");
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
            total_votos_nomimais += p.getVotosNominaisTotal();
        }

        total_votos_validos = total_votos_legenda + total_votos_nomimais;
        percentual_votos_legenda = ((double) total_votos_legenda / total_votos_validos) * 100;
        percentual_votos_nomimais = ((double) total_votos_nomimais / total_votos_validos) * 100;

        DecimalFormat format = new DecimalFormat("#,##0.00");
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
