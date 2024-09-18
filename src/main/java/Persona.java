public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String fechaDeNacimiento;

    public Persona(int id, String nombre, String apellido, String fechaDeNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
