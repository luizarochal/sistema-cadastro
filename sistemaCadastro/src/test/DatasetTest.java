package test;

import org.junit.Before;
import org.junit.Test;

import domain.Dataset;
import domain.Pessoa;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DatasetTest {
    private Dataset dataset;
    private Pessoa pessoa1, pessoa2;

    @Before
    public void setUp() {
        dataset = new Dataset();
        pessoa1 = new Pessoa("Ben", LocalDate.of(1990, 5, 15), Pessoa.Genero.FEMININO, 1.65f, 60f,
                Pessoa.Hobby.CINEMA, Pessoa.EstadoCivil.SOLTEIRO, Pessoa.Escolaridade.SUPERIOR);
        pessoa2 = new Pessoa("Bob", LocalDate.of(1985, 10, 10), Pessoa.Genero.MASCULINO, 1.75f, 80f,
                Pessoa.Hobby.ESPORTE, Pessoa.EstadoCivil.CASADO, Pessoa.Escolaridade.MEDIO);
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
    }

    @Test
    public void testAddPessoa() {
        assertEquals(2, dataset.size());
    }

    @Test
    public void testRemovePessoa() {
        dataset.removePessoa(pessoa1);
        assertEquals(1, dataset.size());
    }

    @Test
    public void testRemovePessoaByName() {
        dataset.removePessoaByName("Ben");
        assertNull(dataset.getPessoaByName("Ben"));
    }

    @Test
    public void testReplacePessoa() {
        Pessoa novaPessoa = new Pessoa("Charlie", LocalDate.of(1992, 8, 20), Pessoa.Genero.MASCULINO, 1.80f, 75f,
                Pessoa.Hobby.MÚSICA, Pessoa.EstadoCivil.SOLTEIRO, Pessoa.Escolaridade.SUPERIOR);
        dataset.replacePessoa(pessoa2, novaPessoa);
        assertEquals("Charlie", dataset.getPessoaByName("Charlie").getNome());
    }

    @Test
    public void testGetAll() {
        assertEquals(2, dataset.getAll().size());
        assertEquals("Ben", dataset.getAll().get(0).getNome());
    }

    @Test
    public void testHeightMethods() {
        assertEquals(1.75f, dataset.maxAltura(), 0.01);
        assertEquals(1.65f, dataset.minAltura(), 0.01);
        assertEquals(1.70f, dataset.avgAltura(), 0.01);
    }

    @Test
    public void testWeightMethods() {
        assertEquals(80f, dataset.maxPeso(), 0.01);
        assertEquals(60f, dataset.minPeso(), 0.01);
        assertEquals(70f, dataset.avgPeso(), 0.01);
    }
}

