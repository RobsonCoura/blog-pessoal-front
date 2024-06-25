package org.generation.Blog.Pessoal.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.Blog.Pessoal.model.UsuarioModel;
import org.generation.Blog.Pessoal.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start() {

        usuarioRepository.save(new UsuarioModel(0L, "João da Silva", "joao@email.com.br", "12345678"));

        usuarioRepository.save(new UsuarioModel(0L, "Manuela da Silva", "manuela@email.com.br", "13465278"));

        usuarioRepository.save(new UsuarioModel(0L, "Adriana da Silva", "adriana@email.com.br", "13465278"));

        usuarioRepository.save(new UsuarioModel(0L, "Paulo Antunes", "paulo@email.com.br", "13465278"));

    }

    @Test
    @DisplayName("Retorna 1 usuario")
    public void deveRetornarUmUsuario() {

        Optional<UsuarioModel> usuario = usuarioRepository.findByUsuario("joao@email.com.br");
        assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
    }

//    @Test
//    @DisplayName("Retorna 3 usuarios com sobrenome Silva")
//    public void deveRetornarTresUsuarios() {
//        List<UsuarioModel> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
//
//        // Verifica se foram retornados exatamente 3 usuários com sobrenome Silva
//        assertEquals(3, listaDeUsuarios.size());
//
//        // Verifica se os nomes dos usuários estão corretos
//        assertTrue(listaDeUsuarios.stream().anyMatch(usuario -> usuario.getNome().equals("João da Silva")));
//        assertTrue(listaDeUsuarios.stream().anyMatch(usuario -> usuario.getNome().equals("Manuela da Silva")));
//        assertTrue(listaDeUsuarios.stream().anyMatch(usuario -> usuario.getNome().equals("Adriana da Silva")));
//    }

}
