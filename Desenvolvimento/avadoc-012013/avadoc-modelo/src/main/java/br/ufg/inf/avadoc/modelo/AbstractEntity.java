package br.ufg.inf.avadoc.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
 
/**
 * Entidade abstrata para persistência
 *
 */
@MappedSuperclass
public class AbstractEntity {
    private Long id;
 
    /**
     * Retorna id da entidade
     * @return
     */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
 
    /**
     * Altera id da entidade
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
}