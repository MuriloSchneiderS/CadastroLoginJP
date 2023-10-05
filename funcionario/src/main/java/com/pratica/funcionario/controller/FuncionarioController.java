package com.pratica.funcionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pratica.funcionario.model.Funcionario;
import com.pratica.funcionario.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
    @Autowired
    FuncionarioRepository repository;

    @GetMapping("/home")
    public String inicio(){
        return "index";
    }
    @PostMapping("/cadastro")
    public String cadastroFuncionario(){
        return "cadastro";
    }
    @PostMapping("/cadastro/funcionario")
    public String cadastro(Funcionario funcionario){
        repository.save(funcionario);
        return "redirect:/lista";
    }
    @GetMapping("/lista")
    public ModelAndView lista(){
        ModelAndView mv = new ModelAndView("lista");
        List<Funcionario> funcionarios;
        funcionarios = repository.findAll();
        mv.addObject("funcionarios", funcionarios);

        return mv;
    }
    @GetMapping("/funcionario/excluir/{id}")
    public String excluir(@PathVariable("id") int num){
        repository.deleteById(num);
        return "redirect:/lista";
    }
    @PostMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login/validar")
    public String validar(Funcionario funcionario){
        
        return "redirect:/lista";
    }
}