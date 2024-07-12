package edu.ar.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ar.data.AutomovilDAO;
import edu.ar.model.Auto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

@WebServlet("/cars")
public class AutoServletController extends HttpServlet {

  static Logger logger = LoggerFactory.getLogger(AutoServletController.class);
  List<Auto> autoList = new ArrayList<>();
  ObjectMapper mapper = new ObjectMapper();


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String route = req.getParameter("action");
    logger.info("route : " + route);
    switch (route) {
      case "getAll"-> {
        res.setContentType("application/json; charset=UTF-8");
        autoList = AutomovilDAO.obtener();
        logger.info("Dentro de getAll : " + autoList.size());
        //transformo en json y lo envio
        mapper.writeValue(res.getWriter(), autoList);
        logger.info(mapper.toString());
      }
      
      default -> {
        System.out.println("Parámetro no válido");
      }
    }
  }

  
  //En el doPost enviamos los datos del formulario (Postman por el momento...) a Java para que los inserte en la base de datos.
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    
    String route = req.getParameter("action");
    logger.info("Dentro del doPost() - route= " + route);

    switch(route) {
      case "add"-> {
        res.setContentType("application/json; charset=UTF-8");

        // Cargo el request
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
          buffer.append(line);
          buffer.append(System.lineSeparator());
        }
        String data = buffer.toString();
        logger.info("DATA=" + data);
    
        // Uso la librería Gson para convertirlo a Json
        Gson gson = new Gson();
        Auto newAuto = gson.fromJson(data, Auto.class);
      
        logger.info("Voy a insertar:");
        logger.info("DATA idMarca : " + newAuto.getIdMarca());
        logger.info("DATA idModelo : " + newAuto.getIdModelo());
        logger.info("DATA version : " + newAuto.getVersion());
        logger.info("DATA anio : " + newAuto.getAnio());
        logger.info("DATA chasis : " + newAuto.getChasis());
        logger.info("DATA motor : " + newAuto.getMotor());
        logger.info("DATA idColor : " + newAuto.getIdColor());

        //try {
          AutomovilDAO.insertar(newAuto);
        //} catch (SQLException e) {
        //  e.printStackTrace();
        //}

        Map<String, String> response = new HashMap();
        response.put("message", "Auto guardado exitosamente !!!");
        mapper.writeValue(res.getWriter(), response);

      }
    }
  }

}

