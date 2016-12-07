package com.workforce.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.workforce.models.ProgrammingLanguageModel;
import com.workforce.repositories.ProgrammingLanguageRepository;

public class GetProgrammingLanguages extends ActionSupport{
	
	private List<ProgrammingLanguageModel> programmingLanguageList = new ArrayList<ProgrammingLanguageModel>();
	private ProgrammingLanguageRepository _programmingLanguageRepository = new ProgrammingLanguageRepository();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ProgrammingLanguageModel programmingLanguageModel = new ProgrammingLanguageModel();
		programmingLanguageList = _programmingLanguageRepository.GetList(programmingLanguageModel);
		
		return SUCCESS;
	}
	
	public List<ProgrammingLanguageModel> getProgrammingLanguageList() {
		return programmingLanguageList;
	}
}
