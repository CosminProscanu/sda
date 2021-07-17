package com.app.component2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

//    //incarcam datele despre angajati
//    private List<Employee> theEmployees;
//
//    @PostConstruct
//    private void loadData(){
//        //cream angajatii
//        Employee emp1 = new Employee(1,"John", "Johnson", "johnjohnson@hgmail.com");
//        Employee emp2 = new Employee(2,"John", "John", "johnjohnson@hgmail.com");
//        Employee emp3 = new Employee(3,"John", "Jo", "johnjohnson@hgmail.com");
//        //cream lista
//        theEmployees = new ArrayList<>();
//        //adaugam in lista
//        theEmployees.add(emp1);
//        theEmployees.add(emp2);
//        theEmployees.add(emp3);
//    }

    private EmployeeService employeeService;


    public EmployeeController (EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //adaugam mapare pt "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel){

        List<Employee> theEmployees = employeeService.findAll();

        //adaugam in spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee employee = new Employee();

        //adaugam in spring model
        theModel.addAttribute("employee", employee);

        return "employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "list-employees";
    }

    @PostMapping("/foo")
    public String saveEmployeeAndOtherObject(@ModelAttribute("employee") Employee employee,
                                             @ModelAttribute("empDetails") EmployeeDetails employeeDetails){
        employee.setEmployeeDetails(employeeDetails);
        employeeService.save(employee);
        return "list-employees";
    }

    @GetMapping("/showFormForAddMultiple")
    public String showFormForAddMultipleObjs(Model theModel){
        Employee employee = new Employee();
        EmployeeDetails employeeDetails = new EmployeeDetails();

        //adaugam in spring model
        theModel.addAttribute("employee", employee);
        theModel.addAttribute("empDetails",employeeDetails);

        return "test-add-multiple-objects";
    }


}
