package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO {

    @PersistenceContext(unitName = "labo6")
    private EntityManager entityManager;

    @Override
    public List<Importancia> findAll() throws DataAccessException {
    	// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.importancia");
		
		Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia> importancia = query.getResultList();
		
		return importancia;
    }
}
