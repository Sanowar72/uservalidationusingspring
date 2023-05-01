package com.geekster.JobSearchPortal.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekster.JobSearchPortal.model.Job;
import com.geekster.JobSearchPortal.service.JobService;

@RestController
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    JobService service;


    @GetMapping(value = "/home")
    public String home(){
        return "this is home testing........";
    }
    @PostMapping(value = "/add")
    public String insertJobs(@RequestBody Job job)
    {
        return service.addJob(job);
    }

    @GetMapping(value = "/getJobs")
    public Iterable<Job> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping(value = "/getJob/id/{id}")
    public Optional<Job> getJobById(@PathVariable Long id){
        return service.getJobById(id);
    }

    @DeleteMapping(value = "/delete/id/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteJob(id);
    }

    @GetMapping(value = "/getByTitle/{title}")
    public List<Job> getJobByTitle(@PathVariable String title){
        return service.getJobByTitle(title);
    }

    @GetMapping(value = "/getBySalary/{salary}")
    public List<Job> getJobBySalary(@PathVariable Double salary){
        return service.getJobBySalary(salary);
    }

    @GetMapping(value = "/getByCompanyname/{companyName}")
    public List<Job> getJobByCompanyName(@PathVariable String companyName){
        return service.getJobByCompanyName(companyName);
    }

    @GetMapping(value = "/getJobByName/{companyName}/salary/{salary}")
    public List<Job> getJobByNameOrGreaterThanSalary(@PathVariable String companyName , @PathVariable Double salary){
        return service.getJobByNameOrGreaterThanSalary(companyName,salary);
    }

    @GetMapping(value = "/getJobBySalaryLessThan/{salary}")
    public List<Job> getJobByLessThanSalary(@PathVariable Double salary){
        return service.getJobByLessThanSalary(salary);
    }

    @PutMapping(value = "/updateSalary/{salary}/id/{id}")
    public void updateJobBySalaryById(@PathVariable Double salary, @PathVariable Long id){
        service.updateJobBySalaryById(salary,id);
    }

    @PutMapping(value = "/updateLocation/{salary}/id/{id}")
    public void updateJobByLocationById(@PathVariable String location, @PathVariable Long id){
        service.updateJobByLocationById(location,id);
    }

    @DeleteMapping(value = "/deletejobBySalary/salary/{salary}")
    public void deleteBasedOnSalary(@PathVariable Double salary){
        service.deleteBasedOnSalary(salary);
    }
}
