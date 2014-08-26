package pl.pawel.extranet.service;

import java.util.List;

import pl.pawel.extranet.abstracts.IGenericService;
import pl.pawel.extranet.model.League;

public interface ILeagueService extends IGenericService<League> {

	public List<Long> findDistricts(League League);
}
