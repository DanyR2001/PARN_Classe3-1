package candidatura.service;

import annuncio.service.AnnuncioService;
import annuncio.service.AnnuncioServiceInterface;
import candidatura.dao.CandidaturaDAO;
import storage.entity.Annuncio;
import storage.entity.Candidatura;
import storage.entity.Persona;

import java.sql.SQLException;
import java.util.List;

import static net.sf.saxon.om.EnumSetTool.except;

public class CandidaturaService implements CandidaturaServiceInterface{

    private final CandidaturaDAO candidaturaDAO = new CandidaturaDAO();

    @Override
    public List<Candidatura> getCandidatureByAnnuncio(Annuncio annuncio) {
        try {
            return candidaturaDAO.getCandidatureByAnnuncio(annuncio);
        } catch (SQLException e){
            return null;
        }
    }

    @Override
    public Candidatura getCandidaturaByPersonaAndAnnuncio(Persona persona, Annuncio annuncio) {
        try {
            return candidaturaDAO.getCandidaturaByPersonaAndAnnuncio(persona, annuncio);
        } catch (SQLException e){
            return null;
        }
    }

    @Override
    public List<Candidatura> getCandidatueByPersona(Persona persona) {
        try {
            return candidaturaDAO.getCandidatueByPersona(persona);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean creaCandidatura(Candidatura candidatura) {
        try {
            candidaturaDAO.creaCandidatura(candidatura);
        }
        catch (SQLException e){
            return false;
        }
        return true;
    }

    /**
     * @param candidatura 
     * @return
     */
    @Override
    public boolean eliminaCandidatura(Candidatura candidatura) {
        try {
            candidaturaDAO.eliminaCandidatura(candidatura);
        }
        catch (SQLException e){
            return false;
        }
        return true;
    }


}
