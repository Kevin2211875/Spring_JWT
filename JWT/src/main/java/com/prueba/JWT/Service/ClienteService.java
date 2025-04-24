package com.prueba.JWT.Service;

import com.prueba.JWT.Model.Cliente;
import com.prueba.JWT.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ClienteService implements ClienteRepository {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Cliente> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Cliente> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Cliente> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Cliente getOne(Integer integer) {
        return null;
    }

    @Override
    public Cliente getById(Integer integer) {
        return null;
    }

    @Override
    public Cliente getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Cliente> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Cliente> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Cliente> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Cliente> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Cliente> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Cliente> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Cliente, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Cliente> S save(S entity) {
        return clienteRepository.save(entity);
    }

    @Override
    public <S extends Cliente> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Cliente> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Cliente entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cliente> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Cliente> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return null;
    }
}
