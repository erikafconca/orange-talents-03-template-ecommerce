package com.example.mercadolivre.handleerros;

public class ErroResponse {

    private String campo;
    private String mensagem;

    public ErroResponse(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
