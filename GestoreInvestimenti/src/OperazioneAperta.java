import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Programa di gestione investimenti
 *
 * @author Nicola Cappelli
 * @version Gennaio 2025
 */
public class OperazioneAperta {
    private String ca;
    private String nome;
    private int mc;
    private int supply;
    private double solanaComprati;
    private Path path = Paths.get("./GestoreInvestimenti/src/operazioneAperte.txt");;

    public OperazioneAperta(String ca, String nome, int mciniziale,int supply, double solanaComprati) {
        this.ca = ca;
        this.nome = nome;
        this.mc = mciniziale;
        this.supply = supply;
        this.solanaComprati = solanaComprati;
        List<String> lines = new ArrayList<>();
        lines.add(this.ca);
        lines.add(this.nome);
        lines.add(this.mc+"");
        lines.add(this.supply+"");
        lines.add(this.solanaComprati+"");
        try {
            //standard option trovato online
            Files.write(path, lines, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            System.out.println("Errore scrittura!");
        }

    }
    public OperazioneAperta(double i) {
        List<String> line = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il nome del token: ");
        this.nome = sc.nextLine();
        System.out.println("Inserisci il ca del token: ");
        this.ca = sc.nextLine();
        System.out.println("Inserisci il supply del token: ");
        this.supply = sc.nextInt();
        System.out.println("inserisci la mc iniziale del token: ");
        this.mc = sc.nextInt();
        int a = 0;
        while (a <1) {
            a = 1;
            System.out.println("Inserisci il solana comprati: ");
            this.solanaComprati = sc.nextDouble();

            if (this.solanaComprati < i) {
                line.add(this.ca);
                line.add(this.nome);
                line.add(this.mc + "");
                line.add(this.supply + "");

                line.add(this.solanaComprati + "");
                try {
                    //standard option trovato online
                    Files.write(path, line, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                } catch (IOException ex) {
                    System.out.println("Errore scrittura!");

                }
            } else {
                System.out.println("non puopi comprare piu solana di quelli che hai");
                a = 0;
            }
        }
    }
    /**
     * Scrive la operazione dal programma al file nella memoria
     */
    public void wr(){
        List<String> line = new ArrayList<>();
        line.add(this.ca);
        line.add(this.nome);
        line.add(this.mc+"");
        line.add(this.supply+"");

        line.add(this.solanaComprati+"");
        try {
            //standard option trovato online
            Files.write(path, line, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            System.out.println("Errore scrittura!");

        }

    }

    public double getSolanaComprati(){
        return this.solanaComprati;
    }

    public String getCa() {
        return ca;
    }

    public String getNome() {
        return nome;
    }

    public int getMc() {
        return mc;
    }

    public int getSupply() {
        return supply;
    }

    @Override
    public String toString() {
        return "nome :" + nome + ", ca "+ca+", supply: "+supply+" sei esposto con "+ solanaComprati+" solana";
    }
}
