import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Estudiante>> estudiantesPorCurso;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        estudiantesPorCurso = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            estudiantesPorCurso.put(curso.getId(), new ArrayList<>());
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        ArrayList<Estudiante> inscritos = estudiantesPorCurso.get(idCurso);
        if (inscritos.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        } else {
            inscritos.add(estudiante);
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        ArrayList<Estudiante> inscritos = estudiantesPorCurso.get(idCurso);
        Estudiante estudiante = buscarEstudiantePorId(idEstudiante);
        if (inscritos != null && inscritos.contains(estudiante)) {
            inscritos.remove(estudiante);
        } else {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
        }
    }

    private Estudiante buscarEstudiantePorId(int idEstudiante) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == idEstudiante) {
                return estudiante;
            }
        }
        return null;
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public ArrayList<Estudiante> getEstudiantesPorCurso(int idCurso) {
        return estudiantesPorCurso.get(idCurso);
    }
}
