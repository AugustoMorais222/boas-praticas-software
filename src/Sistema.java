/**
 * Ponto de entrada do sistema: monta os dados do aluno e apresenta o boletim.
 */
public class Sistema {

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Carlos", 8, 7);

        exibirBoletim(aluno);
    }

    private static void exibirBoletim(Aluno aluno) {
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Media: " + aluno.calcularMedia());
        System.out.println(aluno.obterSituacao());
    }
}
