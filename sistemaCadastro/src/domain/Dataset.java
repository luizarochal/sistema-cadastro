package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dataset {
    private List<Pessoa> pessoas;
    public static final int MAX_PESSOAS = 100;

    public Dataset() {
        this.pessoas = new ArrayList<>();
    }

    public void addPessoa(Pessoa pessoa) {
        if (pessoas.size() < MAX_PESSOAS) {
            pessoas.add(pessoa);
        } else {
            throw new IllegalStateException("Dataset atingiu o limite máximo de pessoas.");
        }
    }

    public void removePessoa(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

    public void removePessoaByName(String nome) {
        pessoas.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    public void replacePessoa(Pessoa oldPessoa, Pessoa newPessoa) {
        int index = pessoas.indexOf(oldPessoa);
        if (index != -1) {
            pessoas.set(index, newPessoa);
        }
    }

    public Pessoa getPessoaByName(String nome) {
        return pessoas.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<Pessoa> getAll() {
        return pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .collect(Collectors.toList());
    }

    public int size() {
        return pessoas.size();
    }

    public float maxAltura() {
        return pessoas.stream()
                .map(Pessoa::getAltura)
                .max(Float::compare)
                .orElse(0f);
    }

    public float minAltura() {
        return pessoas.stream()
                .map(Pessoa::getAltura)
                .min(Float::compare)
                .orElse(0f);
    }

    public float avgAltura() {
        return (float) pessoas.stream()
                .mapToDouble(Pessoa::getAltura)
                .average()
                .orElse(0.0);
    }

    public float maxPeso() {
        return pessoas.stream()
                .map(Pessoa::getPeso)
                .max(Float::compare)
                .orElse(0f);
    }

    public float minPeso() {
        return pessoas.stream()
                .map(Pessoa::getPeso)
                .min(Float::compare)
                .orElse(0f);
    }

    public float avgPeso() {
        return (float) pessoas.stream()
                .mapToDouble(Pessoa::getPeso)
                .average()
                .orElse(0.0);
    }
}
