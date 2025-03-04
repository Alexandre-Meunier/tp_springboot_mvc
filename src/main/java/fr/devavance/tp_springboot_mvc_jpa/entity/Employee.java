package fr.devavance.tp_springboot_mvc_jpa.entity;

import fr.devavance.tp_springboot_mvc_jpa.enumeration.Fonction;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name="employee"
)
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    private String address;
    
    private String email;
    
    private String phone;

    private Fonction fonction;

    public Employee(String name, String address, String email, String phone, Fonction fonction) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.fonction = fonction;
    }

    public Employee() {

    }
}
