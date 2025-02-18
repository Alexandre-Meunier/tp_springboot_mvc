package fr.devavance.tp_springboot_mvc_jpa.controllers;

import fr.devavance.tp_springboot_mvc_jpa.beans.Employee;
import fr.devavance.tp_springboot_mvc_jpa.dao.IEmployeeDAO;
import fr.devavance.tp_springboot_mvc_jpa.dao.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeControleur {

    @Autowired
    private IEmployeeRepository emplopyeeDAO;

    public EmployeeControleur(IEmployeeRepository emplopyeeDAO) {
        this.emplopyeeDAO = emplopyeeDAO;
    }

    @RequestMapping("/employees")
    public String findAllEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees",emplopyeeDAO.findAll());
        return "view_employees";
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("employees",emplopyeeDAO.findAll());
        return "view_home";
    }

    @PostMapping("/addemployee")
    public String addEmployee(Employee employee){
        emplopyeeDAO.save(employee);
        return "redirect:/";
    }
}
