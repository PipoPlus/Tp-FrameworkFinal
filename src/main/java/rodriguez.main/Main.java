package rodriguez.main;


import rodriguez.framwork.Configuracion;
import rodriguez.framwork.Framework;
import rodriguez.framwork.Start;


public class Main {
    public static void main(String[]args){
        Configuracion config = new Configuracion();

        Start m = new Start(config.configToActionsList());
        m.init();
    }
}
