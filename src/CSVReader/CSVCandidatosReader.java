package CSVReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

import SistemaEleitoral.Candidato;
import SistemaEleitoral.Partido;

public class CSVCandidatosReader {

    private static String diretorio_arq_cand = "";

    public static void candidatosReader(String tipo_deputado, String arquivo_cand, String data_eleicao,
            Map<Integer, Candidato> candidatos, Map<Integer, Partido> partidos)
            throws FileNotFoundException {

        try (FileInputStream file = new FileInputStream(diretorio_arq_cand + arquivo_cand)) {
            Scanner s = new Scanner(file, "ISO-8859-1");
            int nr_tipo_deputado = 0;
            if(tipo_deputado.equals("federal"))
                nr_tipo_deputado = 6;
            else if(tipo_deputado.equals("estadual"))
                nr_tipo_deputado = 7;
            s.nextLine();
            while (s.hasNextLine()) {
                String dados[] = s.nextLine().split(";");
                // Apenas candidatos deferidos
                for (int i = 0; i < dados.length; i++) {
                    dados[i] = dados[i].replace("\"", "");
                }

                // adiciona asterisco ao nome do candidato indicando possuir federacao
                if(partidos.get(Integer.parseInt(dados[27])) == null) {
                    Partido p = new Partido(dados[28], Integer.parseInt(dados[27]));
                    partidos.put(Integer.parseInt(dados[27]), p);
                }

                if (nr_tipo_deputado == Integer.parseInt(dados[13]) && dados[67].contains("Válido")) {

                    Candidato c = new Candidato(Integer.parseInt(dados[13]), Integer.parseInt(dados[68]),
                            Integer.parseInt(dados[16]), dados[18], Integer.parseInt(dados[27]), dados[28],
                            Integer.parseInt(dados[30]), dados[42],
                            Integer.parseInt(dados[56]), Integer.parseInt(dados[45]), dados[67]);
                    c.setIdade(data_eleicao);
                    candidatos.put(Integer.parseInt(dados[16]), c);
                    partidos.get(Integer.parseInt(dados[27])).addCandidato(c);
                    
                }
                
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