import java.io.File;
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
public class Program {
    public static void main(String[] args) throws IOException {
        Path pathBilancio = Paths.get("./GestoreInvestimenti/src/bilancioUtente.txt");
        Path path = Paths.get("./GestoreInvestimenti/src/prima.txt");
        Path fileOpA = Paths.get("./GestoreInvestimenti/src/operazioneAperte.txt");
        Path fileOpC = Paths.get("./GestoreInvestimenti/src/operazioniChiuse.txt");
        ArrayList<Operazione> storicoOperazioni = new ArrayList<>();
        ArrayList<OperazioneAperta> operazioniAperte = new ArrayList<>();
        double fee =0;
        String premere; //serve come selettore per andare avanti


        //Inizio caricamento operazioni
        boolean fileValido = true;
        boolean fileValido2 = true;
        try {
            List<String> lines = Files.readAllLines(fileOpA);
            List<String> lines2 = Files.readAllLines(fileOpC);

            if (lines2.isEmpty()){

                fileValido2 = false;
            }
            if (lines.isEmpty()) {

                fileValido = false;
            }
            if (fileValido2) {
                for (int i = 0; i < lines2.size(); i += 7) {
                    try {
                        String ca = lines.get(i);
                        String nome = lines.get(i + 1);
                        int mc = Integer.parseInt(lines.get(i + 2));
                        int supply = Integer.parseInt(lines.get(i + 3));
                        double solanaComprati = Integer.parseInt(lines.get(i + 4));
                        double guadagno = Integer.parseInt(lines.get(i+5));
                        int mcFinale = Integer.parseInt(lines2.get(i+6));
                        Operazione a = new Operazione(ca, nome, mc, supply, solanaComprati,guadagno,mcFinale);
                        storicoOperazioni.add(a);
                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("Errore ne aggiugere le operazioni");
                    }
                }
            }
            if (fileValido) {
                for (int i = 0; i < lines.size(); i += 5) {
                    try {
                        String ca = lines.get(i);
                        String nome = lines.get(i + 1);
                        int mc = Integer.parseInt(lines.get(i + 2));
                        int supply = Integer.parseInt(lines.get(i + 3));
                        double solanaComprati = Double.parseDouble(lines.get(i + 4));
                        OperazioneAperta a = new OperazioneAperta(ca, nome, mc, supply, solanaComprati);
                        operazioniAperte.add(a);
                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("Errore ne aggiugere le operazioni");
                    }
                }
            }
            } catch (IOException e) {
            System.out.println("Errore nella lettura del file: " + e.getMessage());
            return;
        }

        //Fine caricamento operazioni
        //Controllo utente e o creazione
        File myObj = new File("./GestoreInvestimenti/src/prima.txt");
        Utente u = new Utente();
        if (path.toFile().exists()) { //controlla se esistono gli utenti
            u.caricaUtente();
        }else {
            u.registraUtente();
            myObj.createNewFile();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("ciao "+u.getNome()+" sono memecalculator, come ti senti oggi?");
        int var= 0;
        int var1 = 0;
        while (var< 1) {
            var = 1;
            System.out.println("Bene(0),non saprei (1),male(2)");
            int sentimenti = sc.nextInt();
            if (sentimenti == 0) { // Variabile 1 investimenti
                while (var1 <1){
                    var1 = 1;
                    System.out.println("Sono molto contento che tu ti senta bene, pensi di avere ripsoato abbastanza oggi?");
                    System.out.println("ho dormito -6H (0), Ho dormito 7/9h (1), Ho dormito +12H (2)");
                    int dormito = sc.nextInt();
                    if (dormito == 0) {
                        System.out.println("Ti senti bene ma hai dormito poco, ti consiglio di non farti prendere dalla euforita e di rimanere lucido.");
                        System.out.println("Per oggi vacci piano gestisci bene il rischio e tai ancora piu attento del solito.");
                    } else if (dormito == 1) {
                        System.out.println("essendo che ti senti bene ed hai dormito abbastanza ti cosnglio di essere concentrato e e valutare le tue mosse.");
                        System.out.println("Per oggi se fai le giuste ricerche puoi rischiare un po sempre con ritegno");
                    } else if (dormito == 2) {
                        System.out.println("Oggi credo che sia la giornata giusta, lavora bene rimani concentrato e valuta le tue mosse.");
                        System.out.println("sei abbastanza lucido da scegliere con ritegno e cercare i progetti giusti");
                        System.out.println("ti consiglio di metterti deli obbiettivi e fare cio che ti dici.");
                    }
                    else{
                        System.out.println("operzione non valida");
                        var1 = 0;
                    }
                }
            } else if (sentimenti == 1) { //variabile 2 sentimenti
                while (var1 <1){
                    var1 = 1;
                    System.out.println("pensi di avere ripsoato abbastanza oggi?");
                    System.out.println("ho dormito -6H (0), Ho dormito 7/9h (1), Ho dormito +12H (2)");
                    int dormito = sc.nextInt();
                    if (dormito == 0) {
                        System.out.println("Ti senti discretamente ma hai dormito poco, Ti consiglio di essere cauto e paziente e di non esagerare");
                        System.out.println("Cerca di non prendere rischi inutili non lavorare per riguadagnare e si sicuro di cio che investi");
                    } else if (dormito == 1) {
                        System.out.println("Non ti senti da dio ma hai dormito abbatanza puoi lavorare ma si cauto non farti condizionare dale emozioni e stai concentrato");
                        System.out.println("Lavora su progetti pochi rischiosi e fai attenzione");
                    } else if (dormito == 2) {
                        System.out.println("Hai dormito bene e anche se il tuo umore non e il massimo puoi lavorare normalmente");
                        System.out.println("forse cio che ti serve oggi e avere dei bei traguardi e andare al massimo");
                    }else{
                        System.out.println("operzione non valida");
                        var1 = 0;
                    }
                }

            } else if (sentimenti == 2) { //variabile 3 per investimenti
                while (var1 <1){
                    var1 = 1;
                    System.out.println("mi dispiace che tu non stia bene, pensi di avere ripsoato abbastanza oggi?");
                    System.out.println("ho dormito -6H (0), Ho dormito 7/9h (1), Ho dormito +12H (2)");
                    int dormito = sc.nextInt();
                    if (dormito == 0) {
                        System.out.println("Non ti senti bene per oggi ti cosiglio di non stare fermo e studiare di più");
                    } else if (dormito == 1) {
                        System.out.println("Anche se hai dormito discretamente non ti senti bene rischi di farti prendere troppo dalle emozioni.");
                        System.out.println("Ti consiglio di lavorare bene e studiare non predere rischi inutile e lavora piano");
                    } else if (dormito == 2) {
                        System.out.println("Oggi cerca di andarci piano non ti senti bene anche se hai dormito, rischi di farti prendere dalle emozioni e prenderti rischi inutili");
                        System.out.println("lavora ma stai concentrato il doppio.");
                    }else{
                        System.out.println("operzione non valida");
                        var1 = 0;
                    }
                }

            }
            else{
                System.out.println("non hai dato una opzione valida riprova");
                var = 0;
            }
        }

        System.out.print("Il tuo bilancio attuale è di ");
        System.out.print(u.getBilancioSol());
        System.out.print(" Solana");
        System.out.println();
        System.out.println("");
        var= 0;
        while (var<1) {
            var = 1;
            System.out.println("inserire il prezzo delle fee in solana");
            fee = sc.nextDouble();
            if(fee<0){
                var = 0;
                System.out.println("le fee non possono essere minori di 0");
            }
        }


        while (true){
            System.out.println("con cosa vorresti iniziare oggi?");
            System.out.println("1. Registrare una nuova operazione");
            System.out.println("2. Chiudere una operazione");
            System.out.println("3. Calcolare una operazione ");
            System.out.println("4. Vadere le tue statistiche");
            System.out.println("5. Prelevare/Versare");
            System.out.println("6. Uscire");

            int option = sc.nextInt();
            if(option == 1){
                OperazioneAperta a = new OperazioneAperta(u.getBilancioSol());
                operazioniAperte.add(a);
                u.addBilacio(a.getSolanaComprati()+fee*-1);
                System.out.println("è stata registrata la operazione "+a);
                System.out.println("premere invio per andare avanti");
                premere = sc.nextLine();
            }


            else if(option == 2){
                System.out.println("Le tue operazioni aperte sono:");
                for (int i = 0; i < operazioniAperte.size(); i++) {
                    System.out.println(i +". "+ operazioniAperte.get(i));
                }
                System.out.println("");
                System.out.println("Scegli quale operazione vuoi chiudere o inserire -1 per uscire");
                int option2 = sc.nextInt();
                if(option2 == -1 || option2> operazioniAperte.size()){
                    continue;
                }
                OperazioneAperta a = operazioniAperte.get(option2);
                operazioniAperte.remove(a);
                System.out.println("La Mc iniziale è di " +a.getMc());
                var = 0;
                System.out.println("inserire la mc finale");
                int mcFinale = sc.nextInt();
                double profitto = mcFinale/a.getMc()*a.getSolanaComprati()-fee;
                Operazione op = new Operazione(a.getCa(),a.getNome(),a.getMc(),a.getSupply(),a.getSolanaComprati(),profitto,mcFinale);
                storicoOperazioni.add(op);
                u.addBilacio(profitto);
                System.out.println("il profitto per questa operazione è di "+profitto+"solana");
                System.out.println("il tuo nuovo bilancio è di "+u.getBilancioSol()+"solana");
                try {
                    Files.delete(Paths.get("./GestoreInvestimenti/src/operazioneAperte.txt"));
                    Files.createFile(Paths.get("./GestoreInvestimenti/src/operazioneAperte.txt"));
                } catch (Exception e) {
                    System.out.println("problema con i file");
                }

                for(int i=0;i<operazioniAperte.size();i++){
                    operazioniAperte.get(i).wr();
                }
            }
            else if(option == 3){
                System.out.println("Inserire i dati della operazione");
                System.out.println("Iniserire la mc iniziale");
                int mcI = sc.nextInt();
                System.out.println("Inserire mc finale");
                int mcF = sc.nextInt();
                System.out.println("inserire solana da comprare");
                double buy = sc.nextDouble();
                double profitto = mcF/mcI*buy-fee;
                double percentuale = profitto/buy;
                System.out.println("Con questa operazione avresti un profitto di " + profitto+" solana");
                System.out.println("realizzando un "+percentuale+"%");
                premere = sc.nextLine();
            }
            else if(option == 4){
                int opVincenti = 0;
                int opPerdenti = 0;
                int opTot = 0;
                int profitto = 0;
                for(int i=0;i<storicoOperazioni.size();i++){
                    if(storicoOperazioni.get(i).getGuadagno()>0){
                        opVincenti += 1;
                    } else if (storicoOperazioni.get(i).getGuadagno()<0) {
                        opPerdenti += 1;
                    }
                    profitto += storicoOperazioni.get(i).getGuadagno();
                    opTot +=1;
                }
                System.out.println("I tuoi risultati sono:");
                System.out.println("hai eseguito un totale di "+ opTot);
                System.out.println("con un winrate del "+(opVincenti/opTot*100)+"%");
                System.out.println("eseguendo "+opPerdenti+" operazioni vincenti");
                System.out.println("con un profitto di circa "+profitto+"solana");
                System.out.println("con un aumento rispetto hal deposito iniziale("+(u.getBilancioSol()-profitto)+"sol) del "+(profitto/(u.getBilancioSol()-profitto)*100)+"%");

            } else if (option == 5) {
                double prelevaVersa = 0;
                System.out.println("Il tuo bilancio attuale è di:"+u.getBilancioSol()+" solana");
                while (var<1) {
                    System.out.println("prelevare (0), versare(1)");
                    var = 1;
                    int selettore = sc.nextInt();
                    if (selettore == 0) {
                        System.out.println("Quanto vuoi prelevare?");
                        prelevaVersa = sc.nextDouble();
                        if (prelevaVersa > u.getBilancioSol()) {
                            System.out.println("Non puoi prelevare piu di quello che hai");
                            continue;
                        }
                        prelevaVersa = prelevaVersa * (-1);
                    } else if (selettore == 1) {
                        System.out.println("Quanto vuoi versare?");
                        prelevaVersa = sc.nextDouble();

                    } else {
                        System.out.println("dovevi inserire 0 o 1");
                        var = 0;
                    }
                }
                u.addBilacio(prelevaVersa);
                System.out.println("il tuo nuovo bilancio e di "+u.getBilancioSol()+" solana");
            } else if(option == 6){
                break;
            }
        }
    }
}

