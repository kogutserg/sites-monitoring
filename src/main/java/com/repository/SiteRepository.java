package com.repository;

import com.entity.Site;
import org.springframework.data.repository.CrudRepository;

public interface SiteRepository extends CrudRepository<Site, Integer> {
    Iterable<Site> findByUserId(Long userId);
    Iterable<Site> findByStatus(int status);
    Site findById(Long Id);
}
