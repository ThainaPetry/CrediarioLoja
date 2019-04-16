import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n");

        // Declaro uma variavel(opcao), onde após entrar no while e escolher qual das
        // opções escolhidas, quardará a opçao na variavel e
        // caso a opção for 2 ele sairá do programa.
        int opcao = 0;

        while (opcao != 2) {
            System.out.println("Registrar uma compra 1");
            System.out.println("Para sair 2");
            opcao = ler.nextInt();

            /*Declarando as váriaveis*/
            int parcelas = 0;
            double val_parc;

            // Entrará no "IF" (estrutura decisão) quando a opção for igual a 1,
            // assim mostrando os textos na tela e logo em seguida salvando
            // o dado digitados pelo usuario que o programa vai ler para uma em uma váriavel
            // e ao mesmo tempo declarando ela e seu tipo.
            // Na parte ler.nextLine leio a próxima linha
            if (opcao == 1) {
                System.out.println("Qual o valor da compra?");
                float total = ler.nextFloat();
                ler.nextLine();
                System.out.println("Qual a data da compra?");
                String data = ler.nextLine();
                System.out.println("Qual o tipo do pagamento(1-Dinheiro e 2-Crediario)?");
                short tipo = ler.nextShort();
                ler.nextLine();


                /*Declarando váriavel */
                float recebido = 0;

                // Estrutura de decisão: Se o pagamento ser em dinheiro(1), apresenta a pergunta de "Qual o valor recebido?".
                // Caso a forma de pagamento for crediário(2), apresenta a pergunta "Em quantas parcelas será dividida a compra?"
                // Se a quantidade de parcela for maior que 10 apresenta a mensagem "Quantidade de parcelas inadequadas".
                // E ainda se a opcao for diferente de 1 e 2 é apresentada a mensagem ("Opção não existente").
                if (tipo == 1) {
                    System.out.println("Quanto o valor recebido?");
                    recebido = ler.nextFloat();
                } else if (tipo == 2) {
                    System.out.println("Em quantas parcelas será dividida a compra (sendo no máximo 10)?");
                    parcelas = ler.nextInt();
                    System.out.println(" ");
                    if (parcelas > 10) {
                        System.out.println("Quantidade de parcelas inadequadas");
                        System.out.println("\n");
                    }
                } else {
                    System.out.println("Opção não existente");
                    System.out.println(" ");
                }


                /* Usando uma classe String para resolver o seguinte problema:
                Quando colocamos em Data, ele pega Ano/mês/dia, aqui estou quebrando
                em cada "/", transformando em inteiro e colocando na ordem data/mês/ano*/
                String num[] = data.split("/");
                int dia = 0, mes = 0, ano = 0;
                dia = Integer.parseInt(num[0]);
                mes = Integer.parseInt(num[1]);
                ano = Integer.parseInt(num[2]);

                /*Crio um objeto do tipo roupas e em seguida*/
                /*Caso o valor recebido para pagar a conta for menor que a conta a pagar, mostra uma mensagem em tela e volta ao menu inicial*/
                /*Se pagamento for dinheiro(1), faz o calculo e assim mostra o troco, declara ele e aparece "Conta paga".*/
                Compras roupas = new Compras(total, new Date(ano, mes, dia), tipo, recebido, parcelas);
                if (roupas.form_pagamento == 1) {
                    if (roupas.valor_rec < roupas.valor) {
                        System.out.println("Valor insuficiente para pagar a conta");
                    } else {
                        float troco = roupas.valor_rec - roupas.valor;
                        System.out.println("O troco a devolver é: " + troco);
                        System.out.println("Conta paga");
                        System.out.println("\n");
                    }
                }
                /*Se forma de pagamento for igual a crédito(2) e a quantidade de parcelas for menor e igual a 10,
                * entra no if e calcula o valor das parcelas atribuindo-o à variavel val_parc.
                * Em seguida apresenta em tela o valor das parcelas com arredondamento para duas casas decimais.*/
                if (roupas.form_pagamento == 2 && parcelas <= 10) {
                    val_parc = roupas.valor / parcelas;
                    System.out.printf("Valor das parcelas serão de: R$ %.2f", val_parc);
                    System.out.println("\n");

                    /*Aqui eu atribuo a quantidade de parcelas para o tamanho do vetor (tam_vet), em seguida declarando
                    * o novo vetor que é do tipo double com nome de vet_parcelas e mostro o tamanho que será este vetor
                    * em seguida declaro a variavel i que vai servir no for, no for mostro em tela o vetor. */
                    int tam_vet = parcelas;
                    double[] vet_parcelas = new double[tam_vet];
                    int i;

                    for (i = 0; i < tam_vet; i++) {
                        vet_parcelas[i] = val_parc;
                    }
                    for (double s: vet_parcelas) {
                        System.out.print(String.format("[R$ %.2f]",s));

                    }
                    System.out.println("\n");




                }
            }
        }


    }

}



