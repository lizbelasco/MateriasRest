/**
 * 
 */
package com.soa.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soa.dto.Alumno;
import com.soa.dto.Request;
import com.soa.dto.Response;

/**
 * 
 */
@RestController
public class MateriasRest {
    
    @PostMapping("/materia")
    public ResponseEntity<Response> consultar(@RequestBody Request request) {
        Response response = new Response();
        Alumno alumno = new Alumno();
        Map<String, Double> materia = new HashMap<String, Double>();

        materia.put("programacion", 90.0);
        materia.put("soa", 100.0);
        materia.put("estructuraDatos", 65.0);
        alumno.setMaterias(materia);
        
        double promedio = calcularPromedio(materia);
        
        response.setPorcentaje(promedio);
        
        ResponseEntity<Response> re = new ResponseEntity<>(response, HttpStatus.OK);
        return re;
    }
    
    private static double calcularPromedio(Map<String, Double> materia) {
        // Verificar si el mapa está vacío
        if (materia.isEmpty()) {
            return 0.0; // o podrías lanzar una excepción o manejarlo de alguna otra manera según tus necesidades
        }

        // Calcular la suma de los valores
        double suma = 0.0;
        for (double valor : materia.values()) {
            suma += valor;
        }

        // Calcular el promedio
        return suma / materia.size();
    }
}
