package com.panpangu.controller;

import com.panpangu.model.Job;
import com.panpangu.service.JobManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

/**
 * @author lechorage
 */

@Controller
@RequestMapping("/job/")
public class JobController {

    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @Inject
    public JobManagerService managerService;

    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public ModelAndView editPerson(@RequestParam(value = "Job", required = false) Job Job) {
        logger.debug("Received request to edit person id : ");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit");
        if (Job == null) {
            Job = new Job();
        }
        mav.addObject("Job", Job);
        return mav;
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView getJobById(@PathVariable Long id) {
        logger.info("Get Job by id : " + id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit");
        Job Job;
        if (id == null) {
            Job = new Job();
        } else {
            Job = new Job();
        }
        mav.addObject("job", Job);
        return mav;
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView getJobs() {
        List JobList = managerService.getAllJobs();
        ModelAndView mv = new ModelAndView();
        mv.addObject("jobs", JobList);
        mv.setViewName("list");
        logger.info("requesting /Job");
        return mv;
    }


    @RequestMapping(method = RequestMethod.POST)
    public String addJob(@ModelAttribute("Job") Job Job) {
        logger.info("Received post back on Job " + Job);
        managerService.saveJob(Job);
        logger.info("POSSSSSSSTTT");
        return "redirect:list";

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteJob(@PathVariable Long id) {
        logger.info("DELETEEEEE ");
        return "redirect:list";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateJob() {
        logger.info("PUTTTTTT ");
        return "redirect:list";
    }


}
