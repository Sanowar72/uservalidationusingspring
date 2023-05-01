package com.geekster.JobSearchPortal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geekster.JobSearchPortal.model.Job;

@Repository
public interface JobRepository extends CrudRepository<Job,Long>{

    public List<Job> findByTitle(String title);

    public List<Job> findBySalaryGreaterThan(Double salary);

    public List<Job> findByCompanyName(String companyName);

    public List<Job> findByCompanyNameOrSalaryGreaterThan(String companyName,Double salary);

    @Query(value = "select * from JOB where SALARY <= :salary", nativeQuery = true)
    List<Job> getAllJobLessThanSalary(Double salary);

    @Modifying
    @Query(value = "update JOB set salary = :salary where ID = :id",nativeQuery = true)
    void updateJobByIdForSalary(Double salary,Long id);

    @Modifying
    @Query(value = "update JOB set location = :location where ID = :id",nativeQuery = true)
    void updateJobByIdForLocation(String location,Long id);

    @Modifying
    @Query(value = "Delete from JOB where salary<= :salary" , nativeQuery = true)
    void deleteJobBasedOnSalary(Double salary);


}