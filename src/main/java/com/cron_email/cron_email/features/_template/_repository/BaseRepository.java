package com.cron_email.cron_email.features._template._repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
    Optional<T> findByIdAndStatus(ID id, Character status);
    List<T> findAllByStatusAndInsideList(Character status, List<ID> ids);
}
