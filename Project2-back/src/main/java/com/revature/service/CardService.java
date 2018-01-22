package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CardDao;
import com.revature.dao.SwimLaneDao;
import com.revature.model.Board;
import com.revature.model.Card;
import com.revature.model.SwimLane;

@Service
public class CardService implements CardServiceContract {

	@Autowired
	CardDao cardDao;
	
	@Autowired
	SwimLaneDao swimLaneDao;
	
	@Override
	public void createCard(String cardTitle, int swimLaneId, int difficulty, String description) {
		
		
		Card card = new Card();
		card.setTitle(cardTitle);
		card.setDifficulty(difficulty);
		card.setDescription(description);
	
		
		SwimLane selectedSwimLane = swimLaneDao.findOne(swimLaneId);
		List<Card> cardList = selectedSwimLane.getCards();
		int order = 0;
		
		for(int i=0; i<cardList.size(); i++) {
			if(order < cardList.get(i).getOrder()) {
				order = cardList.get(i).getOrder();
			}
		}
		
		card.setOrder(order + 1);
		cardDao.save(card);
		cardList.add(card);
		selectedSwimLane.setCards(cardList);
		swimLaneDao.save(selectedSwimLane);
	}

	public void deleteCard(int cid) 
	{
		cardDao.delete(cid);
	}

}