package com.prueba.JWT.Service;

import com.prueba.JWT.Model.Producto;
import com.prueba.JWT.Repository.ProductoRepository;
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
public class ProductoService implements ProductoRepository {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Producto> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Producto> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Producto> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Producto getOne(Integer integer) {
        return null;
    }

    @Override
    public Producto getById(Integer integer) {
        return null;
    }

    @Override
    public Producto getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Producto> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Producto> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Producto> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Producto> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Producto> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Producto> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Producto, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Producto> S save(S entity) {
        return productoRepository.save(entity);
    }

    @Override
    public <S extends Producto> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Producto> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> findAllById(Iterable<Integer> integers) {
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
    public void delete(Producto entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Producto> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Producto> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Producto> findAll(Pageable pageable) {
        return null;
    }
}
