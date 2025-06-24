package br.java.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnagramsProgram {
    public List<String> criarPossiveisGruposDeLetras(String grupo) {
        String messageError = validacaoInputGrupo(grupo);

        if(!messageError.isEmpty()){
            throw new IllegalArgumentException(messageError);
        }

        return gerarCombinacoes(grupo);
    }

    private String validacaoInputGrupo(String grupo) {
        if (Objects.isNull(grupo) || grupo.isEmpty()) {
            return "Grupo de letras não pode ser vazio";
        }

        if (grupo.length() != 3) {
            return "Grupo de letras não pode ser de diferente de 3 caracteres";
        }

        if (!grupo.matches("[a-zA-Z]+")) {
            return "Grupo de letras não pode conter caracteres não alfabéticos";
        }

        return "";
    }

    private List<String> gerarCombinacoes(String grupo) {
        List<String> combinacoes = new ArrayList<>();
        char[] posicaoInicial = grupo.toCharArray();

        for(int i = 0; i < posicaoInicial.length; i++){
            char[] temp = posicaoInicial.clone();
            char pivo = temp[i];
            if(pivo != posicaoInicial[0]){
                temp[0] = pivo;
                temp[i] = posicaoInicial[0];
            }

            String combinacaoUm = String.valueOf(pivo).concat(String.valueOf(temp[1])).concat(String.valueOf(temp[2]));
            String combinacaoDois = String.valueOf(pivo).concat(String.valueOf(temp[2])).concat(String.valueOf(temp[1]));

            combinacoes.add(combinacaoUm);
            combinacoes.add(combinacaoDois);
        }

        return combinacoes;
    }

}
