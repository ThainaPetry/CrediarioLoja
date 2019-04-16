import java.util.Date;

/* criando uma classe com os dados das compras e declarando suas variaveis */

public class Compras {
    public float valor;
    public Date data;
    public short form_pagamento;
    public float valor_rec;


    /*Aqui é onde permito que o método acesse o atributo*/
    public Compras(float valor, Date data, short forma_pagamento, float valor_rec, int parcelas) {
        this.valor = valor;
        this.data = data;
        this.form_pagamento = forma_pagamento;
        this.valor_rec = valor_rec;

    }
}
