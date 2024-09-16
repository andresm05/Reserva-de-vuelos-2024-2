package com.udea.reservaVuelos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public abstract class ImpGenericRepository<T, ID> implements GenericRepository<T, ID>{
    @Autowired
    private JpaRepository<T, ID> jpaRepository;

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }
}
