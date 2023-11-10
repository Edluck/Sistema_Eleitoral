package CSVReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

import SistemaEleitoral.Candidato;

public class CSVCandidatosReader {

    private static String diretorio_arq_cand = "src/CSVReader/";

    public static void candidatosReader(String arquivo_cand, String data_eleicao,
            Map<Integer, Candidato> candidatos)
            throws FileNotFoundException {

        try (FileInputStream file = new FileInputStream(diretorio_arq_cand + arquivo_cand)) {
            Scanner s = new Scanner(file, "ISO-8859-1");
            s.nextLine();
            while (s.hasNextLine()) {
                String dados[] = s.nextLine().split(";");
                // Apenas candidatos deferidos
                for (int i = 0; i < dados.length; i++) {
                    dados[i] = dados[i].replace("\"", "");
                }
                    // adiciona asterisco ao nome do candidato indicando possuir federacao
                    if (!(dados[30].equals("-1")))
                        dados[18] = "*" + dados[18];

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                    LocalDate dt1 = LocalDate.parse(dados[42], formatter);
                    LocalDate dt_eleicao = LocalDate.parse(data_eleicao, formatter);
                    Candidato c = new Candidato(Integer.parseInt(dados[13]), Integer.parseInt(dados[68]),
                            Integer.parseInt(dados[16]), dados[18], Integer.parseInt(dados[27]), dados[28],
                            Integer.parseInt(dados[30]), dt1,
                            Integer.parseInt(dados[56]), Integer.parseInt(dados[45]), dados[67]);
                    c.setIdade(dt_eleicao);
                    candidatos.put(Integer.parseInt(dados[16]), c);
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado");
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo");
            e.printStackTrace();
        }
    }
}