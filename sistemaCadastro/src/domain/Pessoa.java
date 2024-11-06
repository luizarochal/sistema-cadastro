package domain;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;
    private float altura;
    private float peso;
    private Hobby hobby;
    private EstadoCivil estadoCivil;
    private Escolaridade escolaridade;

    public enum Genero {
        FEMININO, MASCULINO
    }

    public enum Hobby {
        ARTE, ESPORTE, CINEMA, LIVRO, MUSICA, CULINaRIA, GAME, NENHUM
    }

    public enum EstadoCivil {
        SOLTEIRO, CASADO, VIUVO, SEPARADO, DIVORCIADO
    }

    public enum Escolaridade {
        NENHUMA, FUNDAMENTAL, MEDIO, SUPERIOR, POS_GRADUACAO
    }

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero, float altura, float peso, 
                  Hobby hobby, EstadoCivil estadoCivil, Escolaridade escolaridade) {
        this.nome = nome;
        setDataNascimento(dataNascimento);
        this.genero = genero;
        setAltura(altura);
        setPeso(peso);
        this.hobby = hobby;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser no futuro.");
        }
        this.dataNascimento = dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if (altura <= 0 || altura > 3.0) {
            throw new IllegalArgumentException("Altura deve estar entre 0 e 3.0 metros.");
        }
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        if (peso <= 0 || peso >= 300) {
            throw new IllegalArgumentException("Peso deve estar entre 0 e 300 kg.");
        }
        this.peso = peso;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }
}
