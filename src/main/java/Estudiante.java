public class Estudiante extends Persona {
    private String estado;

    public Estudiante(int id, String nombre, String apellido, String fechaDeNacimiento, String estado) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }

    // Getter y setter
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
