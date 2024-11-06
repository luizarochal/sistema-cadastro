package main;

import java.time.LocalDate;
import java.util.List;

import domain.Dataset;
import domain.Pessoa;

public class Main {
   public static void main(String[] args) {
        Dataset dataset = new Dataset();

        dataset.addPessoa(new Pessoa("Ana", LocalDate.of(1995, 4, 10), Pessoa.Genero.FEMININO, 1.65f, 55f, Pessoa.Hobby.ARTE, Pessoa.EstadoCivil.SOLTEIRO, Pessoa.Escolaridade.SUPERIOR));
        dataset.addPessoa(new Pessoa("Bruno", LocalDate.of(1990, 2, 15), Pessoa.Genero.MASCULINO, 1.75f, 70f, Pessoa.Hobby.ESPORTE, Pessoa.EstadoCivil.CASADO, Pessoa.Escolaridade.MEDIO));
        dataset.addPessoa(new Pessoa("Carlos", LocalDate.of(1987, 11, 20), Pessoa.Genero.MASCULINO, 1.80f, 90f, Pessoa.Hobby.GAME, Pessoa.EstadoCivil.SOLTEIRO, Pessoa.Escolaridade.FUNDAMENTAL));
        dataset.addPessoa(new Pessoa("Diana", LocalDate.of(1993, 9, 30), Pessoa.Genero.FEMININO, 1.60f, 50f, Pessoa.Hobby.CINEMA, Pessoa.EstadoCivil.SOLTEIRO, Pessoa.Escolaridade.SUPERIOR));
        dataset.addPessoa(new Pessoa("Elias", LocalDate.of(1985, 8, 5), Pessoa.Genero.MASCULINO, 1.70f, 75f, Pessoa.Hobby.MUSICA, Pessoa.EstadoCivil.CASADO, Pessoa.Escolaridade.POS_GRADUACAO));

        Pessoa novaPessoa = new Pessoa("Fernanda", LocalDate.of(1992, 6, 12), Pessoa.Genero.FEMININO, 1.68f, 65f, Pessoa.Hobby.ESPORTE, Pessoa.EstadoCivil.SOLTEIRO, Pessoa.Escolaridade.SUPERIOR);

        List<Pessoa> similares = dataset.getSimilar(novaPessoa, 3);

        System.out.println("Pessoas mais similares a Fernanda:");
        for (Pessoa p : similares) {
            System.out.println("Nome: " + p.getNome());
        }
    }
}
