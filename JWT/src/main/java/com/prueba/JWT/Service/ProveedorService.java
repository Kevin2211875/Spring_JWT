package com.prueba.JWT.Service;

import com.prueba.JWT.Model.Proveedor;
import com.prueba.JWT.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ProveedorService implements ProveedorRepository {

    @Autowired
    private ProveedorRepository proveedorRepository;


    @Override
    public void flush() {

    }

    @Override
    public <S extends Proveedor> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Proveedor> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Proveedor> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Proveedor getOne(Integer integer) {
        return null;
    }

    @Override
    public Proveedor getById(Integer integer) {
        return null;
    }

    @Override
    public Proveedor getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Proveedor> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Proveedor> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Proveedor> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Proveedor> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Proveedor> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Proveedor> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Proveedor, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Proveedor> S save(S entity) {
        return proveedorRepository.save(entity);
    }

    @Override
    public <S extends Proveedor> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Proveedor> findById(Integer id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public List<Proveedor> findAllById(Iterable<Integer> integers) {
        return proveedorRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public void delete(Proveedor entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Proveedor> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Proveedor> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Proveedor> findAll(Pageable pageable) {
        return null;
    }
}
