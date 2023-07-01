import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Olá! Este é o calculador de salários da parceria Santander Coders/ADA. Vamos calcular os salários dos nossos 5 funcionários.");

        Scanner scanner = new Scanner(System.in);

        double[] salarioBruto = new double[5];
        double[] descontosINSS = new double[5];
        double[] descontosIR = new double[5];
        double[] salarioLiquido = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o salário bruto do funcionário " + (i + 1) + " [sem 'R$' e usando ponto para separar as casas decimais]: ");
            salarioBruto[i] = scanner.nextDouble();

            //Desconto do INSS
            if (salarioBruto[i] <= 1212.00) {
                descontosINSS[i] = salarioBruto[i] * 0.075;
            } else if (salarioBruto[i] <= 2427.35) {
                descontosINSS[i] = salarioBruto[i] * 0.09;
            } else if (salarioBruto[i] <= 3641.03) {
                descontosINSS[i] = salarioBruto[i] * 0.12;
            } else if (salarioBruto[i] <= 7087.22) {
                descontosINSS[i] = salarioBruto[i] * 0.14;
            } else {
                descontosINSS[i] = 7087.22 * 0.14;
            }

            // Desconto IR
            if (salarioBruto[i] <= 1903.98) {
                descontosIR[i] = 0;
            } else if (salarioBruto[i] <= 2826.65) {
                descontosIR[i] = salarioBruto[i] * 0.075;
            } else if (salarioBruto[i] <= 3751.05) {
                descontosIR[i] = salarioBruto[i] * 0.15;
            } else if (salarioBruto[i] <= 4664.68) {
                descontosIR[i] = salarioBruto[i] * 0.225;
            } else {
                descontosIR[i] = salarioBruto[i] * 0.275;
            }

            // Salário líquido = Salário brutno - decontos INSS - descontos IR
            salarioLiquido[i] = salarioBruto[i] - descontosINSS[i] - descontosIR[i];

            System.out.println();
        }

        System.out.println("Cálculo Salarial");
        for (int i = 0; i < 5; i++) {
            System.out.println("Funcionário " + (i + 1));
            PrintStream printf = System.out.printf("Salário bruto: R$ %.2f " , salarioBruto[i]);
            printf = System.out.printf("\nDesconto INSS: R$ %.2f ", descontosINSS[i]);
            printf = System.out.printf("\nDesconto Imposto de Renda: R$ %.2f" , descontosIR[i]);
            printf = System.out.printf("\nSalário líquido: R$ %.2f" , salarioLiquido[i]);
            System.out.println();
            System.out.println();
        }

        scanner.close();
        System.out.println("Agradecemos o uso de nosso programa. :) \nDúvidas, críticas ou sugestões: ligiax[at]akademia.digital");
    }
}



