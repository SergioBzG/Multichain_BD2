import multichain.object.StreamKey;
import multichain.command.CommandManager;
import multichain.command.CommandElt;
import multichain.command.MultichainException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;

public class Autor {

    String nickname;
    String nombre;
    String agno_nacimiento;
    String correo;
    long item;
    String ip = "localhost";
    String puerto = "4360";
    String login = "multichainrpc";
    String password = "Eca2jpE2u2rKHcL3PCpVrwW8he4ztt1Fw7j38f3RMVwq";

    public Autor(String nickname, String nombre, String agno_nacimiento, String correo) throws ParseException, MultichainException {
        this.nickname = nickname;
        this.nombre = nombre;
        this.agno_nacimiento = agno_nacimiento;
        this.correo = correo;

        System.out.println(RegistroAutor());
    }

    public String RegistroAutor() throws MultichainException, ParseException {
        CommandManager commandManager = new CommandManager(ip, puerto, login, password);

        List<StreamKey> query = (List<StreamKey>) commandManager.invoke(CommandElt.LISTSTREAMKEYS, "Autores", this.nickname, true);
        item = query.get(0).getItems();

        if (item == 0) {

            String dato = "{\"json\":{\"nombre\":\"" + this.nombre + "\",\"agno_nacimiento\":\"" + this.agno_nacimiento + "\", \"correo\":\"" + this.correo +"\"}}";
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(dato);
            commandManager.invoke(CommandElt.PUBLISH, "Autores", this.nickname, json);

            return ("Se ha registrado el autor con la clave: " + this.nickname);
        }
        return("No se ha registrado el autor, la clave: " + this.nickname + " ya pertenece a otro autor");
    }
}
