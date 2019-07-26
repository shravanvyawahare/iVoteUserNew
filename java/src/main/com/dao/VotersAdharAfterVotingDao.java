package com.dao;

import java.util.List;

import com.model.VotersAdharAfterVoting;

public interface VotersAdharAfterVotingDao {

	public int insertAdharCard(VotersAdharAfterVoting voterAdhar);
	public List<String> showAll(String AdharCard );
}
