package com.panpangu.service;

import com.panpangu.dao.JobRepository;
import com.panpangu.model.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lechorage
 */

@Service
public class JobManagerService {

    private static final Logger logger = LoggerFactory.getLogger(JobManagerService.class);

    @Autowired
    private JobRepository repository;

    public List getAllJobs() {
        return repository.getAll();
    }


    public void saveJob(Job Job) {
        logger.info("-------------Service job: " + Job);
        repository.save(Job);

    }

    public void updateJob(Job Job) {
        repository.update(Job);
    }

    public void deleteJob(Long id) {

    }


}
