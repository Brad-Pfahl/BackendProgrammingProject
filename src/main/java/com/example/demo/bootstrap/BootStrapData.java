package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // For deletion between test-runs. Step I requires data to carry through runs therefore it is commented out
        // customerRepository.deleteAll();

        Division testDivision = new Division();
        testDivision.setCountry_ID(Long.valueOf("1"));
        testDivision.setDivision_name("Testville");

        divisionRepository.save(testDivision);

        Customer customer1 = new Customer();
        customer1.setFirstName("Tom");
        customer1.setLastName("Tomson");
        customer1.setAddress("101 Main Street");
        customer1.setPostal_code("11111");
        customer1.setPhone("111-111-1111");
        customer1.setDivision(testDivision);
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Richard");
        customer2.setLastName("Richardson");
        customer2.setAddress("102 Main Street");
        customer2.setPostal_code("11111");
        customer2.setPhone("222-222-2222");
        customer2.setDivision(testDivision);
        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Larry");
        customer3.setLastName("Larryson");
        customer3.setAddress("103 Main Street");
        customer3.setPostal_code("11111");
        customer3.setPhone("333-333-3333");
        customer3.setDivision(testDivision);
        customerRepository.save(customer3);

        Customer customer4 = new Customer();
        customer4.setFirstName("George");
        customer4.setLastName("Costanza");
        customer4.setAddress("104 Main Street");
        customer4.setPostal_code("11111");
        customer4.setPhone("444-444-4444");
        customer4.setDivision(testDivision);
        customerRepository.save(customer4);

        Customer customer5 = new Customer();
        customer5.setFirstName("Art");
        customer5.setLastName("Vandelay");
        customer5.setAddress("105 Main Street");
        customer5.setPostal_code("11111");
        customer5.setPhone("555-555-5555");
        customer5.setDivision(testDivision);
        customerRepository.save(customer5);

    }
}
