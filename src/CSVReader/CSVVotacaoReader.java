package CSVReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import SistemaEleitoral.Candidato;
import SistemaEleitoral.Partido;

public class CSVVotacaoReader {
    private static String diretorio_arq_vot = "";

    public static void votacaoReader(String tipo_deputado, String arquivo_vot, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos)
            throws FileNotFoundException {

        try (FileInputStream file = new FileInputStream(diretorio_arq_vot + arquivo_vot)) {
            Scanner s = new Scanner(file, "ISO-8859-1");
            s.nextLine();
            
            int nr_tipo_deputado = 0;
            if (tipo_deputado.equals("estadual"))
                nr_tipo_deputado = 7;
            else if (tipo_deputado.equals("federal"))
                nr_tipo_deputado = 6;

            while (s.hasNextLine()) {
                String dados[] = s.nextLine().split(";");
                for (int i = 0; i < dados.length; i++) {
                    dados[i] = dados[i].replace("\"", "");
                }

                int nr_notavel = Integer.parseInt(dados[19]);
                int qt_votos = Integer.parseInt(dados[21]);


                if (nr_notavel < 95 || nr_notavel > 98) {
                    if (nr_tipo_deputado == Integer.parseInt(dados[17])) {
                        if (candidatos.get(nr_notavel) != null) {
                            if (candidatos.get(nr_notavel).getNm_tipo_destinacao_votos().contains("legenda")) {
                                int nr_partido = candidatos.get(nr_notavel).getNr_partido();
                                partidos.get(nr_partido).addVotosLegenda(qt_votos);

                            } else {

                                if (candidatos.get(nr_notavel).getCd_situacao_candidato_tot() == 2 || candidatos.get(nr_notavel).getCd_situacao_candidato_tot() == 16 ) {
                                    candidatos.get(nr_notavel).addVotos(qt_votos);   
                                }
                            }

                        } else if (partidos.get(nr_notavel) != null) {
                            partidos.get(nr_notavel).addVotosLegenda(qt_votos);
                        }
                    }

                }
            }

            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo");
        }
    }
}
