package servicio;

import dominio.Participante;
import dto.ParticipanteDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;


@Stateless
public class MaratonService {

    @PersistenceContext
    private EntityManager em;

    public void agregarParticipante(ParticipanteDTO dto) throws ServicioException {
        Participante bd = buscarParticipantePorId(dto.getId());
        if (bd != null) {
            throw new ServicioException("Ya existe un participante con el ID: " + dto.getId());
        }

        // convertir el DTO en Entity
        Participante p = new Participante();
        p.setId(dto.getId());
        p.setNombre(dto.getNombre());
        p.setSexo(dto.getSexo());
        p.setDistancia(dto.getDistancia());
        p.setCategoria(dto.getCategoria());

        // persistir el Entity
        em.persist(p);
    }

    public Participante buscarParticipantePorId(int id) {
        Participante p = null;
        try {
            p = em.createNamedQuery("Participante.findById", Participante.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException ex) {
            // no se encontró el participante
            p = null;
        } catch (NonUniqueResultException ex) {
          throw ex;
        }
        return p;
    }

    public void eliminarParticipante(long id) {
        Participante p = em.find(Participante.class, id);
       em.remove(p);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ParticipanteDTO> buscarParticipanteTodos() {
        return em.createNamedQuery("Participante.findAll", ParticipanteDTO.class)
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ParticipanteDTO> buscarParticipanteNombre(String nombre) {
        return em.createNamedQuery("Participante.Participante.findByNombre", ParticipanteDTO.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }
}
