package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private ImportanciaService importanciaService;

    @Autowired
    private ContribuyenteService contribuyenteService;

    @RequestMapping("/listado")
    public ModelAndView listaContribuyentes() {
    	ModelAndView mav = new ModelAndView();
        List<Contribuyente> contribuyentes = null;
        
        try {
            contribuyentes = contribuyenteService.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        mav.addObject("contribuyentes", contribuyentes);
        mav.setViewName("listado");
        
        return mav;
    }

    @RequestMapping("/inicio")
    public ModelAndView initMain() {
        ModelAndView mav = new ModelAndView();
        List<Importancia> importancias = new ArrayList<>();
        
        try {
            importancias = importanciaService.findAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        
        mav.addObject("contribuyente", new Contribuyente());
        mav.addObject("importancias", importancias);
        mav.setViewName("index");
        
        return mav;
    }
    
    @RequestMapping("/insertar")
    public ModelAndView insertar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        
        if (result.hasErrors()) {
        	 List<Importancia> importancias = new ArrayList<>();
             
             try {
                 importancias = importanciaService.findAll();
             } catch (DataAccessException e) {
                 e.printStackTrace();
             }
             
             mav.addObject("importancias", importancias);
             mav.setViewName("index");
             
        } else {
        	try {
	            contribuyenteService.save(contribuyente);
	            mav.setViewName("exito");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
        }
        
        return mav;
    }

}
