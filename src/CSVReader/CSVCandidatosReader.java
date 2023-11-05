package CSVReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import SistemaEleitoral.Candidato;

public class CSVCandidatosReader {

    private static String diretorio_arq_cand = "src/CSVReader/";

    public static void candidatosReader(String arquivo_cand, String tipo_deputado)
            throws FileNotFoundException {
        try (FileInputStream file = new FileInputStream(diretorio_arq_cand + arquivo_cand)) {
            Scanner s = new Scanner(file, "ISO-8859-1");
            int n_vagas = 0;
            while (s.hasNextLine()) {
                String dados[] = s.nextLine().split(";");
                // Apenas candidatos deferidos
                for (int i = 0; i < dados.length; i++) {
                    dados[i] = dados[i].replace("\"", "");
                }

                if (dados[68].equals("2") || dados[68].equals("16")) {
                    // Para federal
                    if (tipo_deputado.equals("federal")) {
                        if (dados[13].equals("6")) {
                            // adiciona asterisco ao nome do candidato indicando possuir federacao
                            if (!(dados[30].equals("-1")))
                                dados[18] = "*" + dados[18];

                            if (dados[56].equals("2") || dados[56].equals("3"))
                                n_vagas++;

                        }
                    }
                    // Para estadual
                    else if (tipo_deputado.equals("estadual")) {
                        if (dados[13].equals("7")) {

                            // adiciona asterisco ao nome do candidato indicando possuir federacao
                            if (!(dados[30].equals("-1")))
                                dados[18] = "*" + dados[18];
                            // contabilizar vagas para deputador estadual
                            if (dados[56].equals("2") || dados[56].equals("3"))
                                n_vagas++;

                        }

                    }
                }
            }
            System.out.println("Numero de vagas: " + n_vagas);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado");
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo");
        }
    }
}
