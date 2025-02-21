package fr.devavance.tp_springboot_mvc_jpa.controllers;

import fr.devavance.tp_springboot_mvc_jpa.beans.Employee;
import fr.devavance.tp_springboot_mvc_jpa.dao.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeControleur {

    @Autowired
    private IEmployeeRepository employeeRepository;

    public EmployeeControleur(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "view_home";
    }

    @RequestMapping("/employees")
    public String findAllEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("employees", employeeRepository.findAll());
        return "view_employees";
    }

    @RequestMapping("/addemployee")
    public String addEmployee(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/";
    }
}
