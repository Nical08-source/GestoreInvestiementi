import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Programa di gestione investimenti
 *
 * @author Nicola Cappelli
 * @version Gennaio 2025
 */
public class Utente {
    private Path path = Paths.get("./GestoreInvestimenti/src/datiUtente.txt");
    private Path pat = Paths.get("./GestoreInvestimenti/src/bilancioUtente.txt");
    private String nome;
    private String cognome;
    private double bilancioSol;

    /**
     * carica i gli utenti da i file per averli nel avviamento del programma
     *
     */
    public void caricaUtente(){
        try {
            List<String> lines = Files.readAllLines(pat);
            List<String> dati = Files.readAllLines(path);
            this.bilancioSol = Double.parseDouble(lines.get(0));
            this.nome = dati.get(0);
            this.cognome = dati.get(1);
        } catch (IOException ex) {
            System.out.println("Errore nella lettura del file!");
        }
    }
    /**
     * Aggiunge un nuovo utente chiedendo tutti i dati.
     *
     */
    public void registraUtente() {
        List<String> lines = new ArrayList<>();
        List<String> line = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome: ");
        this.nome = sc.nextLine();
        lines.add(this.nome);
        System.out.println("Cognome: ");
        this.cognome = sc.nextLine();
        lines.add(this.cognome);
        try {
            Files.write(path, lines);
        } catch (IOException ex) {
            System.out.println("Errore scrittura!");
        }
        System.out.println("Bilancio: ");
        this.bilancioSol = sc.nextDouble();
        String bilancio = this.bilancioSol + "";
        line.add(bilancio);
        try {
            Path write = Files.write(pat, line);
        } catch (IOException ex) {
            System.out.println("Errore scrittura!");
        }
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public double getBilancioSol() {
        return bilancioSol;
    }
    /**
     * Aggiungie solana al bilancio dell utente e scrive in memoria
     *
     * @param add solana da aggiungere
     */
    public void addBilacio(double add) {
        this.bilancioSol += add;
        List<String> line = new ArrayList<>();
        line.add(add+"");
        try {
            Path write = Files.write(pat, line);
        } catch (IOException ex) {
            System.out.println("Errore scrittura!");
        }
    }
}
