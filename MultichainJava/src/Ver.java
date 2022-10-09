import multichain.object.StreamKey;
import multichain.command.CommandManager;
import multichain.command.CommandElt;
import multichain.command.MultichainException;
import multichain.object.StreamKeyItem;
import java.util.List;

public class Ver {

    String filtroNickname;
    String filtroObra;
    boolean busqueda;
    StreamKeyItem obra;
    String ip = "localhost";
    String puerto = "4360";
    String login = "multichainrpc";
    String password = "Eca2jpE2u2rKHcL3PCpVrwW8he4ztt1Fw7j38f3RMVwq";
    CommandManager commandManager = new CommandManager(ip, puerto, login, password);

    public Ver(String filtroNickname, String filtroObra){
        this.filtroObra = filtroObra;
        this.filtroNickname = filtroNickname;
    }

    public void BuscarAutor() throws MultichainException {
        List<StreamKeyItem> Obras = (List<StreamKeyItem>) commandManager.invoke(CommandElt.LISTSTREAMITEMS, "Obras");
        List<StreamKeyItem> Autores = (List<StreamKeyItem>) commandManager.invoke(CommandElt.LISTSTREAMITEMS, "Autores");

        for (StreamKeyItem i : Autores) {
            if (i.getKeys().get(0).equals(this.filtroNickname)){
                System.out.println("Informacion Autor:");
                System.out.println(i.getData());
                busqueda = true;
                break;
            }else{
                busqueda = false;
            }
        }
        if (busqueda){
            System.out.println("Información de sus Obras:");
            for (StreamKeyItem i : Obras) {
                if (i.getKeys().get(0).equals(this.filtroNickname)){
                    System.out.println(i.getData());
                }
            }
        }else{
            System.out.println("No se ha encontrado el autor con el nombre dado");
        }
    }

    public void BuscarObra() throws MultichainException {
        List<StreamKeyItem> Obras = (List<StreamKeyItem>) commandManager.invoke(CommandElt.LISTSTREAMITEMS, "Obras");
        List<StreamKeyItem> Autores = (List<StreamKeyItem>) commandManager.invoke(CommandElt.LISTSTREAMITEMS, "Autores");

        for (StreamKeyItem i : Obras) {
            if (i.getKeys().get(1).equals(this.filtroObra)){
                System.out.println("Informacion Obra:");
                System.out.println(i.getData());
                obra = i;
                busqueda = true;
                break;
            }
        }
        if (busqueda){
            System.out.println("Informacion Autor de la Obra:");
            for (StreamKeyItem i : Autores) {
                if (i.getKeys().get(0).equals(obra.getKeys().get(0))){
                    System.out.println(i.getData());
                    break;
                }
            }
        }else{
            System.out.println("No se ha encontrado la obra con el nombre dado");
        }
    }

    public void BuscarAutorObra() throws MultichainException {
        List<StreamKeyItem> Obras = (List<StreamKeyItem>) commandManager.invoke(CommandElt.LISTSTREAMITEMS, "Obras");
        List<StreamKeyItem> Autores = (List<StreamKeyItem>) commandManager.invoke(CommandElt.LISTSTREAMITEMS, "Autores");

        for (StreamKeyItem i : Obras) {
            if (i.getKeys().get(0).equals(this.filtroNickname) && i.getKeys().get(1).equals(this.filtroObra)) {
                System.out.println("Informacion la Obra:");
                System.out.println(i.getData());
                busqueda = true;
                break;
            }else{
                busqueda = false;
            }
        }

        if (busqueda){
            System.out.println("Informacion de su Autor:");
            for (StreamKeyItem i : Autores) {
                if (i.getKeys().get(0).equals(this.filtroNickname)) {
                    System.out.println(i.getData());
                    break;
                }
            }
        }else{
            System.out.println("No se ha encontrado esa obra con ese autor");
        }
    }
}
