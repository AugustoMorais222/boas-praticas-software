/**
 * Representa um aluno e as notas obtidas nos dois bimestres.
 */
public class Aluno {

    private static final double MEDIA_MINIMA_PARA_APROVACAO = 6.0;

    private final String nome;
    private final double notaPrimeiroBimestre;
    private final double notaSegundoBimestre;

    public Aluno(String nome, double notaPrimeiroBimestre, double notaSegundoBimestre) {
        this.nome = nome;
        this.notaPrimeiroBimestre = notaPrimeiroBimestre;
        this.notaSegundoBimestre = notaSegundoBimestre;
    }

    public String getNome() {
        return nome;
    }

    public double calcularMedia() {
        return (notaPrimeiroBimestre + notaSegundoBimestre) / 2;
    }

    public boolean estaAprovado() {
        return calcularMedia() >= MEDIA_MINIMA_PARA_APROVACAO;
    }

    public String obterSituacao() {
        return estaAprovado() ? "Aprovado" : "Reprovado";
    }
}
