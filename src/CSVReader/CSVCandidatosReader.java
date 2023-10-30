package CSVReader;

import java.io.FileNotFoundException;

public class CSVCandidatosReader {
    public static void candidatosReader(String arquivo_cand) throws FileNotFoundException {
        try(java.util.Scanner scanner = new java.util.Scanner(new java.io.File(arquivo_cand))) {
            scanner.nextLine();
        }
        catch(FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        }
        catch(Exception e) {
            System.out.println("Erro ao ler arquivo");
        }
    }
}
