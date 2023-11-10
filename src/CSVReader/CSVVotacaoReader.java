package CSVReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVVotacaoReader {
    private static String diretorio_arq_vot = "src/CSVReader/";
    public static void votacaoReader(String arquivo_vot) throws FileNotFoundException {
        try(FileInputStream file = new FileInputStream(diretorio_arq_vot + arquivo_vot)) {
            Scanner s = new Scanner(file, "ISO-8859-1");
            while(s.hasNextLine()) {
                String dados[] = s.nextLine().split(";");
                for (int i = 0; i < dados.length; i++) {
                    dados[i] = dados[i].replace("\"", "");
                }
                
            }
            s.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        }
        catch(Exception e) {
            System.out.println("Erro ao ler arquivo");
        }
    }
}
