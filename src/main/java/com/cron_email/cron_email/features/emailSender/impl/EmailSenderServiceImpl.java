package com.cron_email.cron_email.features.emailSender.impl;

import com.cron_email.cron_email.core.dto.InternalResponse;
import com.cron_email.cron_email.core.exception.BusinessException;
import com.cron_email.cron_email.core.exception.ResourceNotFoundException;
import com.cron_email.cron_email.features.emailSender.dto.EmailSenderDto;
import com.cron_email.cron_email.features.emailSender.entity.EmailSender;
import com.cron_email.cron_email.features.emailSender.mapper.EmailSenderMapper;
import com.cron_email.cron_email.features.emailSender.repository.EmailSenderRepo;
import com.cron_email.cron_email.features.emailSender.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author d33pan on 2/16/2026
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private final EmailSenderRepo emailSenderRepo;

    @Override
    public InternalResponse<?> createEmailSender(EmailSenderDto emailSenderDto) {

        EmailSender incomingEmailSender = EmailSenderMapper.toEntity(emailSenderDto, new EmailSender());

        if (incomingEmailSender == null) {
            throw new BusinessException("EmailSenderDto is null");
        }

        EmailSender savedEmailSender = emailSenderRepo.save(incomingEmailSender);

        return InternalResponse.successResponse(
                "Email added successfully!",
                EmailSenderMapper.toDto(savedEmailSender, new EmailSenderDto())
        );
    }

    @Override
    public InternalResponse<?> readEmailSenderById(Long id) {
        Optional<EmailSender> emailSenderOpt = emailSenderRepo.getByIdAndStatus(id, 'Y');

        if (emailSenderOpt.isEmpty()) {
            log.error("EmailSender with id {} not found!", id);
            throw new ResourceNotFoundException("EmailSender with id " + id + " not found!");
        }

        EmailSender emailSender = emailSenderOpt.get();

        return InternalResponse.successResponse("EmailSender fetched successfully!", emailSender);
    }

    @Override
    public InternalResponse<?> readAllEmail() {
        List<EmailSender> emailSendersList = emailSenderRepo.getAllByStatus('Y');

        List<EmailSenderDto> emailSenderDtoList = emailSendersList.stream()
                .map(emailSender -> EmailSenderMapper.toDto(emailSender, new EmailSenderDto()))
                .toList();

        return InternalResponse.successResponse("EmailSenders fetched successfully!", emailSenderDtoList);
    }

    @Override
    public InternalResponse<?> updateEmailSender(Long id, EmailSenderDto emailSenderDto) {

        Optional<EmailSender> emailSenderOpt = emailSenderRepo.getByIdAndStatus(id, 'Y');

        if (emailSenderOpt.isEmpty()) {
            log.error("EmailSender with id {} not found!", emailSenderDto.getId());
            throw new ResourceNotFoundException("No Active EmailSender with id " + emailSenderDto.getId() + " was found!");
        }

        EmailSender emailSender = emailSenderOpt.get();
        EmailSenderMapper.toEntity(emailSenderDto, emailSender);
        emailSenderRepo.save(emailSender);

        EmailSenderMapper.toDto(emailSender, new EmailSenderDto());

        return InternalResponse.successResponse("EmailSender updated successfully!", emailSender);
    }

    @Override
    public InternalResponse<?> disableEmailSender(Long id) {
        Optional<EmailSender> emailSenderOpt = emailSenderRepo.getByIdAndStatus(id, 'Y');

        if (emailSenderOpt.isEmpty()) {
            log.error("EmailSender with id {} not found!", id);
            throw new ResourceNotFoundException("No Active EmailSender with id " + id + " was found!");
        }

        EmailSender emailSender = emailSenderOpt.get();
        emailSender.setIsActive('N');
        emailSenderRepo.save(emailSender);

        EmailSenderMapper.toDto(emailSender, new EmailSenderDto());

        return InternalResponse.successResponse("EmailSender deleted successfully!", emailSender);
    }
}
