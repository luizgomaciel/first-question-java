package br.java.exam;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AnagramsProgramTest {

    private AnagramsProgram anagramsProgram;

    public AnagramsProgramTest(){
        this.anagramsProgram = new AnagramsProgram();
    }

    @Test
    public void test_validar_grupo_de_letras_vazias_input() {
        // ASSET
        var grupo = "";

        // ACTION && ASSERT
        assertThatThrownBy(() -> anagramsProgram.criarPossiveisGruposDeLetras(grupo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Grupo de letras não pode ser vazio");
    }

    @Test
    public void test_validar_grupo_com_letras_orfaos_input() {
        // ASSET
        var grupo = "a";

        // ACTION && ASSERT
        assertThatThrownBy(() -> anagramsProgram.criarPossiveisGruposDeLetras(grupo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Grupo de letras não pode ser de diferente de 3 caracteres");
    }

    @Test
    public void test_validar_grupo_somente_letras_input() {
        // ASSET
        var grupo = "123";

        // ACTION && ASSERT
        assertThatThrownBy(() -> anagramsProgram.criarPossiveisGruposDeLetras(grupo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Grupo de letras não pode conter caracteres não alfabéticos");
    }

    @Test
    public void test_validar_grupo_gerar_possiveis_combinacoes() {
        // ASSET
        var grupo = "abc";
        List<String> grupoEsperado = List.of("abc", "acb", "bac", "bca", "cab", "cba");

        // ACTION
        var response = anagramsProgram.criarPossiveisGruposDeLetras(grupo);

        // ASSERT
        assertThat(response)
                .isNotNull()
                .isNotEmpty()
                .hasSize(6)
                .containsExactlyInAnyOrderElementsOf(grupoEsperado);

    }

}
