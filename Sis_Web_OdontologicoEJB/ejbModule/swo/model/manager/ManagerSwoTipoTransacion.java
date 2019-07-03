package swo.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import swo.model.entities.SwoTipoTransaccion;

/**
 * Session Bean implementation class ManagerSwoTipoTransacion
 */
@Stateless
@LocalBean
public class ManagerSwoTipoTransacion {
	@PersistenceContext(unitName="bddswoDS")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerSwoTipoTransacion() {
        // TODO Auto-generated constructor stub
    }
    public List<SwoTipoTransaccion> findAllTipoTransaccion(){
    	List<SwoTipoTransaccion> listaTipoTransaccion=em.createQuery("SELECT t FROM SwoTipoTransaccion t").getResultList();
    	return listaTipoTransaccion;
    }
    public SwoTipoTransaccion findOneTipoTransaccion(int codigoTipoTrans) {
    	SwoTipoTransaccion tipo=em.find(SwoTipoTransaccion.class, codigoTipoTrans);
    	return tipo;
    }
    public void insertTipoTransaccion(SwoTipoTransaccion tipoNuevo) {
    	em.persist(tipoNuevo);
    }
    public void deleteTipoTransaccion(int codigoTipoTrans) {
    	SwoTipoTransaccion tipo=em.find(SwoTipoTransaccion.class, codigoTipoTrans);
    	em.remove(tipo);
    }
    public void updateTipoTransaccion(SwoTipoTransaccion tipoAc, int codigoTipoTrans) {
    	SwoTipoTransaccion tipo=em.find(SwoTipoTransaccion.class, codigoTipoTrans);
    	tipo.setTipoTrans(tipoAc.getTipoTrans());
    	tipo.setDescripcionTrans(tipoAc.getDescripcionTrans());
    	em.merge(tipo);
    }
}
