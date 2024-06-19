package rodriguez.main;


import rodriguez.framework.Configuracion;
import rodriguez.framework.Start;


public class Main {
    public static void main(String[]args){
        Configuracion config = new Configuracion();

        Start m = new Start(config.configToActionsList());
        m.init();
    }
}
