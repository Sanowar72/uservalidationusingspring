package com.geekster.JobSearchPortal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.JobSearchPortal.repo.JobRepository;
import com.geekster.JobSearchPortal.model.Job;

import jakarta.transaction.Transactional;

@Service
public class JobService {

    @Autowired
    JobRepository jobrepo;

    public String addJob(Job job) {
        jobrepo.save(job);
        return "added";
    }

    public Iterable<Job> getAllJobs() {
        return jobrepo.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobrepo.findById(id);
    }

    public void deleteJob(Long id) {
        jobrepo.deleteById(id);
    }

    public List<Job> getJobByTitle(String title) {
        return jobrepo.findByTitle(title);
    }

    public List<Job> getJobBySalary(Double salary) {
        return jobrepo.findBySalaryGreaterThan(salary);
    }

    public List<Job> getJobByCompanyName(String companyName) {
        return jobrepo.findByCompanyName(companyName);
    }

    public List<Job> getJobByNameOrGreaterThanSalary(String companyName, Double salary) {
        return jobrepo.findByCompanyNameOrSalaryGreaterThan(companyName, salary);
    }

    public List<Job> getJobByLessThanSalary(Double salary) {
        return jobrepo.getAllJobLessThanSalary(salary);
    }

    @Transactional
    public void updateJobBySalaryById(Double salary, Long id) {
        jobrepo.updateJobByIdForSalary(salary, id);;
    }

    @Transactional
    public void updateJobByLocationById(String location, Long id){
        jobrepo.updateJobByIdForLocation(location, id);
    }

    public void deleteBasedOnSalary(Double salary){
        jobrepo.deleteJobBasedOnSalary(salary);
    }
}
