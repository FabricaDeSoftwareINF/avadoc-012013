package br.ufg.inf.avadoc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufg.inf.avadoc.modelo.Docente;

@Repository
public class DocenteDAO {
	private final GenericDAO<Docente> dao;
	
    @Autowired
    public DocenteDAO(final SessionFactory factory) {
        dao  = new GenericDAO<Docente>(factory, Docente.class);	
    }
    
    @Transactional(readOnly = true)
    public List<Docente> lista() {
        return dao.lista();
    }
 
    @Transactional
    public void adiciona(final Docente docente) {
        dao.adiciona(docente);
    }
}
