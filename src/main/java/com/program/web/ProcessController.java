package com.program.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.program.bean.RequestBean;
import com.program.bean.ResponseBean;
import com.program.service.IProgrammingService;

/**
 * 
 * Controller class to sort the words
 *
 */
@Controller
public class ProcessController {

    private final Logger logger = LoggerFactory.getLogger(ProcessController.class);

    @Autowired
    private IProgrammingService service;

    /**
     * Handles the default URL
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/*"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "redirect:/home";
    }

    /**
     * Displays the home page
     * 
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String displayHomePage(Model model, HttpServletRequest request) {
        RequestBean bean = new RequestBean();

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        // Check if the command object is present as part of previous request
        if (inputFlashMap != null) {
            Object command = inputFlashMap.get("command");
            if (command != null) {
                bean = (RequestBean) command;
            }
        }
        model.addAttribute("command", bean);
        return "process";
    }

    /**
     * Handles the processing logic uing the service class
     * 
     * @param input
     * @param redirect
     * @return
     */
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String sortWords(String input, RedirectAttributes redirect) {
        logger.debug("procesing for input : {}", input);

        ResponseBean response = service.processData(input);
        redirect.addFlashAttribute("response", response);
        redirect.addFlashAttribute("command", new RequestBean(input));
        return "redirect:/home";
    }
}