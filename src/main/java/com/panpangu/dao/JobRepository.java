package com.panpangu.dao;

import com.panpangu.model.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author lechorage
 */

@Repository
public class JobRepository {

    private static final Logger logger = LoggerFactory.getLogger(JobRepository.class);

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Job job) {
        logger.info("Job repository save Job:" + job);
        EntityManager em = entityManager.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(job);
        em.getTransaction().commit();
        logger.info("entity manager" + entityManager);
    }

    public void update(Job Job) {
        entityManager.merge(Job);
        entityManager.getTransaction().commit();
    }

    @Transactional(readOnly = true)
    public Job get(Long id) {
        logger.info("get Job by id:" + id);
        return entityManager.find(Job.class, id);
    }

    @Transactional(readOnly = true)
    public List getAll() {
        return entityManager.createQuery("select p from Job p").getResultList();
    }

}