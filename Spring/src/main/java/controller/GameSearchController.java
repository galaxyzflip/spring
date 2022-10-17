package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.SearchCommand;
import service.SearchResult;
import service.SearchService;
import service.SearchType;

@Controller
public class GameSearchController {

	
	private SearchService searchService;
	
	@ModelAttribute("searchTypeList")
	public List<SearchType> referenceSearchTypeList(){
		
		List<SearchType> options = new ArrayList<>();
		
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "아이템"));
		options.add(new SearchType(3, "캐릭터"));
		
		return options;
	}
	
	@ModelAttribute("popularQueryList")
	public String[] getPopularQueryLists() {
		return new String[] {"게임", "창천2", "위메이드"};
	}
	
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	
	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
		
		ModelAndView mav = new ModelAndView("search/game");
		System.out.println("검색어 = " + command.getQuery().toUpperCase());
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult", result);
		
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
		public String handleNullPointerExcetpion(NullPointerException ex) {
		return "error/nullException";
	}
	
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	
	
	
	
	
	
	
	
}
