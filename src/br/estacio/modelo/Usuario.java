package br.estacio.modelo;

public class Usuario { // Classe Usuário
    
    private int id; // Atributo id
    private String nome;
    private String email;
    private String senha;

    public int getId() { // Acessores dos atributos. GET e SET (em Python se chama Self)
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

      public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override // Notação para sobrepor o método toString
    public String toString() { // método de representação de Strings 
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + '}';
    }
    public boolean validarLogin(String email, String senha){
     //   return (this.email.equals(email) && Criptografia.decrypt(getSenha()).equals(senha));
          return (this.email.equals(email) && this.senha.equals(senha));
    }
}