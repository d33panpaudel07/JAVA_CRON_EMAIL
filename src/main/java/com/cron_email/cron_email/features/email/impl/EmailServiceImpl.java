package com.cron_email.cron_email.features.email.impl;

import com.cron_email.cron_email.core.dto.ServerResponse;
import com.cron_email.cron_email.features.email.dto.EmailDetails;
import com.cron_email.cron_email.features.email.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/8/2026
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String senderEmail;

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public ServerResponse<?> sendEmail(EmailDetails emailDetails) {
        log.info("Sending email to {}", emailDetails.getRecipient());
        try {
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(senderEmail);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setText(emailDetails.getMsgBody());
            mailMessage.setSubject(emailDetails.getSubject());

            javaMailSender.send(mailMessage);
            return ServerResponse.successResponse(true);
        } catch (Exception e) {
            log.error("Error while sending email\n Message: {}", e.getMessage());
            return ServerResponse.errorResponse(e.getMessage(), false);
        }

    }

    @Override
    public ServerResponse<?> sendEmailWithAttachment(EmailDetails emailDetails) {
        log.info("Sending email with attachment to {}", emailDetails.getRecipient());
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(senderEmail);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setText(emailDetails.getMsgBody());
            mimeMessageHelper.setSubject(
                    emailDetails.getSubject());

            FileSystemResource file
                    = new FileSystemResource(
                    new File(emailDetails.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            javaMailSender.send(mimeMessage);
            return ServerResponse.successResponse(true);
        }

        catch (MessagingException e) {
            log.error("Error while sending email with attachment \n Message: {}", e.getMessage());
            return ServerResponse.errorResponse(true);
        }
    }
}
