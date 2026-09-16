// URL: http://localhost:8080/OTinder

package org.example.controler;

import org.example.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/OTinder")
public class PerfilControlador {

    // Guarda os usuários enquanto o servidor estiver ligado
    private List<Usuario> listaUsuarios = new ArrayList<>();


    // C CREATE
    @PostMapping
    public String criarUsuario(@RequestBody Usuario usuario) {
        listaUsuarios.add(usuario);
        return "Usuário " + usuario.getNome() + " cadastrado com sucesso!";
    }


    // R READ
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return listaUsuarios;
    }


    // U UPDATE
    @PutMapping("/{email}")
    public String atualizarUsuario(@PathVariable String email, @RequestBody Usuario usuarioAtualizado) {
        for (Usuario usuarioEncontrado : listaUsuarios) {
            if (usuarioEncontrado.getEmail() != null && usuarioEncontrado.getEmail().equalsIgnoreCase(email)) {

                // Substitui os dados do usuário antigo pelos novos
                usuarioEncontrado.setNome(usuarioAtualizado.getNome());
                usuarioEncontrado.setBio(usuarioAtualizado.getBio());
                usuarioEncontrado.setCurso(usuarioAtualizado.getCurso());
                usuarioEncontrado.setHabitos(usuarioAtualizado.getHabitos());
                usuarioEncontrado.setGenero(usuarioAtualizado.getGenero());
                usuarioEncontrado.setLocalizacao(usuarioAtualizado.getLocalizacao());
                usuarioEncontrado.setDt_nascimento(usuarioAtualizado.getDt_nascimento());

                return "Usuário atualizado com sucesso!";
            }
        }
        return "Usuário não encontrado para atualização!";
    }

    // D DELETE

    @DeleteMapping("/{email}")
    public String deletarUsuario(@PathVariable String email) {
        // Percorre a lista e remove se o e-mail for igual
        boolean deletado = listaUsuarios.removeIf(usuarioTal -> usuarioTal.getEmail() != null && usuarioTal.getEmail().equalsIgnoreCase(email));

        if (deletado) {
            return "Usuário com e-mail '" + email + "' deletado com sucesso!";
        }

        return "Usuário não encontrado para remoção!";
    }
}