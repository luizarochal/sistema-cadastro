package test;

import org.junit.Before;
import org.junit.Test;

import domain.Dataset;
import domain.Pessoa;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class DatasetTest {
    private Dataset dataset;
    private Pessoa pessoa1, pessoa2, pessoa3, pessoa4, pessoa5, novaPessoa;

    @Before
    public void setUp() {
        dataset = new Dataset();
        pessoa1 = new Pessoa("Ana", LocalDate.of(1995, 4, 10), Pessoa.Genero.FEMININO, 1.65f, 55f,
                Pessoa.Hobby.ARTE, Pessoa.EstadoCivil.SOLTEIRO, Pessoa.Escolaridade.SUPERIOR);
        pessoa2 = new Pessoa("Bruno", LocalDate.of(1990, 2, 15), Pessoa.Genero.MASCULINO, 1.75f, 70f,
                Pessoa.Hobby.ESPORTE, Pessoa.EstadoCivil.CASADO, Pessoa.Escolaridade.MEDIO);
        pessoa3 = new Pessoa("Carlos", LocalDate.of(1987, 11, 20), Pessoa.Genero.MASCULINO, 1.80f, 90f,
                Pessoa.Hobby.GAME, Pessoa.EstadoCivil.SOLTEIRO, Pessoa.Escolaridade.FUNDAMENTAL);
        pessoa4 = new Pessoa("Diana", LocalDate.of(1993, 9, 30), Pessoa.Genero.FEMININO, 1.60f, 50f,
                Pessoa.Hobby.CINEMA, Pessoa.EstadoCivil.SOLTEIRO, Pessoa.Escolaridade.SUPERIOR);
        pessoa5 = new Pessoa("Elias", LocalDate.of(1985, 8, 5), Pessoa.Genero.MASCULINO, 1.70f, 75f,
                Pessoa.Hobby.MUSICA, Pessoa.EstadoCivil.CASADO, Pessoa.Escolaridade.POS_GRADUACAO);
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa4);
        dataset.addPessoa(pessoa5);

        novaPessoa = new Pessoa("Fernanda", LocalDate.of(1992, 6, 12), Pessoa.Genero.FEMININO, 1.68f, 65f,
                Pessoa.Hobby.ESPORTE, Pessoa.EstadoCivil.SOLTEIRO, Pessoa.Escolaridade.SUPERIOR);
    }

    @Test
    public void testAddPessoa() {
        assertEquals(5, dataset.size());
        dataset.addPessoa(novaPessoa);
        assertEquals(6, dataset.size());
    }

    @Test
    public void testRemovePessoa() {
        dataset.removePessoa(pessoa1);
        assertEquals(4, dataset.size());
        assertNull(dataset.getPessoaByName("Ana"));
    }

    @Test
    public void testRemovePessoaByName() {
        dataset.removePessoaByName("Bruno");
        assertEquals(4, dataset.size());
        assertNull(dataset.getPessoaByName("Bruno"));
    }

    @Test
    public void testReplacePessoa() {
        Pessoa novaPessoaSubstituta = new Pessoa("Carlos", LocalDate.of(1987, 11, 20), Pessoa.Genero.MASCULINO, 1.82f, 88f,
                Pessoa.Hobby.GAME, Pessoa.EstadoCivil.DIVORCIADO, Pessoa.Escolaridade.FUNDAMENTAL);
        dataset.replacePessoa(pessoa3, novaPessoaSubstituta);
        Pessoa encontrada = dataset.getPessoaByName("Carlos");
        assertNotNull(encontrada);
        assertEquals(1.82f, encontrada.getAltura(), 0.001);
        assertEquals(88f, encontrada.getPeso(), 0.001);
        assertEquals(Pessoa.EstadoCivil.DIVORCIADO, encontrada.getEstadoCivil());
    }

    @Test
    public void testGetPessoaByName() {
        Pessoa encontrada = dataset.getPessoaByName("Diana");
        assertNotNull(encontrada);
        assertEquals("Diana", encontrada.getNome());
    }

    @Test
    public void testGetAll() {
        List<Pessoa> todas = dataset.getAll();
        assertEquals(5, todas.size());
        assertEquals("Ana", todas.get(0).getNome());
        assertEquals("Bruno", todas.get(1).getNome());
        assertEquals("Carlos", todas.get(2).getNome());
        assertEquals("Diana", todas.get(3).getNome());
        assertEquals("Elias", todas.get(4).getNome());
    }

    @Test
    public void testHeightMethods() {
        double alturaEsperadaMaxima = 1.80;
        double alturaEsperadaMinima = 1.60;
        
        double somaAlturas = 1.65 + 1.75 + 1.80 + 1.60 + 1.70;
        double alturaEsperadaMedia = somaAlturas / 5;
        
        assertEquals(alturaEsperadaMaxima, dataset.maxAltura(), 0.001);
        assertEquals(alturaEsperadaMinima, dataset.minAltura(), 0.001);
        assertEquals(alturaEsperadaMedia, dataset.avgAltura(), 0.001);
    }

    @Test
    public void testWeightMethods() {
        assertEquals(90, dataset.maxPeso(), 0.001);
        assertEquals(50, dataset.minPeso(), 0.001);
        assertEquals(68, dataset.avgPeso(), 0.001);
    }

    @Test
    public void testNormalizeFieldAltura() {
        dataset.normalizeField("altura");
        Pessoa p = dataset.getPessoaByName("Ana");
        assertEquals(1.65 / 1.80, p.getAltura(), 0.001);
    }

    @Test
    public void testNormalizeFieldPeso() {
        dataset.normalizeField("peso");
        Pessoa p = dataset.getPessoaByName("Bruno");
        assertEquals(70 / 90.0, p.getPeso(), 0.001);
    }

    @Test
    public void testCalcDistanceVector() {
        List<Double> distancias = dataset.calcDistanceVector(novaPessoa);
        assertEquals(5, distancias.size());
        assertTrue(distancias.get(0) > 0);
    }

    @Test
    public void testGetSimilar() {
        List<Pessoa> similares = dataset.getSimilar(novaPessoa, 3);
        assertEquals(3, similares.size());
        assertEquals("Bruno", similares.get(0).getNome());
        assertEquals("Ana", similares.get(1).getNome());
        assertEquals("Elias", similares.get(2).getNome());
    }
}
