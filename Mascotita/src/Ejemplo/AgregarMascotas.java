package Ejemplo;
import java.io.*;
import java.util.*;
import modelo.Mascota;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
public class AgregarMascotas {
    private static final String FILE_NAME = "mascotas.txt";
    private TreeMap<Integer, Mascota> mascotas = new TreeMap<>();

    public void leerMascotas() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int numeroMascota = Integer.parseInt(data[0]);
                String nombre = data[1];
                String raza = data[2];
                mascotas.put(numeroMascota, new Mascota(nombre, raza, numeroMascota));
            }
        }catch(Exception e) { 
        	e.getStackTrace(); }
    }

    public void guardarMascotas() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Mascota mascota : mascotas.values()) {
                bw.write(mascota.toString());
                bw.newLine();
            }
        }
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.put(mascota.getNumeroMascota(), mascota);
    }

    public void borrarMascota(int numeroMascota) {
        mascotas.remove(numeroMascota);
    }

    public Mascota obtenerMascota(int numeroMascota) {
        return mascotas.get(numeroMascota);
    }

    public void imprimirMascotas() {
        for (Mascota mascota : mascotas.values()) {
            System.out.println(mascota);
        }
    }

    public static void masco(String[] args) {
    	AgregarMascotas manager = new AgregarMascotas();
        try {
            

            // Agregar una nueva Mascota
            Mascota nuevaMascota = new Mascota("Pulgas", "Labrador", 1);
            manager.agregarMascota(nuevaMascota);

            // Agregar otra nueva Mascota
            Mascota otraMascota = new Mascota("solovino", "Husky", 2);
            manager.agregarMascota(otraMascota);
            
            manager.leerMascotas();
            manager.imprimirMascotas();
            // Borrar una mascota
            manager.borrarMascota(1);

            // Guardar los cambios en el archivo
            manager.guardarMascotas();

            // Imprimir las mascotas actualizadas
            manager.imprimirMascotas();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

