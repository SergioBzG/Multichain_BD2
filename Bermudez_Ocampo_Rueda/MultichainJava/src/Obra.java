import multichain.object.StreamKey;
import multichain.command.CommandManager;
import multichain.command.CommandElt;
import multichain.command.MultichainException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Obra {

    String nickname;
    String nombre;
    String fecha_creacion;
    String obra;
    long item;
    List<String> claves = new ArrayList<String>();
    String ip = "localhost";
    String puerto = "4360";
    String login = "multichainrpc";
    String password = "Eca2jpE2u2rKHcL3PCpVrwW8he4ztt1Fw7j38f3RMVwq";

    public Obra(String nickname, String nombre, String fecha_creacion, String obra) throws ParseException, MultichainException {
        this.nickname = nickname;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.obra = obra;

        System.out.println(SubirObra());
    }

    public String SubirObra() throws MultichainException, ParseException {
        CommandManager commandManager = new CommandManager(ip, puerto, login, password);

        List<StreamKey> query = (List<StreamKey>) commandManager.invoke(CommandElt.LISTSTREAMKEYS, "Autores", this.nickname, true);
        item = query.get(0).getItems();

        if (item != 0) {
            String dato = "{\"json\":{\"fecha_creacion\":\"" + this.fecha_creacion + "\",\"obra\":\"" + this.obra + "\"}}";
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(dato);

            claves.add(this.nickname);
            claves.add(this.nombre);

            commandManager.invoke(CommandElt.PUBLISH, "Obras", claves, json);

            return ("Se ha subido la obra con las claves: " + this.nickname + " , " + this.nombre);
        }
        return("No se ha subido la obra, el nickname: " + this.nickname + " no hace referencia a ningun autor");
    }

}
