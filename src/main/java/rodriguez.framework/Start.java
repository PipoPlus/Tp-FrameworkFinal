package rodriguez.framework;

import java.util.List;

public class Start {

    Framework framework;

    public Start(List<Accion> acciones){
        this.framework = new Framework(acciones);
    }


    public void init(){
        framework.mostrarMenu();
    }


}
