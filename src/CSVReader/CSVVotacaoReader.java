package CSVReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import SistemaEleitoral.Candidato;
import SistemaEleitoral.Partido;

public class CSVVotacaoReader {
    private static String diretorio_arq_vot = "src/CSVReader/";

    public static void votacaoReader(String arquivo_vot, Map<Integer, Candidato> candidatos,
            Map<Integer, Partido> partidos)
            throws FileNotFoundException {

        try (FileInputStream file = new FileInputStream(diretorio_arq_vot + arquivo_vot)) {
            Scanner s = new Scanner(file, "ISO-8859-1");
            s.nextLine();
            while (s.hasNextLine()) {
                String dados[] = s.nextLine().split(";");
                for (int i = 0; i < dados.length; i++) {
                    dados[i] = dados[i].replace("\"", "");
                }

                int nr_notavel = Integer.parseInt(dados[19]);
                int qt_votos = Integer.parseInt(dados[21]);
                if (nr_notavel < 95 || nr_notavel > 98) {
                    if (candidatos.containsKey(nr_notavel)) {
                        if (candidatos.get(nr_notavel).getNm_tipo_destinacao_votos().contains("legenda")) {
                            int nr_partido = candidatos.get(nr_notavel).getNr_partido();
                            partidos.get(nr_partido).addVotosLegenda(qt_votos);

                        } else {
                            candidatos.get(nr_notavel).addVotos(qt_votos);
                        }
                    } else if (partidos.containsKey(nr_notavel)) {
                        partidos.get(nr_notavel).addVotosLegenda(qt_votos);
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
