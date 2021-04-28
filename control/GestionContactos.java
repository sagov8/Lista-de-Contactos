package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.Persona;

/**
 *
 * @author sagov8
 */
public class GestionContactos {

    List<Persona> lista_contactos = new ArrayList<>();
    Persona persona;

    public void registrarPersona(String id, String nom, String años, String gene, String telefono) {
        persona = new Persona();
        persona.setId(id);
        persona.setNombre(nom);
        persona.setEdad(años);
        persona.setGenero(gene);
        persona.setNumeroTelefonico(Integer.parseInt(telefono));
        lista_contactos.add(persona);
        JOptionPane.showMessageDialog(null, " CONTACTO REGISTRADO");
    }

    public void modificarPersona(String id, String nom, String años, String gene, String numero) {
        int pos = Integer.parseInt(id);

        //persona.setId(id);
        persona.setNombre(nom);
        persona.setEdad(años);
        persona.setGenero(gene);
        persona.setNumeroTelefonico(Integer.parseInt(numero));

        lista_contactos.add(pos, persona);
        JOptionPane.showMessageDialog(null, "EL CONTACTO SE HA MODIFICADO");

    }

    public void listaPersona(JTextArea area) {

        area.setText("");
        for (int posicion = 0; posicion < lista_contactos.size(); posicion++) {
            Persona persona = lista_contactos.get(posicion);
            area.append("\nContacto: ");
            area.append("\n ID: " + persona.getId());
            area.append("\nNombre: " + persona.getNombre());
            area.append("\nEdad: " + persona.getEdad());
            area.append("\nGenero: " + persona.getGenero());
            area.append("\nNumero de telefono:" + persona.getNumeroTelefonico());
        }

    }

    public void eliminarPersona(Persona p) {

    }

    public Persona consultarPersona(String id) {
        int posicion = -1;
        //Busca con un foreach la persona con el ID
        for (Persona persona : lista_contactos) {
            if (persona.getId().equals(id)) {
                posicion = lista_contactos.indexOf(persona);
            }
        }
        //Si se encuentra asigna la posición
        if (posicion != -1) {
            return lista_contactos.get(posicion);
        } else {
            Persona p = new Persona();
            return p;
        }

    }
}
