import java.util.*;

class Funcionario {
    String nome;
    int matricula;
    double salarioBase = 2000;
    
    public double calcularSalario() {
        return salarioBase;
    }
}

class Comissionado extends Funcionario {
    double vendas;
    double percentual;
    
    @Override
    public double calcularSalario() {
        return (salarioBase) + (vendas * percentual / 100);
    }
}

class Producao extends Funcionario {
    int quantidade;
    double valorPorPeca;
    
    @Override
    public double calcularSalario() {
        return (salarioBase) + (quantidade * valorPorPeca);
    }
}

public class A3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Funcionario> lista = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n1 - Padrão");
            System.out.println("2 - Comissionado");
            System.out.println("3 - Produção");
            System.out.println("4 - Folha de pagamento");
            System.out.println("0 - Sair");
           
            opcao = sc.nextInt();
            if (opcao < 0 || opcao > 4) {
                System.out.println("Opção inválida. Digite um número entre 0 e 4.");
            }


            switch (opcao) {

                case 1:
                    Funcionario f1 = new Funcionario();
                    System.out.print("Nome: ");
                    sc.nextLine();
                    f1.nome = sc.nextLine();
                    System.out.print("Matrícula: ");
                    f1.matricula = sc.nextInt();
                    if (f1.matricula <= 0) {
                        System.out.println("Valor de matrícula inválido. Digite um valor positivo.");
                        System.out.print("Matrícula: ");
                        f1.matricula = sc.nextInt();
                    }
                    lista.add(f1);
                    break;

                case 2:
                    Comissionado c = new Comissionado();
                    System.out.print("Nome: ");
                    sc.nextLine();
                    c.nome = sc.nextLine();
                    System.out.print("Matrícula: ");
                    c.matricula = sc.nextInt();
                    if (c.matricula <= 0) {
                        System.out.println("Valor de matrícula inválido. Digite um valor positivo.");
                        System.out.print("Matrícula: ");
                        c.matricula = sc.nextInt();
                    }
                    System.out.print("Vendas: ");
                    c.vendas = sc.nextDouble();
                    while (c.vendas < 0) {
                    System.out.println("Valor inválido.");
                    c.vendas = sc.nextDouble();
                    }
                    System.out.print("Percentual: ");
                    c.percentual = sc.nextDouble();
                    if (c.percentual < 0 || c.percentual > 100) {
                        System.out.println("Valor de percentual inválido. Digite um valor entre 0 e 100.");
                        System.out.print("Percentual: ");
                        c.percentual = sc.nextDouble();
                    }
                    lista.add(c);
                    break;

                case 3:
                    Producao p = new Producao();
                    System.out.print("Nome: ");
                    sc.nextLine();
                    p.nome = sc.nextLine();
                    System.out.print("Matrícula: ");
                    p.matricula = sc.nextInt();
                    if (p.matricula <= 0) {
                        System.out.println("Valor de matrícula inválido. Digite um valor positivo.");
                        System.out.print("Matrícula: ");
                        p.matricula = sc.nextInt();
                    }
                    System.out.print("Quantidade: ");
                    p.quantidade = sc.nextInt();
                    if (p.quantidade < 0) {
                        System.out.println("Valor de quantidade inválido. Digite um valor positivo.");
                        System.out.print("Quantidade: ");
                        p.quantidade = sc.nextInt();
                    }
                    System.out.print("Valor por peça: ");
                    p.valorPorPeca = sc.nextDouble();
                    if (p.valorPorPeca < 0) {
                        System.out.println("Valor por peça inválido. Digite um valor positivo.");
                        System.out.print("Valor por peça: ");
                        p.valorPorPeca = sc.nextDouble();
                    }
                    lista.add(p);
                    break;

                case 4:
                    System.out.println("\nTotal: " + lista.size());

                    for (Funcionario f : lista) {
                        System.out.println("\nNome: " + f.nome);
                        System.out.println("Matrícula: " + f.matricula);
                        System.out.println("Salário Final: " + f.calcularSalario());
                    }
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}