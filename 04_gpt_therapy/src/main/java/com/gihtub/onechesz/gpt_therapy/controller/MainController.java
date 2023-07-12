package com.gihtub.onechesz.gpt_therapy.controller;

import com.gihtub.onechesz.gpt_therapy.entities.EmailsEntity;
import com.gihtub.onechesz.gpt_therapy.services.EmailService;
import com.gihtub.onechesz.gpt_therapy.services.EmailsService;
import com.gihtub.onechesz.gpt_therapy.util.api_models.JsonGptAnswer;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "")
public class MainController {
    private final EmailsService emailsService;
    private final EmailService emailService;

    public MainController(EmailsService emailsService, EmailService emailService) {
        this.emailsService = emailsService;
        this.emailService = emailService;
    }

    @GetMapping(path = "")
    public String indexView(@NotNull HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getSession().getAttribute("emails_entity") != null)
            return "redirect:/answer";

        return "main/index";
    }

    @PostMapping(path = "/ask")
    public String questionProcessing(@NotNull HttpServletRequest httpServletRequest, @RequestParam(name = "story") String story) throws InterruptedException {
        EmailsEntity emailsEntity = emailsService.saveAndRetrieveEntity(story);

        emailsService.sendApiRequestAndUpdateDatabase(emailsEntity, story);
        httpServletRequest.getSession().setAttribute("emails_entity", emailsEntity);

        return "redirect:/thank-you";
    }

    @GetMapping(path = "/thank-you")
    public String thankView(@NotNull HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getSession().getAttribute("emails_entity") != null)
            return "main/thank-you";

        return "redirect:/";
    }

    @GetMapping(path = "/answer")
    public String answerView(@NotNull HttpServletRequest httpServletRequest, Model model) {
        EmailsEntity emailsEntity = (EmailsEntity) httpServletRequest.getSession().getAttribute("emails_entity");

        if (emailsEntity != null) {
            emailsService.findById(emailsEntity.getId()).ifPresent(updatedEmailsEntity -> {
                if (updatedEmailsEntity.getGptAnswer() != null)
                    model.addAttribute("gpt_answer", new Gson().fromJson(updatedEmailsEntity.getGptAnswer(), JsonGptAnswer.class).getReply());
            });

            return "main/answer";
        }

        return "redirect:/";
    }

    @PostMapping(path = "/leave-email")
    public String sendInstructionWithEmailProcessing(@NotNull HttpServletRequest httpServletRequest, @RequestParam(name = "email") String email) {
        emailService.sendMailTo(email, "Instruction.");
        httpServletRequest.getSession().removeAttribute("emails_entity");

        return "redirect:/";
    }
}
