package empresa;

import java.io.*;
import java.util.ArrayList;

public class Cofrinho {

    private final ArrayList<Moeda> carteira = new ArrayList<>();

    public void adicionar(Moeda moeda) {
        carteira.add(moeda);
        System.out.println("Depósito realizado.");
    }

        public boolean remover(Moeda moeda) {
        return carteira.remove(moeda);
    }

        public void carteira() {
        if (carteira.isEmpty()) {
            System.out.println("Cofrinho vazio!");
            return;
        }
        for (Moeda m : carteira) {
            System.out.printf("%s: %.2f%n", m.tipo(), m.getValor());
        }
    }

        // METODO CONVERTER
        public double convr() {
        double total = 0;
        for (Moeda m : carteira) total += m.converter();
        return total;
    }
 
        // METODO REMOVER
        public boolean rmTV(String tipo, double valor) {
        final double EPS = 1e-6;
        for (int i = 0; i < carteira.size(); i++) {
            Moeda m = carteira.get(i);
            if (m.tipo().equalsIgnoreCase(tipo) &&
                Math.abs(m.getValor() - valor) < EPS) {
                carteira.remove(i);
                System.out.printf("Removida: %s %.2f%n", tipo, valor);
                return true;
            }
        }
        return false;
    }
    
        // METODO DE SALVAMENTO DE MOEDAS
        public void salvarTxt() {
        try (FileWriter fw = new FileWriter("moedas.txt")) {
            for (Moeda m : carteira) {
                fw.write(m.tipo() + ";" + m.getValor() + System.lineSeparator());
            }
            System.out.println("Moedas salvas!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo.");
        }
    }

        // METODO DE VISUALIZAÇÃO DO ARQUIVO moedas.txt
        public void vrTxt() {
        try (BufferedReader br = new BufferedReader(new FileReader("moedas.txt"))) {

            System.out.println("\n--- MOEDAS REGISTRADAS ---");

            String linha;
            boolean vazio = true;

            while ((linha = br.readLine()) != null) {

                if (linha.isBlank()) continue;

                String[] partes = linha.split(";");

                if (partes.length != 2) {
                    System.out.println("Linha inválida: " + linha);
                    continue;
                }

                String tipo = partes[0];
                double valor = Double.parseDouble(partes[1]);

                System.out.printf("%s: %.2f%n", tipo, valor);
                vazio = false;
            }

            if (vazio) System.out.println("Arquivo vazio.");

          // CAPTURAS PARA ERROS NO ARQUIVO TXT
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo.");
        } catch (NumberFormatException e) {
            System.out.println("Erro de valor no arquivo.");
        }
    }
}
