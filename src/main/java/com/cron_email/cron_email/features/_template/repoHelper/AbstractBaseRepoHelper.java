package com.cron_email.cron_email.features._template.repoHelper;

import com.cron_email.cron_email._core.exception.ResourceNotFoundException;
import com.cron_email.cron_email.features._template._repository.BaseRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class AbstractBaseRepoHelper<T, ID> {

    protected abstract BaseRepository<T, ID> getRepository();

    @Transactional
    public T save(T entity) {
        log.info("Saving entity: {}", entity);
        return getRepository().save(entity);
    }

    @Transactional
    public void enableById(ID id) {
        T entity = getRepository().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getEntityName(), "id", id));
        setActive(entity, true);
    }

    @Transactional
    public void disableById(ID id) {
        T entity = getRepository().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getEntityName(), "id", id));
        setActive(entity, false);
    }

    @Transactional
    public void enableAllById(List<ID> ids) {
        List<T> list = getRepository().findAllByStatusAndInsideList('N', ids);
        list.forEach(e -> setActive(e, true));
    }

    @Transactional
    public void disableAllById(List<ID> ids) {
        List<T> list = getRepository().findAllByStatusAndInsideList('Y', ids);
        list.forEach(e -> setActive(e, false));
    }

    public Optional<T> findByIdAndStatus(ID id, Character status) {
        Optional<T> entityOpt = getRepository().findByIdAndStatus(id, status);
        if (entityOpt.isEmpty()) {
            displayMissingLog(id);
        }
        return entityOpt;
    }

    protected abstract void setActive(T entity, boolean active);

    protected abstract void displayMissingLog(ID id);

    protected abstract String getEntityName();
}
