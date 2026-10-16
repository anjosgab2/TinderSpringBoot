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
    @PostMapping("/criarUsuario")
    public String criarUsuario(@RequestBody Usuario usuario) {
        listaUsuarios.add(usuario);
        return "Usuário " + usuario.getNome() + " cadastrado com sucesso!";
    }

    @PostMapping("/curtir")
    public String curtirPerfil(@RequestParam String origem, @RequestParam String destino) {
        // Aqui no futuro posso gravar que "origem" curtiu "destino"
        // E posso checar se "destino" já tinha curtido "origem" para dar o MATCH!

        return "Você curtiu o perfil de " + destino + "!";
    }

    // R - READ (Buscar apenas um usuário específico)
    @GetMapping("/{email:.+}")
    public Usuario buscarPorEmail(@PathVariable String email) {
        // Valida se o e-mail passado na URL não está vazio
        if (email == null || email.isBlank()) {
            return null;
        }

        // Percorre a lista buscando o e-mail correspondente
        for (Usuario u : listaUsuarios) {
            if (u != null && u.getEmail() != null && u.getEmail().equalsIgnoreCase(email)) {
                return u; // Encontrou o usuário, retorna o objeto e encerra
            }
        }

        return null; // Se não encontrar ninguém com esse e-mail
    }


    // U UPDATE
    @PutMapping("/{email}")
    public String atualizarUsuario(@PathVariable String email, @RequestBody Usuario usuarioAtualizado) {
        for (Usuario usuarioEncontrado : listaUsuarios) {
            if (usuarioEncontrado.getEmail() != null && usuarioEncontrado.getEmail().equalsIgnoreCase(email)) {

                // Substitui os dados do usuário antigo pelos novosx
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

    @GetMapping("/feed/{meuEmail}")
    public List<Usuario> obterFeed(@PathVariable String meuEmail) {
        List<Usuario> candidatos = new ArrayList<>();

        for (Usuario u : listaUsuarios) {
            // Retorna todos da lista, EXCETO o usuário que está navegando
            if (!u.getEmail().equalsIgnoreCase(meuEmail)) {
                candidatos.add(u);
            }
        }
        return candidatos;
    }
}