package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Board;
import com.revature.model.Card;
import com.revature.model.SwimLane;
import com.revature.model.Task;
import com.revature.service.BoardServiceContract;
import com.revature.service.CardServiceContract;
import com.revature.service.SwimLaneServiceContract;
import com.revature.service.TaskServiceContract;
import com.revature.service.UserBoardsService;

@RestController
@CrossOrigin
public class CreateCtrl {
	
	@Autowired
	TaskServiceContract taskService;
	
	@Autowired
	BoardServiceContract boardSer;
	
	@Autowired
	UserBoardsService relationService;
	
	@PostMapping("/createTask/{cId}")
	public Task createTask(@RequestBody Task t, @PathVariable int cId) {
		return taskService.createTask(t.getDescription(), cId);
	}
	
	@PostMapping("/create/board/{userId}")
	public Board makeBoard(@RequestBody Board board, @PathVariable int userId) 
	{
		return relationService.saveBoard(board, userId);
	}
	
	@Autowired
	SwimLaneServiceContract swimLaneSer;
	
	@PostMapping("/createSwimLane/{boardId}")
	public void makeSwimLane(@RequestBody SwimLane swimLane, @PathVariable int boardId) {
		
		swimLaneSer.createSwimLane(swimLane, boardId);
	}
	
	@Autowired
	CardServiceContract cardSer;

	@PostMapping("/createCard/{swimLaneId}")
	public void makeCard(@RequestBody Card card, @PathVariable int swimLaneId) {
		
		cardSer.createCard(card, swimLaneId);
	}


}
