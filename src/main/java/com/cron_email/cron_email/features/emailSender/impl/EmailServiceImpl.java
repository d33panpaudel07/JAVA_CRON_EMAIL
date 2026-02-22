package com.cron_email.cron_email.features.emailSender.impl;

import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.features.emailSender.dto.EmailDetailsDto;
import com.cron_email.cron_email.features.emailSender.service.EmailService;
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
    public InternalResponse<?> sendEmail(EmailDetailsDto emailDetailsDto) {
        log.info("Sending email to {}", emailDetailsDto.getRecipient());
        try {
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(senderEmail);
            mailMessage.setTo(emailDetailsDto.getRecipient());
            mailMessage.setText(emailDetailsDto.getMsgBody());
            mailMessage.setSubject(emailDetailsDto.getSubject());

            javaMailSender.send(mailMessage);
            return InternalResponse.successResponse(true);
        } catch (Exception e) {
            log.error("Error while sending email\n Message: {}", e.getMessage());
            return InternalResponse.errorResponse(e.getMessage(), false);
        }

    }

    @Override
    public InternalResponse<?> sendEmailWithAttachment(EmailDetailsDto emailDetailsDto) {
        log.info("Sending email with attachment to {}", emailDetailsDto.getRecipient());
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(senderEmail);
            mimeMessageHelper.setTo(emailDetailsDto.getRecipient());
            mimeMessageHelper.setText(emailDetailsDto.getMsgBody());
            mimeMessageHelper.setSubject(
                    emailDetailsDto.getSubject());

            FileSystemResource file
                    = new FileSystemResource(
                    new File(emailDetailsDto.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            javaMailSender.send(mimeMessage);
            return InternalResponse.successResponse(true);
        }

        catch (MessagingException e) {
            log.error("Error while sending email with attachment \n Message: {}", e.getMessage());
            return InternalResponse.errorResponse(true);
        }
    }
}
