package swo.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import swo.model.entities.SwoDiente;

/**
 * Session Bean implementation class ManagerDientes
 */
@Stateless
@LocalBean
public class ManagerSwoDiente {
@PersistenceContext
private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ManagerSwoDiente() {
   
    	
    }
    // Método que retorna la lista de  la tabla Dientes
    public List<SwoDiente> findAllDientes(){
    	String consulta=("SELECT s FROM SwoDiente s");
    	Query q=em.createQuery(consulta,SwoDiente.class);
    	return q.getResultList();
    }
    // método de busqueda para el diente
    public SwoDiente findSwoDienteBycodigodie(Integer codigo_die)
    {
  	  return em.find(SwoDiente.class, codigo_die);
  	  
    }
  //para actualizar
    public void actualizarSwoDiente(SwoDiente diente) throws Exception {
  	  SwoDiente e=findSwoDienteBycodigodie(diente.getCodigoDie());
  	  if(e==null)
  		  throw new Exception("No existe el Diente con la código especificado");
  	  e.setNumeroDie(diente.getNumeroDie());
  	  e.setNombreDie(diente.getNombreDie());
  	  e.setEstadoDie(diente.getEstadoDie());
  	 e.setDescripcionDie(diente.getDescripcionDie());
  	  em.merge(e);
  	  
  	  
    }
}