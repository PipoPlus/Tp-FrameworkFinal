package rodriguez.main;


import rodriguez.framework.Configuracion;
import rodriguez.framework.Start;


public class Main {
    public static void main(String[]args){
        Configuracion config = new Configuracion();

        Start m = new Start(config.configToActionsList("C:\\Users\\elrod\\OneDrive\\Escritorio\\Cosas\\Uni\\OO2\\TRABAJO FINAL FRAMEWORK" +
                "\\Tp-Framework\\src\\main\\resources\\config.properties"));
        m.init();
    }
}
