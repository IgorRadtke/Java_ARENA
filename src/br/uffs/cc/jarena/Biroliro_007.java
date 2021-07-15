// Igor Radtke____João Vitor Betiatto.
package br.uffs.cc.jarena;

public class Biroliro_007 extends Agente
{
    
    public Biroliro_007(Integer x, Integer y, Integer energia) {
        super(x, y, energia);
        setDirecao(geraDirecaoAleatoria());
    }
    int counter;
    public void pensa() {
        counter ++;
        
        // Se não conseguimos nos mover para a direção atual, quer dizer
        // que chegamos no final do mapa ou existe algo bloqueando nosso
        // caminho.
        if (getEnergia()<225){
            para();
        }
        else {

        if(!podeMoverPara(getDirecao())) {
            // Como não conseguimos nos mover, vamos escolher uma direção
            // nova.
            setDirecao(geraDirecaoAleatoria());
        }
            
        
        }
        // Se o agente conseguie se dividir (tem energia) e se o total de energia
        // do agente é maior que 400, nos dividimos. O agente filho terá a metade
        // da nossa energia atual.
        /*if(podeDividir() && getEnergia() >= 800) {
            divide();
        }*/
    }


    
    public void recebeuEnergia() {
        
        //para();
        
        System.out.println(" Cola ai rapaziada, bora ficar juntinho! x= " + getX() + " y = " + getY());

        // "10|30"
        enviaMensagem("L");
        enviaMensagem("M");
        // Invocado sempre que o agente recebe energia.
    }
    
    public void tomouDano(int energiaRestanteInimigo) {
        System.out.println(getId() + " Vem tranquilo, vem tranquilo, temo lutando aqui rapaziada ");
        // Invocado quando o agente está na mesma posição que um agente inimigo
        // e eles estão batalhando (ambos tomam dano).
    }
    
    public void ganhouCombate(){ 
        System.out.println("dale gurizada -1 ou +1? ");
        // Invocado se estamos batalhando e nosso inimigo morreu.
    }
    
    public void recebeuMensagem(String msg) {
        
        // Invocado sempre que um agente aliado próximo envia uma mensagem.
        
        if(msg.equals("L")) {
            para();
        }
        
        if(msg.equals("M")) {
            setDirecao(geraDirecaoAleatoria());
        }
        System.out.println("Fala meu bom, recebi sua mensagem!" + msg);
    }
    
    
    public String getEquipe() {
        // Definimos que o nome da equipe do agente é "Fernando".
        return "Biroliro_007";
    }
}
