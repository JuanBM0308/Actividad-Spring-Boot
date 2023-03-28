package com.example.ActividadClase.Servicios;

import com.example.ActividadClase.Entidades.Estudiante;
import java.util.ArrayList;

public class ServicioEstudiantes {

    private ArrayList<Estudiante> lista_estudiantes = new ArrayList<>();

    public ServicioEstudiantes(){
        lista_estudiantes.add(new Estudiante(001,"Camila","Garzon", new String[]{"Matemáticas","Español","Química"},new float[]{2.2f,3.7f,5.0f}));
        lista_estudiantes.add(new Estudiante(002,"Carlos","Roldan", new String[]{"Ingles","Frances","Chino"},new float[]{4.8f,4.0f,4.0f}));
        lista_estudiantes.add(new Estudiante(003,"Fernando","Aguilar", new String[]{"Física","Mecanica","Aviación"},new float[]{4.8f,3.5f,4.2f}));
    }

    public ArrayList<Estudiante> ListarEstudiante(){
        return lista_estudiantes;
    }

    public String AgregarEstudiantes(Estudiante est){
        lista_estudiantes.add(est);
        return "Estudiante agregado con exito!";
    }

    public String PromedioEstudiante(int codigo){
        String val = "Estudiante no encontrado";
        for (Estudiante e:lista_estudiantes) {
            if (e.getCodigo()==codigo){
                float promedio = 0.0f;
                float sum = 0.0f;
                for (int i=0;i<lista_estudiantes.size();i++){
                    for (int x=0;x<e.getNotas().length;x++){
                        sum+=e.getNotas()[x];
                    }
                    promedio=sum/9;
                    e.setPromedio(promedio);
                    val="Promedio del estudiante: "+e.getPromedio();
                }
            }
        }
        return val;
    }
}
