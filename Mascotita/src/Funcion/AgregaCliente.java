package Funcion;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;
import modelo.Cliente;
import modelo.Mascota;
import modelo.Tarejeta;

class AgregaCliente {
    private static final String FILE_NAME = "usuarios.txt";
    private TreeMap<Integer, Cliente> usuarios = new TreeMap<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void leerUsuarios() throws IOException, ParseException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            file.createNewFile(); // Crear el archivo si no existe
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if(data.length!= 13) {
                	System.err.println("Formato incorrecto en la linea: "+ line);
                }
                String nombre = data[0];
                String aPaterno = data[1];
                String aMaterno = data[2];
                String fechaNacimiento = data[3];
                String curp = data[4];
                int noCliente = Integer.parseInt(data[5]);
                String nombreMascota = data[6];
                String razaMascota = data[7];
                int numeroMascota = Integer.parseInt(data[8]);
                Mascota mascota = new Mascota(nombreMascota, razaMascota, numeroMascota);
                int noTarjeta = Integer.parseInt(data[9]);
                Date fechaVencimiento = dateFormat.parse(data[10]);
                short cvc = Short.parseShort(data[11]);
                long saldo = Long.parseLong(data[12]);
                Tarejeta tarjeta = new Tarejeta(noTarjeta, fechaVencimiento, cvc);
                tarjeta.setSaldo(saldo);
                usuarios.put(usuarios.size() + 1, new Cliente(nombre, aPaterno, aMaterno, fechaNacimiento, curp, noCliente, mascota, tarjeta));
            }
        }
    }

    public void guardarUsuarios() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Cliente usuario : usuarios.values()) {
                bw.write(usuario.toString());
                bw.newLine();
            }
        }
    }

    public void agregarUsuario(Cliente usuario) {
        usuarios.put(usuarios.size() + 1, usuario);
    }

    public void borrarUsuario(int id) {
        usuarios.remove(id);
    }

    public Cliente obtenerUsuario(int id) {
        return usuarios.get(id);
    }

    public void imprimirUsuarios() {
        for (Cliente usuario : usuarios.values()) {
            System.out.println(usuario);
        }
    }

    public static void main(String[] args) {
    	AgregaCliente manager = new AgregaCliente();
        Scanner scanner = new Scanner(System.in);
        try {
            manager.leerUsuarios();
            manager.imprimirUsuarios();

            // Ingresar un nuevo Cliente
            System.out.println("Ingrese nombre:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese apellido paterno:");
            String aPaterno = scanner.nextLine();
            System.out.println("Ingrese apellido materno:");
            String aMaterno = scanner.nextLine();
            System.out.println("Ingrese fecha de nacimiento (yyyy-MM-dd):");
            String fechaNac = scanner.nextLine();
            Date fechaNacimiento = manager.dateFormat.parse(fechaNac);
            System.out.println("Ingrese CURP:");
            String curp = scanner.nextLine();
            System.out.println("Ingrese número de cliente:");
            int noCliente = Integer.parseInt(scanner.nextLine());

            // Ingresar datos de la mascota
            System.out.println("Ingrese nombre de la mascota:");
            String nombreMascota = scanner.nextLine();
            System.out.println("Ingrese raza de la mascota:");
            String razaMascota = scanner.nextLine();
            System.out.println("Ingrese número de mascota:");
            int numeroMascota = Integer.parseInt(scanner.nextLine());
            Mascota mascota = new Mascota(nombreMascota, razaMascota, numeroMascota);

            // Ingresar datos de la tarjeta
            System.out.println("Ingrese número de tarjeta:");
            int noTarjeta = Integer.parseInt(scanner.nextLine());
            System.out.println("Ingrese fecha de vencimiento de la tarjeta (yyyy-MM-dd):");
            String fechaVenc = scanner.nextLine();
            Date fechaVencimiento = manager.dateFormat.parse(fechaVenc);
            System.out.println("Ingrese CVC de la tarjeta:");
            short cvc = Short.parseShort(scanner.nextLine());
            System.out.println("Ingrese saldo de la tarjeta:");
            long saldo = Long.parseLong(scanner.nextLine());
            Tarejeta tarjeta = new Tarejeta(noTarjeta, fechaVencimiento, cvc);
            tarjeta.setSaldo(saldo);

            Cliente nuevoCliente = new Cliente(nombre, aPaterno, aMaterno, fechaNacimiento, curp, noCliente, mascota, tarjeta);
            manager.agregarUsuario(nuevoCliente);

            // Guardar los cambios en el archivo
            manager.guardarUsuarios();

            // Imprimir los usuarios actualizados
            manager.imprimirUsuarios();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
