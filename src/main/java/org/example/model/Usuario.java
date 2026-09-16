package org.example.model;

import java.time.LocalDate;

public class Usuario {

        private String nome;
        private LocalDate dt_nascimento;
        private String email;
        private String senha;
        private Genero genero;
        private Localizacao localizacao;
        private String bio;
        private String curso;
        private String habitos;


    public Usuario (){
        }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getHabitos() {
        return habitos;
    }

    public void setHabitos(String habitos) {
        this.habitos = habitos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", dt_nascimento=" + dt_nascimento +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", genero=" + genero +
                ", localizacao=" + localizacao +
                ", bio='" + bio + '\'' +
                ", curso='" + curso + '\'' +
                ", habitos='" + habitos + '\'' +
                '}';
    }
}
