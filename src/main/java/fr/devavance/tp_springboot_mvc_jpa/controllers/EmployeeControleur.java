package fr.devavance.tp_springboot_mvc_jpa.controllers;

import fr.devavance.tp_springboot_mvc_jpa.beans.Employee;
import fr.devavance.tp_springboot_mvc_jpa.dao.IEmployeeController;
import fr.devavance.tp_springboot_mvc_jpa.dao.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeControleur implements IEmployeeController{

    @Autowired
    private IEmployeeRepository employeeRepository;

    public EmployeeControleur(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping
    public String findAllEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("employees", employeeRepository.findAll());
        return "view_home";
    }

    @GetMapping("/home")
    public String displayHome(Model model) {
        model.addAttribute("employee",new Employee());
        model.addAttribute("employees", employeeRepository.findAll());
        return "view_home";
    }

    @PostMapping("/addemployee")
    public String addEmployee(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employee/home";
    }

    @Override
    @RequestMapping(value = "/{id}")
    public String displayEmployee(@PathVariable(name="id") Long id, Model model) {

        model.addAttribute("employee", employeeRepository.findById(id));

        return "view_employee";

    }
}
