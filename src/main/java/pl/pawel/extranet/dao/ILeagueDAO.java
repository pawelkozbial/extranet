package pl.pawel.extranet.dao;

import java.util.List;

import pl.pawel.extranet.abstracts.IGenericDAO;
import pl.pawel.extranet.model.League;

public interface ILeagueDAO extends IGenericDAO<League> {

	public List<Long> findDistricts(League lague);
}
