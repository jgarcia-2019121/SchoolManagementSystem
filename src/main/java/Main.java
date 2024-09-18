import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();
        Estudiante est1 = new Estudiante(1, "Juan", "Pérez", "01/01/2000", "matriculado");
        Estudiante est2 = new Estudiante(2, "Ana", "Gómez", "02/02/2001", "matriculado");
        Curso curso1 = new Curso(101, "Matemáticas", "Matemáticas Básicas", 4, "1.0");
        Curso curso2 = new Curso(102, "Historia", "Historia Universal", 3, "1.0");

        gestor.matricularEstudiante(est1);
        gestor.matricularEstudiante(est2);
        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        try {
            gestor.inscribirEstudianteCurso(est1, 101);
            gestor.inscribirEstudianteCurso(est2, 102);
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCursos disponibles:");
        for (Curso curso : gestor.getCursos()) {
            System.out.println("ID: " + curso.getId() + ", Nombre: " + curso.getNombre());
        }

        System.out.println("\nEstudiantes inscritos en cada curso:");
        for (Curso curso : gestor.getCursos()) {
            System.out.println("Curso: " + curso.getNombre());
            ArrayList<Estudiante> inscritos = gestor.getEstudiantesPorCurso(curso.getId());
            if (inscritos.isEmpty()) {
                System.out.println("  No hay estudiantes inscritos.");
            } else {
                for (Estudiante estudiante : inscritos) {
                    System.out.println("  " + estudiante.getNombre() + " " + estudiante.getApellido());
                }
            }
        }

        System.out.println("\nVerificando si Juan Pérez está inscrito en Matemáticas...");
        ArrayList<Estudiante> inscritosMatematicas = gestor.getEstudiantesPorCurso(101);
        if (inscritosMatematicas.contains(est1)) {
            System.out.println("Juan Pérez está inscrito en Matemáticas.");
        } else {
            System.out.println("Juan Pérez NO está inscrito en Matemáticas.");
        }
    }
}
