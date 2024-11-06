package domain;

public class MedidaDeDistancia {
    
    public static double calcularDistancia(Pessoa primeira, Pessoa segunda) {
        double somaQuadrados = 0.0;
        int totalAtributos = 6;

        somaQuadrados += (primeira.getGenero() == segunda.getGenero()) ? 0 : 1;
        somaQuadrados += (primeira.getHobby() == segunda.getHobby()) ? 0 : 1;
        somaQuadrados += (primeira.getEstadoCivil() == segunda.getEstadoCivil()) ? 0 : 1;
        somaQuadrados += (primeira.getEscolaridade() == segunda.getEscolaridade()) ? 0 : 1;

        double diferencaAltura = Math.abs(primeira.getAltura() - segunda.getAltura());
        somaQuadrados += Math.pow(diferencaAltura, 2);

        double diferencaPeso = Math.abs(primeira.getPeso() - segunda.getPeso());
        somaQuadrados += Math.pow(diferencaPeso, 2);

        return Math.sqrt(somaQuadrados) / totalAtributos;
    }
}