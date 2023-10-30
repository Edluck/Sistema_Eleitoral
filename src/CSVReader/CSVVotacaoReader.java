package CSVReader;

import java.io.FileNotFoundException;

public class CSVVotacaoReader {
    public static void votacaoReader(String arquivo_vot) throws FileNotFoundException {
        try(java.util.Scanner scanner = new java.util.Scanner(new java.io.File(arquivo_vot))) {
            scanner.nextLine();
            System.out.println(scanner.nextLine());
        }
        catch(FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        }
        catch(Exception e) {
            System.out.println("Erro ao ler arquivo");
        }
    }
}
