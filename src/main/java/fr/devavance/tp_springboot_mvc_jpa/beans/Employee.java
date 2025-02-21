package fr.devavance.tp_springboot_mvc_jpa.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
