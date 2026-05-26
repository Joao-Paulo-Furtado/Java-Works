package empresa;

import java.util.Scanner;

// Aluno: João Paulo da Silva Furtado
// R.U: 5561870
// Disciplina: Programação orientada a objetos

public class principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();
        int op;

        do {
            System.out.println("\n     MEU COFRINHO    ");
            System.out.println("----------------------");
            System.out.println("1 - Depositar"); // ADICIONA MOEDAS NO ARRAY 
            System.out.println("2 - Retirar"); // RETIRA MOEDAS DO ARRAY
            System.out.println("3 - Listar Moedas"); // VISUALIZA AS STRINGS ADICIONADAS NO ARRAY
            System.out.println("4 - Total em Reais"); // CONVERTE O TOTAL DE TIPOS EM REAL
            System.out.println("5 - Guardar moedas"); // OPÇÃO PARA SALVAR "MOEDAS" EM ARQUIVO moedas.txt
            System.out.println("6 - Visualizar moedas guardadas"); // OPÇÃO PARA VISUALIZAR MOEDAS SALVAS NO ARQUIVO
            System.out.println("0 - Sair"); // ENCERRAR PROGRAMA
            System.out.print("Selecione uma das opções acima: "); // ENTRADA MENU

            while (!sc.hasNextInt()) sc.next();
            op = sc.nextInt();

            switch (op) {

                case 1 -> { // DEPOSITAR
                    Moeda m = cMoeda(sc);
                    if (m == null)
                        System.out.println("Tipo de moeda inválido!"); // ENTRADA STRING INVALIDA
                    else
                        cofrinho.adicionar(m);
                }

                case 2 -> { // RETIRAR
                    String tipoStr = lerTipStr(sc);
                    if (tipoStr == null) {
                        System.out.println("Tipo inválido!"); // ENTRADA DE STRING >6 E >0
                        break;
                    }
                    System.out.print("Valor: "); // SAIDA VALOR 
                    double v = lerDouble(sc);
                    if (cofrinho.rmTV(tipoStr, v))
                        System.out.println("Saque realizado!"); // ACERTO TIPO 
                    else
                        System.out.println("Moeda não encontrada."); // ERRO TIPO
                }

                case 3 -> cofrinho.carteira(); // LISTAR
                case 4 -> System.out.printf("Total: R$ %.2f%n", cofrinho.convr()); // EXIBIR TOTAL
                case 5 -> cofrinho.salvarTxt(); // SALVAR TXT
                case 6 -> cofrinho.vrTxt(); // EXIBIR TXT
                case 0 -> System.out.println("Encerrando..."); // SAIR

                default -> System.out.println("Opção inválida!");  // ERRO MENU
            }

        } while (op != 0);

        sc.close();
    }

        // METODO CRIAR MOEDA
        public static Moeda cMoeda(Scanner sc) { 
        System.out.print("Tipo (1-Real 2-Dólar 3-Euro 4-Rupia Indiana): ");
        while (!sc.hasNextInt()) sc.next();
        int tipo = sc.nextInt();

        if (tipo < 1 || tipo > 4) return null;

        System.out.print("Valor: ");
        double v = lerDouble(sc);

        return switch (tipo) {
            case 1 -> new Real(v);
            case 2 -> new Dolar(v);
            case 3 -> new Euro(v);
            case 4 -> new Rupia(v);
            default -> null;
        };
    }

        // METODO PARA LER TIPO COMO STRING
        private static String lerTipStr(Scanner sc) {
        System.out.print("Tipo (1-Real 2-Dólar 3-Euro 4-Rupia Indiana): ");
        while (!sc.hasNextInt()) sc.next();
        int tipo = sc.nextInt();

        return switch (tipo) {
            case 1 -> "Real";
            case 2 -> "Dólar";
            case 3 -> "Euro";
            case 4 -> "Rupia Indiana";
            default -> null;
        };
    }

        // REFORÇO DE LEITURA DE VALOR
        private static double lerDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Valor inválido! Digite novamente: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}

