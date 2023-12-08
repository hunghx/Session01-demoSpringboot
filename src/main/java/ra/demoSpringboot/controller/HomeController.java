package ra.demoSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.demoSpringboot.dto.CustomerResponse;
import ra.demoSpringboot.model.Customer;
import ra.demoSpringboot.repository.ICustomerRepository;


import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ICustomerRepository customerRepository;
    @RequestMapping("/add")
    public String home(){
        Customer c = new Customer(7L,"Nguyễn Văn C","0978493575",true,new Date(),"A001");
        customerRepository.save(c);
        return "home";
    }
    @RequestMapping("/delete/{id}")
    public String home(@PathVariable Long id){
        customerRepository.deleteById(id);
        return "home";
    }
    @RequestMapping("/search/{name}")
    public String home(@PathVariable String name){
        List<CustomerResponse> customers= customerRepository.findCustomersWithAddress();
        long count  = customerRepository.countCustomerBySex(true);
        long cou1  = customerRepository.countCustomerBySex(false);
        return "home";
    }

}
