public class Rio {
    public boolean[] blocos;
    public Canoa canoa;
    private int ultimaPosicaoMovimentoCanoa;
    public Rio(int tamanho, Canoa canoa){
        if (tamanho > (canoa.blocos.length * 2)) {
            blocos = new boolean[tamanho];
            this.canoa = canoa;
            moverCanoa(0);
        }        
    }
    public int getUltimaPosicaoMovimentoCanoa(){
        return ultimaPosicaoMovimentoCanoa;
    }
    public void limparRio(){
        for (int indice = 0; indice < blocos.length; indice++) {
            blocos[indice] = false;
        }
    }
    public void moverCanoa(int posicao){        
        int limiteCanoa = posicao + canoa.blocos.length - 1;
        if (posicao >= 0 && limiteCanoa < blocos.length) {
            ultimaPosicaoMovimentoCanoa = posicao;
            int indiceCanoa = 0;            
            for (int indiceRio = 0; indiceRio < blocos.length; indiceRio++) {
                if (indiceRio >= posicao && indiceCanoa < canoa.blocos.length) {
                    blocos[indiceRio] = canoa.blocos[indiceCanoa];
                    indiceCanoa++;
                }
                else{
                    blocos[indiceRio] = false;
                }
            }
        }
    }
    public boolean estaVazio(){
        for (boolean bloco : blocos) {
            if (bloco == true) {
                return false;
            }
        }        
        return true;
    }
    /*
                [0][1][2][3]
    [~][~][~][~][#][#][~][#][~][~]
    [0][1][2][3][4][5][6][7][8][9]
                 U     A  F
    */
    public void receberAtaque(int posicao){
        if (posicao >=0 && posicao < blocos.length) {
            int posicaoFinalCanoa = ultimaPosicaoMovimentoCanoa + canoa.blocos.length;
            if (posicao >= ultimaPosicaoMovimentoCanoa && posicao < posicaoFinalCanoa) {
                int posicaoDentroCanoa = posicao - ultimaPosicaoMovimentoCanoa;
                canoa.destruirBloco(posicaoDentroCanoa);                
            }
            moverCanoa(ultimaPosicaoMovimentoCanoa);
        }
    }
    @Override
    public String toString() {
        String textCanoa = "";
        for (int indice = 0; indice < canoa.blocos.length; indice++) {
            textCanoa += indice + ":[" + canoa.blocos[indice] + "]  ";
        }  
        String textBlocos = "";
        for (int indice = 0; indice < blocos.length; indice++) {
            textBlocos += indice + ":[" + blocos[indice] + "]  ";
        }    
        return  "Rio{\n" + 
                "  + canoa (" + canoa.nome + ") = " + textCanoa + "\n" +
                "  + blocos = " + textBlocos + "\n" +
                "  + Esta Vazio? " + estaVazio() + "\n" +
                "}";
    }
}