package Funcion;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import modelo.Veterinario;
import modelo.Asistente;
import modelo.Persona;
public class AgragaUsuario {
    private static final String FILE_NAME = "./src/Funcion/usuarios.txt";
    private TreeMap<Integer, Persona> usuarios = new TreeMap<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void leerUsuarios() throws IOException, ParseException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                //System.out.println("vamos bien");
                String nombre = data[0];
                String aPaterno = data[1];
                String aMaterno = data[2];
                String fechaNacimiento = data[3];
                String curp = data[4];
                if (data.length == 7 && "Veterinario".equals(data[6])) {
                	System.out.println("1");
                    int cedula = Integer.parseInt(data[5]);
                    usuarios.put(usuarios.size() + 1, new Veterinario(nombre, aPaterno, aMaterno, fechaNacimiento, curp, cedula));
                } else if (data.length == 7 && "Asistente".equals(data[6])) {
                    int cedula = Integer.parseInt(data[5]);
                    usuarios.put(usuarios.size() + 1, new Asistente(nombre, aPaterno, aMaterno, fechaNacimiento, curp, cedula));
                }
            }
        }
    }

    public void guardarUsuarios() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Persona usuario : usuarios.values()) {
                bw.write(usuario.toString());
                bw.newLine();
            }
        }
    }

    public void agregarUsuario(Persona usuario) {
        usuarios.put(usuarios.size() + 1, usuario);
    }

    public void borrarUsuario(int id) {
        usuarios.remove(id);
    }

    public Persona obtenerUsuario(int id) {
        return usuarios.get(id);
    }

    public void imprimirUsuarios() {
        for (Persona usuario : usuarios.values()) {
            System.out.println(usuario);
        }
    }

    public static void main(String[] args) {
    	AgragaUsuario manager = new AgragaUsuario();
        try {
            manager.leerUsuarios();
            manager.imprimirUsuarios();

            // Agregar un nuevo Veterinario
            //Veterinario veterinario = new Veterinario("Ana", "Gomez", "Lopez", new Date(), "ANA1234567890", 1234);
            //manager.leerUsuarios();

            // Agregar un nuevo Asistente
            Asistente asistente = new Asistente("Luis", "Martinez", "Perez", "1995-05-09", "LUI1234567890", 5678);
            manager.agregarUsuario(asistente);

            // Guardar los cambios en el archivo
           manager.guardarUsuarios();
            System.out.println("2");
            // Imprimir los usuarios actualizados
            manager.imprimirUsuarios();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            
        }
    }
}
