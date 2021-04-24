package com.example.mercadolivre.validadores;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidarCamposDuplicadosValidator implements ConstraintValidator<ValidarCamposDuplicados, Object> {
    private String campo;
    private Class<?> aClass;
    private EntityManager entityManager;

    public ValidarCamposDuplicadosValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(ValidarCamposDuplicados parameter) {
        this.campo = parameter.atributo();
        this.aClass = parameter.aClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery(
                "SELECT r FROM " + aClass.getName() + " r WHERE r." + campo
                        + " = :pValor")
                .setParameter("pValor", value);
        List<String> lista = query.getResultList();

        return lista.isEmpty();
    }
}