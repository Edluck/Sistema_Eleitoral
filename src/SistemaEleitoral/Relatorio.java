package SistemaEleitoral;

import java.util.Map;

public class Relatorio {
    private String tipo_deputado;

    public static void relatorio1(Map<Integer, Candidato> candidatos) {
        for(Candidato c : candidatos.values()) {
            if(c.getCd_sit_tot_turno() == 2 || c.getCd_sit_tot_turno() == 3)
            System.out.println(c);
        }
    }
}
