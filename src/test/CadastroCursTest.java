import com.example.Celular;
import com.example.Estudante;
import com.example.TurmaCurso;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaCadastroCursosTest {

    @Test
    public void testCadastrarEstudanteComCelular() {
        Celular celular = new Celular("123456789");
        assertNotNull(celular);
    }

    @Test
    public void testCadastrarCurso() {
        Curso curso = new Curso("Curso de Java", "40 horas", "Introdução ao Java");
        assertNotNull(curso);
    }

    @Test
    public void testCadastrarTurmaCurso() {
        Date hoje = new Date();
        TurmaCurso turmaCurso = new TurmaCurso("Sala 101", 30, hoje, hoje, hoje, hoje);
        assertNotNull(turmaCurso);
    }

    @Test
    public void testMatricularEstudanteEmTurmaCurso() {
    Celular celular = new Celular("123456789"); // Criando um celular para o estudante
    Estudante estudante = new Estudante("João", "", new Date(), "Rua A", "joao@email.com", celular); // O atributo matrícula será gerado
    TurmaCurso turmaCurso = new TurmaCurso("Sala 101", 30, new Date(), new Date(), new Date(), new Date());

    int vagasDisponiveisAntes = turmaCurso.getVagasDisponiveis();
    turmaCurso.matricularEstudante(estudante, new Date()); // Matricular o estudante

    int vagasDisponiveisDepois = turmaCurso.getVagasDisponiveis();
    assertEquals(vagasDisponiveisAntes - 1, vagasDisponiveisDepois); // Verificar se a quantidade de vagas diminuiu após a matrícula
}

    @Test
    public void testListarEstudantesMatriculadosEmTurmaCurso() {
    Celular celular = new Celular("987654321"); // Criando um celular para o estudante
    Estudante estudante = new Estudante("Maria", "", new Date(), "Rua B", "maria@email.com", celular); // O atributo matrícula será gerado
    TurmaCurso turmaCurso = new TurmaCurso("Sala 101", 30, new Date(), new Date(), new Date(), new Date());

    // Matricular o estudante na turma
    turmaCurso.matricularEstudante(estudante, new Date());

    // Verificar se o estudante está presente na lista de estudantes matriculados
    List<Estudante> estudantesMatriculados = turmaCurso.listarEstudantesMatriculados();
    assertTrue(estudantesMatriculados.contains(estudante));
}

    @Test
    public void testAtualizarVagasDisponiveisEmTurmaCurso() {
        TurmaCurso turmaCurso = new TurmaCurso("Sala 101", 30, new Date(), new Date(), new Date(), new Date());
        int vagas = turmaCurso.getVagasDisponiveis();
        turmaCurso.setVagasDisponiveis(vagas - 1);
        assertEquals(vagas - 1, turmaCurso.getVagasDisponiveis());
    }

    
}
