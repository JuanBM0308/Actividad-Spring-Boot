package com.example.ActividadClase.Controladores;

import com.example.ActividadClase.Entidades.Estudiante;
import com.example.ActividadClase.Servicios.ServicioEstudiantes;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControladorEstudiantes {

    ServicioEstudiantes servicio = new ServicioEstudiantes();

    @GetMapping("/ListaDeEstudiantes")
    public ArrayList<Estudiante> lista_estudiantes() {
        return servicio.ListarEstudiante();
    }

    @PostMapping("/AgregarEstudiantes")
    public String agregar_estudiantes(@RequestBody Estudiante estu) {
        return servicio.AgregarEstudiantes(estu);
    }

    @GetMapping("/PromedioNotas/{code}")
    public String promedio_estudiante(@PathVariable("code") int code){
        return servicio.PromedioEstudiante(code);
    }
}
